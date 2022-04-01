package com.open.retrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import com.open.common.base.BaseActivity
import com.open.retrofit.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.Runnable
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
    private val baseUrl = "http://wanandroid.com/"
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initOkHttpClientAndRetrofit()
        Thread.sleep(1000)
        Log.d(TAG, "当前UI线程为：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}")
    }

    /**
     * 点击事件处理
     *
     * @param v View
     */
    fun onClick(v: View) {
        mViewBinding.tvRetrofitText.text = ""
        when (v.id) {
            R.id.btn_execute_get -> {// 同步 GET 请求
                executeGetBySync()
            }
            R.id.btn_enqueue_get -> {// 异步 GET 请求
                enqueueGetByAsync()
            }
            R.id.btn_enqueue_get_rxjava -> {// OkHttp + Retrofit + RxJava 组合的异步 GET 请求
                enqueueGetByRxJava()
            }
            R.id.btn_enqueue_get_coroutines -> {// OkHttp + Retrofit + Coroutines 组合的异步 GET 请求
                enqueueGetByCoroutines()
            }
        }
    }

    /**
     * 初始化 OkHttpClient 和 Retrofit
     */
    private fun initOkHttpClientAndRetrofit() {
        // 设置拦截器
        val httpLoggingInterceptor = HttpLoggingInterceptor() {
            Log.e("okhttp.OkHttpClient", it)
        }
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        // 1.创建 OkHttpClient 对象，其内部也是 new Builder() 然后传到有一个参数的构造方法中，也属于 Builder 模式
        val okHttpClient = OkHttpClient().newBuilder()
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
        // 2.构建 Retrofit 对象
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())// 基本属性转换器
            .addConverterFactory(GsonConverterFactory.create())// Gson 数据转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())// RxJava 适配器
            .build()
        // 3.通过动态代理获取到所定义的接口
        apiService = retrofit.create(ApiService::class.java)
    }

    /**
     * 同步 GET 请求
     */
    private fun executeGetBySync() {
        // 4.同步请求
        Thread(Runnable {
            try {
                val response: Response<String> = apiService.getArticleList1(0).execute()
                val body = response.body()
                runOnUiThread {
                    mViewBinding.tvRetrofitText.text = "onResponse: $body"
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    mViewBinding.tvRetrofitText.text = "onFailure: ${e.message}"
                }
            }
        }).start()
    }

    /**
     * 异步 GET 请求
     */
    private fun enqueueGetByAsync() {
        // 4.异步请求（Retrofit 成功或者失败的回调都自动切换到 UI 线程）
        apiService.getArticleList2(0).enqueue(object : Callback<ApiResponse<ArticleList>> {

            /**
             * 请求成功的回调方法
             *
             * @param call Call<ApiResponse<ArticleList>>
             * @param response Response<ApiResponse<ArticleList>>
             */
            override fun onResponse(
                call: Call<ApiResponse<ArticleList>>,
                response: Response<ApiResponse<ArticleList>>
            ) {
                mViewBinding.tvRetrofitText.text = "onResponse: ${response.body()?.requireData}"
            }

            /**
             * 请求失败的回调方法
             *
             * @param call Call<ApiResponse<ArticleList>>
             * @param t Throwable
             */
            override fun onFailure(call: Call<ApiResponse<ArticleList>>, t: Throwable) {
                mViewBinding.tvRetrofitText.text = "onFailure: ${t.message}"
            }
        })
    }

    /**
     * OkHttp + Retrofit + RxJava 组合的异步 GET 请求
     */
    private fun enqueueGetByRxJava() {
        // 4.OkHttp + Retrofit + RxJava
        apiService.getArticleList3(0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mViewBinding.tvRetrofitText.text = "onResponse: ${it.requireData}"
            }, {
                it.printStackTrace()
                mViewBinding.tvRetrofitText.text = "onFailure: ${it.message}"
            })
    }

    /**
     * OkHttp + Retrofit + Coroutines 组合的异步 GET 请求
     */
    private fun enqueueGetByCoroutines() {
        // 4.OkHttp + Retrofit + Coroutines
        val job: Job = GlobalScope.launch {
            try {
                val apiResponse = apiService.getArticleList4(0)
                withContext(Dispatchers.Main) {
                    mViewBinding.tvRetrofitText.text = "onResponse: ${apiResponse.requireData}"
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    mViewBinding.tvRetrofitText.text = "onFailure: ${e.message}"
                }
            }
        }
    }
}
