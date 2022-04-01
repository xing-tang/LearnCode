/*
 * Copyright (C) 2014 Square, Inc.
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

import java.io.IOException
import okio.Timeout

/**
 * 调用是已准备好执行的请求，可以取消请求（已经完成的请求不能被取消）。
 * 由于该对象表示单个请求响应对（流），因此不能执行两次。
 */
interface Call : Cloneable {
  /** 返回发起此调用的原始请求 */
  fun request(): Request

  /**
   * Invokes the request immediately, and blocks until the response can be processed or is in error.
   *
   * To avoid leaking resources callers should close the [Response] which in turn will close the
   * underlying [ResponseBody].
   *
   * ```
   * // ensure the response (and underlying response body) is closed
   * try (Response response = client.newCall(request).execute()) {
   *   ...
   * }
   * ```
   *
   * The caller may read the response body with the response's [Response.body] method. To avoid
   * leaking resources callers must [close the response body][ResponseBody] or the response.
   *
   * Note that transport-layer success (receiving a HTTP response code, headers and body) does not
   * necessarily indicate application-layer success: `response` may still indicate an unhappy HTTP
   * response code like 404 or 500.
   *
   * @throws IOException if the request could not be executed due to cancellation, a connectivity
   *     problem or timeout. Because networks can fail during an exchange, it is possible that the
   *     remote server accepted the request before the failure.
   * @throws IllegalStateException when the call has already been executed.
   */
  /**
   * 同步请求，立即执行
   * 抛出两种异常：
   * （1）请求失败抛出 IOException；
   * （2）如果在执行过一回的前提下再次执行抛出 IllegalStateException。
   */
  @Throws(IOException::class)
  fun execute(): Response

  /**
   * Schedules the request to be executed at some point in the future.
   *
   * The [dispatcher][OkHttpClient.dispatcher] defines when the request will run: usually
   * immediately unless there are several other requests currently being executed.
   *
   * This client will later call back `responseCallback` with either an HTTP response or a failure
   * exception.
   *
   * @throws IllegalStateException when the call has already been executed.
   */
  /**
   * 异步请求，会将请求任务加入到对应的队列中再等待执行
   * 如果在执行过一回的前提下再次执行抛出 IllegalStateException。
   */
  fun enqueue(responseCallback: Callback)

  /** 取消请求，已经完成的请求不能被取消 */
  fun cancel()

  /**
   * Returns true if this call has been either [executed][execute] or [enqueued][enqueue]. It is an
   * error to execute a call more than once.
   */
  /** 是否已被执行  */
  fun isExecuted(): Boolean

    /** 是否被取消   */
  fun isCanceled(): Boolean

  /**
   * Returns a timeout that spans the entire call: resolving DNS, connecting, writing the request
   * body, server processing, and reading the response body. If the call requires redirects or
   * retries all must complete within one timeout period.
   *
   * Configure the client's default timeout with [OkHttpClient.Builder.callTimeout].
   */
  /** 请求超时时间配置 */
  fun timeout(): Timeout

  /**
   * Create a new, identical call to this one which can be enqueued or executed even if this call
   * has already been.
   */
  public override fun clone(): Call

  /** 利用工厂模式来让 OkHttpClient 来创建 Call 对象 */
  fun interface Factory {
    fun newCall(request: Request): Call
  }
}
