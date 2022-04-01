package com.open.okhttp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.open.common.base.BaseActivity
import com.open.library.util.code.ResourceUtils
import com.open.okhttp.databinding.ActivityMainBinding
import okhttp3.*
import okhttp3.FormBody
import okhttp3.Headers.Companion.headersOf
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.create
import okhttp3.logging.HttpLoggingInterceptor
import okio.BufferedSink
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * MainActivity
 *
 * @Description: 注意事项：
 * Android 9 (Pie)（>=28）及其之后，okhttp 不再允许 http 请求，只允许 https 请求，但是可以更改
 * 1、AndroidManifest.xml 文件，在 application 元素中添加：android:usesCleartextTraffic="true"
 * 2、将 targetSdkVersion 降到 Android 8.1 (Oreo)（<=27）
 * @Author: xing.tang
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = "MainActivity"
    private val url1 = "https://wanandroid.com/wxarticle/chapters/json"
    private val url2 = "https://api.github.com/markdown/raw"
    private val url3 = "https://en.wikipedia.org/w/index.php"
    private val url4 = "https://api.imgur.com/3/image"
    private lateinit var mdFile: File
    private lateinit var imageFile: File
    private lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        copyFileFromAssets()
        initOkHttpClient()
        Thread.sleep(1000)
        Log.d(TAG, "当前UI线程为：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}")
    }

    /**
     * TODO：拷贝不成功，待完善
     * 从 assets 中拷贝文件到 SD 下
     */
    private fun copyFileFromAssets() {
        mdFile = File(filesDir.absolutePath.toString() + File.separator + "test/test.md")
        imageFile = File(filesDir.absolutePath.toString() + File.separator + "test/test.png")
        val file: File = File(filesDir.absolutePath.toString() + File.separator + "test/test.md")
        // val file: File = getDir("test", MODE_PRIVATE)
        if (!file.exists()) {
            file.mkdirs()
        }
        ResourceUtils.copyFileFromAssets("test/test.md", file.absolutePath)
    }

    /**
     * 点击事件处理
     *
     * @param v View
     */
    fun onClick(v: View) {
        mViewBinding.tvOkhttpText.text = ""
        when (v.id) {
            R.id.btn_execute_get -> {// 同步 GET 请求
                executeGetBySync()
            }
            R.id.btn_enqueue_get -> {// 异步 GET 请求
                enqueueGetByAsync()
            }
            R.id.btn_enqueue_post_string -> {// 异步 POST 提交字符串
                enqueuePostByAsync()
            }
            R.id.btn_enqueue_post_stream -> {// 异步 POST 提交流
                enqueuePostByStream()
            }
            R.id.btn_equeue_post_file -> {// 异步 POST 文件
                equeuePostByFile()
            }
            R.id.btn_equeue_post_from -> {// 异步 POST 提交表单
                equeuePostByFrom()
            }
            R.id.btn_equeue_post_multipart -> {// 异步 POST 提交分块请求
                equeuePostByMultipart()
            }
        }
    }

    /**
     * 初始化 OkHttpClient
     */
    private fun initOkHttpClient() {
        // 设置拦截器
        val httpLoggingInterceptor = HttpLoggingInterceptor() {
            Log.e("okhttp.OkHttpClient", it)
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        // 1.创建 OkHttpClient 对象，其内部也是 new Builder() 然后传到有一个参数的构造方法中，也属于 Builder 模式
        okHttpClient = OkHttpClient().newBuilder()
            // 设置连接超时为 10 秒
            .connectTimeout(10L, TimeUnit.SECONDS)
            // 设置文件读取超时为 60 秒
            .readTimeout(60L, TimeUnit.SECONDS)
            // 设置用于读取和写入缓存响应的响应缓存为 10M
            .cache(Cache(cacheDir, 10240 * 1024))
            // 设置 http 日志拦截器
            // 使用 addInterceptor() 也可以，即为第一层自定义拦截器
            // 使用 addNetworkInterceptor() 也可，即为第六层非网页网络拦截拦截器
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    /**
     * 同步 GET 请求
     */
    private fun executeGetBySync() {
        // 2.创建 Request 对象，设置一个 url 地址和设置请求方式。
        val request = Request.Builder()
            .url(url1)
            .get() // 默认 GET 请求，可以不写
            .build()
        // 3.创建一个 Call 对象，参数就是 Request 请求对象
        val call = okHttpClient.newCall(request)
        // 4.同步调用会阻塞主线程，这边在子线程进行，较少用
        Thread(Runnable {
            try {
                // 同步调用，返回 Response，会抛出 IO 异常
                val response = call.execute()
                val data = response.body?.string()
                // 注意子线程中不能操作更新 UI
                runOnUiThread {
                    mViewBinding.tvOkhttpText.text = "onResponse: $data"
                }
            } catch (e: IOException) {
                e.printStackTrace()
                runOnUiThread {
                    mViewBinding.tvOkhttpText.text = "onFailure: ${e.message}"
                }
            }
        }).start()
    }

    /**
     * 异步 GET 请求
     */
    private fun enqueueGetByAsync() {
        // 2.创建 Request 对象，设置一个 url 地址和设置请求方式。
        val request = Request.Builder()
            .url(url1)
            .get() // 默认GET请求，可以不写
            .build()
        enqueueCallback(request)
    }

    /**
     * 统一的异步请求回调方法
     *
     * @param request Request
     */
    private fun enqueueCallback(request: Request) {
        // 3.创建一个 Call 对象，参数就是 Request 请求对象
        val call = okHttpClient.newCall(request)
        // 4.异步请求加入调度，重写回调方法
        call.enqueue(object : Callback {
            /**
             * 请求成功的回调方法
             *
             * @param call Call
             * @param response Response
             */
            override fun onResponse(call: Call, response: okhttp3.Response) {
                val data = response.body?.string()
                // 注意子线程中不能操作更新 UI
                runOnUiThread {
                    mViewBinding.tvOkhttpText.text = "onResponse: $data"
                }
            }

            /**
             * 请求失败的回调方法
             *
             * @param call Call
             * @param e IOException
             */
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                runOnUiThread {
                    mViewBinding.tvOkhttpText.text = "onFailure: ${e.message}"
                }
            }
        })
    }

    /**
     * 异步 POST 提交字符串
     */
    private fun enqueuePostByAsync() {
        val mediaType: MediaType? = "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
        val requestBody = "I am Jdqm."
        val request: Request = Request.Builder()
            .url(url2)
            .post(RequestBody.create(mediaType, requestBody))
            .build()
        enqueueCallback(request)
    }

    /**
     * 异步 POST 提交流
     */
    private fun enqueuePostByStream() {
        val requestBody: RequestBody = object : RequestBody() {
            override fun contentType(): MediaType? {
                return "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
            }

            override fun writeTo(sink: BufferedSink) {
                sink.writeUtf8("I am Jdqm.")
            }
        }
        val request: Request = Request.Builder()
            .url(url2)
            .post(requestBody)
            .build()
        enqueueCallback(request)
    }

    /**
     * 异步 POST 提交文件
     */
    private fun equeuePostByFile() {
        val mediaType = "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
        val file = File("test/test.md")
        val request: Request = Request.Builder()
            .url(url2)
            .post(RequestBody.create(mediaType, mdFile))
            .build()
        enqueueCallback(request)
    }

    /**
     * 异步 POST 提交表单
     */
    private fun equeuePostByFrom() {
        val requestBody: RequestBody = FormBody.Builder()
            .add("search", "Jurassic Park")
            .build()
        // 这里是一个外网地址，主要要翻墙
        val request: Request = Request.Builder()
            .url(url3)
            .post(requestBody)
            .build()
        enqueueCallback(request)
    }

    /**
     * 异步 POST 提交分块请求
     */
    private fun equeuePostByMultipart() {
        // Use the imgur image upload API as documented at https://api.imgur.com/endpoints/image
        val clientId = "..."
        val mediaTypeByPng = "image/png".toMediaTypeOrNull()
        val body = MultipartBody.Builder("AaB03x")
            .setType(MultipartBody.FORM)
            .addPart(
                headersOf("Content-Disposition", "form-data; name=\"title\""),
                create(null, "Square Logo"))
            .addPart(
                headersOf("Content-Disposition", "form-data; name=\"image\""),
                create(mediaTypeByPng, imageFile))
            .build()
        val request: Request = Request.Builder()
            .header("Authorization", "Client-ID $clientId")
            .url(url4)
            .post(body)
            .build()
        enqueueCallback(request)
    }
}
