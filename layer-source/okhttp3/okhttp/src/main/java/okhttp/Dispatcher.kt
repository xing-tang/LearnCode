/*
 * Copyright (C) 2013 Square, Inc.
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
package okhttp3

import java.util.ArrayDeque
import java.util.Collections
import java.util.Deque
import java.util.concurrent.ExecutorService
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import okhttp3.internal.assertThreadDoesntHoldLock
import okhttp3.internal.connection.RealCall
import okhttp3.internal.connection.RealCall.AsyncCall
import okhttp3.internal.okHttpName
import okhttp3.internal.threadFactory

/**
 * Policy on when async requests are executed.
 *
 * Each dispatcher uses an [ExecutorService] to run calls internally. If you supply your own
 * executor, it should be able to run [the configured maximum][maxRequests] number of calls
 * concurrently.
 */
class Dispatcher constructor() {
  /**
   * The maximum number of requests to execute concurrently. Above this requests queue in memory,
   * waiting for the running calls to complete.
   *
   * If more than [maxRequests] requests are in flight when this is invoked, those requests will
   * remain in flight.
   */
  // 并发执行的最大请求数
  @get:Synchronized var maxRequests = 64
    set(maxRequests) {
      require(maxRequests >= 1) { "max < 1: $maxRequests" }
      synchronized(this) {
        field = maxRequests
      }
      promoteAndExecute()
    }

  /**
   * The maximum number of requests for each host to execute concurrently. This limits requests by
   * the URL's host name. Note that concurrent requests to a single IP address may still exceed this
   * limit: multiple hostnames may share an IP address or be routed through the same HTTP proxy.
   *
   * If more than [maxRequestsPerHost] requests are in flight when this is invoked, those requests
   * will remain in flight.
   *
   * WebSocket connections to hosts **do not** count against this limit.
   */
  // 每个主机并发执行的最大请求数
  @get:Synchronized var maxRequestsPerHost = 5
    set(maxRequestsPerHost) {
      require(maxRequestsPerHost >= 1) { "max < 1: $maxRequestsPerHost" }
      synchronized(this) {
        field = maxRequestsPerHost
      }
      promoteAndExecute()
    }

  /**
   * A callback to be invoked each time the dispatcher becomes idle (when the number of running
   * calls returns to zero).
   *
   * Note: The time at which a [call][Call] is considered idle is different depending on whether it
   * was run [asynchronously][Call.enqueue] or [synchronously][Call.execute]. Asynchronous calls
   * become idle after the [onResponse][Callback.onResponse] or [onFailure][Callback.onFailure]
   * callback has returned. Synchronous calls become idle once [execute()][Call.execute] returns.
   * This means that if you are doing synchronous calls the network layer will not truly be idle
   * until every returned [Response] has been closed.
   */
  @set:Synchronized
  @get:Synchronized
  var idleCallback: Runnable? = null

  /** 正在运行的同步请求队列 */
  private val runningSyncCalls = ArrayDeque<RealCall>()

  /** 正在运行的异步请求队列 */
  private val runningAsyncCalls = ArrayDeque<AsyncCall>()

  /** 准备执行的异步请求队列 */
  private val readyAsyncCalls = ArrayDeque<AsyncCall>()

  /** 线程池 */
  private var executorServiceOrNull: ExecutorService? = null

  /**
   * 参数1：线程池中核心线程的最大数量；参数2：线程池中允许的最大线程数；
   * 参数3：空闲线程的存活时间；参数4：空闲线程存活的时间单位，与 keepAliveTime 配合使用；
   * 参数5：阻塞队列；参数6：指定创建线程的工厂；
   * </p>
   * 该线程池的核心线程数为 0，线程池最有能容纳 Integer.MAX_VALUE 个线程，且线程的空闲存活时间
   * 为 60s（可以理解为 okhttp 随时可以创建新的线程来满足需要，可以保证网络的I/O任务有线程来处理
   *，不被阻塞），使用的等待队列即 SynchronousQueue。
   * </p>
   * SynchornousQueue：内部没有任何缓存的阻塞队列。这里表示接到新任务，直接交给线程处理，如果其
   * 他的线程都在工作，那就创建一个新的线程来处理这个任务。
   */
  @get:Synchronized
  @get:JvmName("executorService") val executorService: ExecutorService
    get() {
      if (executorServiceOrNull == null) {
        executorServiceOrNull = ThreadPoolExecutor(0, Int.MAX_VALUE, 60, TimeUnit.SECONDS,
            SynchronousQueue(), threadFactory("$okHttpName Dispatcher", false))
      }
      return executorServiceOrNull!!
    }

  constructor(executorService: ExecutorService) : this() {
    this.executorServiceOrNull = executorService
  }

  internal fun enqueue(call: AsyncCall) {
    // 加锁，保证线程安全
    synchronized(this) {
      // 将该请求调用加入到"准备执行的异步请求队列"中
      readyAsyncCalls.add(call)

      // Mutate the AsyncCall so that it shares the AtomicInteger of an existing running call to
      // the same host.
      if (!call.call.forWebSocket) {
        // 通过域名来查找有没有相同域名的请求，有则复用
        val existingCall = findExistingCallWithHost(call.host)
        if (existingCall != null) call.reuseCallsPerHostFrom(existingCall)
      }
    }
    // 执行请求
    promoteAndExecute()
  }

  private fun findExistingCallWithHost(host: String): AsyncCall? {
    for (existingCall in runningAsyncCalls) {
      if (existingCall.host == host) return existingCall
    }
    for (existingCall in readyAsyncCalls) {
      if (existingCall.host == host) return existingCall
    }
    return null
  }

  /**
   * Cancel all calls currently enqueued or executing. Includes calls executed both
   * [synchronously][Call.execute] and [asynchronously][Call.enqueue].
   */
  @Synchronized fun cancelAll() {
    for (call in readyAsyncCalls) {
      call.call.cancel()
    }
    for (call in runningAsyncCalls) {
      call.call.cancel()
    }
    for (call in runningSyncCalls) {
      call.cancel()
    }
  }

  /**
   * Promotes eligible calls from [readyAsyncCalls] to [runningAsyncCalls] and runs them on the
   * executor service. Must not be called with synchronization because executing calls can call
   * into user code.
   *
   * @return true if the dispatcher is currently running calls.
   */
  private fun promoteAndExecute(): Boolean {
    this.assertThreadDoesntHoldLock()

    val executableCalls = mutableListOf<AsyncCall>()
    // 判断是否有请求正在执行
    val isRunning: Boolean
    // 加锁，保证线程安全
    synchronized(this) {
      // 遍历"准备执行的异步请求队列"
      val i = readyAsyncCalls.iterator()
      while (i.hasNext()) {
        val asyncCall = i.next()
        // "正在运行的异步请求队列"的数量大于最大并发请求数 64，则完全中断循环
        if (runningAsyncCalls.size >= this.maxRequests) break // Max capacity.
        // 同域名最大请求数 5，同一个域名最多允许 5 条线程同时执行请求，超过则终止本次循环，进入下次 while 循环
        if (asyncCall.callsPerHost.get() >= this.maxRequestsPerHost) continue // Host max capacity.
        // 从"准备执行的异步请求队列"中移除，并加入到 executableCalls 及 runningAsyncCalls 队列中
        i.remove()
        asyncCall.callsPerHost.incrementAndGet()
        executableCalls.add(asyncCall)
        runningAsyncCalls.add(asyncCall)
      }
      // 通过运行队列中的请求数量来判断是否有请求正在执行
      isRunning = runningCallsCount() > 0
    }
    // 遍历可执行队列，调用线程池来执行 AsyncCall
    for (i in 0 until executableCalls.size) {
      val asyncCall = executableCalls[i]
      asyncCall.executeOn(executorService)
    }

    return isRunning
  }

  /** Used by [Call.execute] to signal it is in-flight. */
  @Synchronized internal fun executed(call: RealCall) {
    runningSyncCalls.add(call)
  }

  /** Used by [AsyncCall.run] to signal completion. */
  internal fun finished(call: AsyncCall) {
    call.callsPerHost.decrementAndGet()
    finished(runningAsyncCalls, call)
  }

  /** Used by [Call.execute] to signal completion. */
  internal fun finished(call: RealCall) {
    finished(runningSyncCalls, call)
  }

  private fun <T> finished(calls: Deque<T>, call: T) {
    val idleCallback: Runnable?
    synchronized(this) {
      if (!calls.remove(call)) throw AssertionError("Call wasn't in-flight!")
      idleCallback = this.idleCallback
    }

    val isRunning = promoteAndExecute()

    if (!isRunning && idleCallback != null) {
      idleCallback.run()
    }
  }

  /** Returns a snapshot of the calls currently awaiting execution. */
  @Synchronized fun queuedCalls(): List<Call> {
    return Collections.unmodifiableList(readyAsyncCalls.map { it.call })
  }

  /** Returns a snapshot of the calls currently being executed. */
  @Synchronized fun runningCalls(): List<Call> {
    return Collections.unmodifiableList(runningSyncCalls + runningAsyncCalls.map { it.call })
  }

  @Synchronized fun queuedCallsCount(): Int = readyAsyncCalls.size

  @Synchronized fun runningCallsCount(): Int = runningAsyncCalls.size + runningSyncCalls.size

  @JvmName("-deprecated_executorService")
  @Deprecated(
      message = "moved to val",
      replaceWith = ReplaceWith(expression = "executorService"),
      level = DeprecationLevel.ERROR)
  fun executorService(): ExecutorService = executorService
}
