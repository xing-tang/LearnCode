/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package okhttp3.internal.connection

import java.io.IOException
import java.net.Socket
import okhttp3.Address
import okhttp3.EventListener
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Route
import okhttp3.internal.canReuseConnectionFor
import okhttp3.internal.closeQuietly
import okhttp3.internal.http.ExchangeCodec
import okhttp3.internal.http.RealInterceptorChain
import okhttp3.internal.http2.ConnectionShutdownException
import okhttp3.internal.http2.ErrorCode
import okhttp3.internal.http2.StreamResetException

/**
 * Attempts to find the connections for an exchange and any retries that follow. This uses the
 * following strategies:
 *
 *  1. If the current call already has a connection that can satisfy the request it is used. Using
 *     the same connection for an initial exchange and its follow-ups may improve locality.
 *
 *  2. If there is a connection in the pool that can satisfy the request it is used. Note that it is
 *     possible for shared exchanges to make requests to different host names! See
 *     [RealConnection.isEligible] for details.
 *
 *  3. If there's no existing connection, make a list of routes (which may require blocking DNS
 *     lookups) and attempt a new connection them. When failures occur, retries iterate the list of
 *     available routes.
 *
 * If the pool gains an eligible connection while DNS, TCP, or TLS work is in flight, this finder
 * will prefer pooled connections. Only pooled HTTP/2 connections are used for such de-duplication.
 *
 * It is possible to cancel the finding process.
 *
 * Instances of this class are not thread-safe. Each instance is thread-confined to the thread
 * executing [call].
 */
class ExchangeFinder(
  private val connectionPool: RealConnectionPool,
  internal val address: Address,
  private val call: RealCall,
  private val eventListener: EventListener
) {
  private var routeSelection: RouteSelector.Selection? = null
  private var routeSelector: RouteSelector? = null
  private var refusedStreamCount = 0
  private var connectionShutdownCount = 0
  private var otherFailureCount = 0
  private var nextRouteToTry: Route? = null

  fun find(
    client: OkHttpClient,
    chain: RealInterceptorChain
  ): ExchangeCodec {
    try {
      // 查找合格可用的连接，返回一个 RealConnection 对象
      val resultConnection = findHealthyConnection(
          connectTimeout = chain.connectTimeoutMillis,
          readTimeout = chain.readTimeoutMillis,
          writeTimeout = chain.writeTimeoutMillis,
          pingIntervalMillis = client.pingIntervalMillis,
          connectionRetryEnabled = client.retryOnConnectionFailure,
          doExtensiveHealthChecks = chain.request.method != "GET"
      )
      // 根据连接，创建并返回一个请求响应编码器：Http1ExchangeCodec 或者 Http2ExchangeCodec
      // ，分别对应 Http1 协议与 Http2 协议
      return resultConnection.newCodec(client, chain)
    } catch (e: RouteException) {
      trackFailure(e.lastConnectException)
      throw e
    } catch (e: IOException) {
      trackFailure(e)
      throw RouteException(e)
    }
  }

  /**
   * Finds a connection and returns it if it is healthy. If it is unhealthy the process is repeated
   * until a healthy connection is found.
   */
  @Throws(IOException::class)
  private fun findHealthyConnection(
    connectTimeout: Int,
    readTimeout: Int,
    writeTimeout: Int,
    pingIntervalMillis: Int,
    connectionRetryEnabled: Boolean,
    doExtensiveHealthChecks: Boolean
  ): RealConnection {
    while (true) {
      // 重点：查找连接
      val candidate = findConnection(
          connectTimeout = connectTimeout,
          readTimeout = readTimeout,
          writeTimeout = writeTimeout,
          pingIntervalMillis = pingIntervalMillis,
          connectionRetryEnabled = connectionRetryEnabled
      )
      // 检查该连接是否合格可用，合格则直接返回该连接
      if (candidate.isHealthy(doExtensiveHealthChecks)) {
        return candidate
      }
      // 如果该连接不合格，标记为不可用，从连接池中移除
      candidate.noNewExchanges()

      // Make sure we have some routes left to try. One example where we may exhaust all the routes
      // would happen if we made a new connection and it immediately is detected as unhealthy.
      if (nextRouteToTry != null) continue

      val routesLeft = routeSelection?.hasNext() ?: true
      if (routesLeft) continue

      val routesSelectionLeft = routeSelector?.hasNext() ?: true
      if (routesSelectionLeft) continue

      throw IOException("exhausted all routes")
    }
  }

  /**
   * Returns a connection to host a new stream. This prefers the existing connection if it exists,
   * then the pool, finally building a new connection.
   *
   * This checks for cancellation before each blocking operation.
   */
  @Throws(IOException::class)
  private fun findConnection(
    connectTimeout: Int,
    readTimeout: Int,
    writeTimeout: Int,
    pingIntervalMillis: Int,
    connectionRetryEnabled: Boolean
  ): RealConnection {
    if (call.isCanceled()) throw IOException("Canceled")

    // 第一次，尝试重连 call 中的 connection，不需要去重新获取连接
    val callConnection = call.connection // This may be mutated by releaseConnectionNoEvents()!
    if (callConnection != null) {
      var toClose: Socket? = null
      synchronized(callConnection) {
        if (callConnection.noNewExchanges || !sameHostAndPort(callConnection.route().address.url)) {
          toClose = call.releaseConnectionNoEvents()
        }
      }

      // 如果 call 中的 connection 还没有释放，就重用它
      if (call.connection != null) {
        check(toClose == null)
        return callConnection
      }

      // 如果 call 中的 connection 已经被释放，关闭 Socket
      toClose?.closeQuietly()
      eventListener.connectionReleased(call, callConnection)
    }

    // 需要一个新的连接，所以重置一些状态
    refusedStreamCount = 0
    connectionShutdownCount = 0
    otherFailureCount = 0

    // 第二次，尝试从连接池中获取一个连接，不带路由，不带多路复用
    if (connectionPool.callAcquirePooledConnection(address, call, null, false)) {
      val result = call.connection!!
      eventListener.connectionAcquired(call, result)
      return result
    }

    // 连接池中是空的，准备下次尝试连接的路由
    val routes: List<Route>?
    val route: Route
    if (nextRouteToTry != null) {
      // Use a route from a preceding coalesced connection.
      routes = null
      route = nextRouteToTry!!
      nextRouteToTry = null
    } else if (routeSelection != null && routeSelection!!.hasNext()) {
      // Use a route from an existing route selection.
      routes = null
      route = routeSelection!!.next()
    } else {
      // Compute a new route selection. This is a blocking operation!
      var localRouteSelector = routeSelector
      if (localRouteSelector == null) {
        localRouteSelector = RouteSelector(address, call.client.routeDatabase, call, eventListener)
        this.routeSelector = localRouteSelector
      }
      val localRouteSelection = localRouteSelector.next()
      routeSelection = localRouteSelection
      routes = localRouteSelection.routes

      if (call.isCanceled()) throw IOException("Canceled")

      // 第三次，再次尝试从连接池中获取一个连接，带路由，不带多路复用
      if (connectionPool.callAcquirePooledConnection(address, call, routes, false)) {
        val result = call.connection!!
        eventListener.connectionAcquired(call, result)
        return result
      }

      route = localRouteSelection.next()
    }

    // 第四次，手动创建一个新连接
    val newConnection = RealConnection(connectionPool, route)
    call.connectionToCancel = newConnection
    try {
      newConnection.connect(
          connectTimeout,
          readTimeout,
          writeTimeout,
          pingIntervalMillis,
          connectionRetryEnabled,
          call,
          eventListener
      )
    } finally {
      call.connectionToCancel = null
    }
    call.client.routeDatabase.connected(newConnection.route())

    // 第五次，再次尝试从连接池中获取一个连接，带路由，带多路复用
    // 这一步主要是为了校验一下，比如已经有了一条连接了，就可以直接复用，而不用使用手动创建的新连接
    if (connectionPool.callAcquirePooledConnection(address, call, routes, true)) {
      val result = call.connection!!
      nextRouteToTry = route
      newConnection.socket().closeQuietly()
      eventListener.connectionAcquired(call, result)
      return result
    }

    synchronized(newConnection) {
      // 将手动创建的新连接放入连接池
      connectionPool.put(newConnection)
      call.acquireConnectionNoEvents(newConnection)
    }

    eventListener.connectionAcquired(call, newConnection)
    return newConnection
  }

  fun trackFailure(e: IOException) {
    nextRouteToTry = null
    if (e is StreamResetException && e.errorCode == ErrorCode.REFUSED_STREAM) {
      refusedStreamCount++
    } else if (e is ConnectionShutdownException) {
      connectionShutdownCount++
    } else {
      otherFailureCount++
    }
  }

  /**
   * Returns true if the current route has a failure that retrying could fix, and that there's
   * a route to retry on.
   */
  fun retryAfterFailure(): Boolean {
    if (refusedStreamCount == 0 && connectionShutdownCount == 0 && otherFailureCount == 0) {
      return false // Nothing to recover from.
    }

    if (nextRouteToTry != null) {
      return true
    }

    val retryRoute = retryRoute()
    if (retryRoute != null) {
      // Lock in the route because retryRoute() is racy and we don't want to call it twice.
      nextRouteToTry = retryRoute
      return true
    }

    // If we have a routes left, use 'em.
    if (routeSelection?.hasNext() == true) return true

    // If we haven't initialized the route selector yet, assume it'll have at least one route.
    val localRouteSelector = routeSelector ?: return true

    // If we do have a route selector, use its routes.
    return localRouteSelector.hasNext()
  }

  /**
   * Return the route from the current connection if it should be retried, even if the connection
   * itself is unhealthy. The biggest gotcha here is that we shouldn't reuse routes from coalesced
   * connections.
   */
  private fun retryRoute(): Route? {
    if (refusedStreamCount > 1 || connectionShutdownCount > 1 || otherFailureCount > 0) {
      return null // This route has too many problems to retry.
    }

    val connection = call.connection ?: return null

    synchronized(connection) {
      if (connection.routeFailureCount != 0) return null
      if (!connection.route().address.url.canReuseConnectionFor(address.url)) return null
      return connection.route()
    }
  }

  /**
   * Returns true if the host and port are unchanged from when this was created. This is used to
   * detect if followups need to do a full connection-finding process including DNS resolution, and
   * certificate pin checks.
   */
  fun sameHostAndPort(url: HttpUrl): Boolean {
    val routeUrl = address.url
    return url.port == routeUrl.port && url.host == routeUrl.host
  }
}
