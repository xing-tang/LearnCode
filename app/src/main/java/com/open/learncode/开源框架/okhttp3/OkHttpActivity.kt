package com.open.learncode.开源框架.okhttp3

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_okhttp.*
import learncode.open.com.learncode.R
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class OkHttpActivity : AppCompatActivity() {

    private val TAG = "OkHttpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)
        Thread.sleep(1000)
        // 注意事项：Android 9 (Pie)（>=28）及其之后，okhttp不再允许http请求，只允许https请求，但是可以更改
        // 1、AndroidManifest.xml文件，在application元素中添加：android:usesCleartextTraffic="true"
        // 2、将targetSdkVersion降到Android 8.1 (Oreo)（<=27）
        Log.d(TAG, "当前UI线程为：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}")
        okhttpSyncTest()
        okhttpAsyncTest()
//        retrofitTest()
    }

    /**
     * 同步GET请求
     */
    fun okhttpSyncTest() {
        // 1.创建OkHttpClient对象，其内部也是new Builder()然后传到有一个参数的构造方法中，
        // 也属于Builder模式
        val okHttpClient = OkHttpClient()
        // 2.创建Request对象，设置一个url地址和设置请求方式。
        val request = Request.Builder()
            .url("http://wanandroid.com/wxarticle/chapters/json")
            .get()// 默认GET请求，可以不写
            .build()
        // 3.创建一个Call对象，参数就是Request请求对象
        val call = okHttpClient.newCall(request)
        // 4.同步调用会阻塞主线程，这边在子线程进行，较少用
        Thread(Runnable {
            try {
                // 同步调用，返回Response，会抛出IO异常
                val response = call.execute()
                val data = response.body()?.string()
                Log.d(TAG, "同步请求成功=》$data");
                Log.d(TAG, "同步请求成功=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}")
                // 注意子线程中不能操作更新UI
                runOnUiThread {
                    //Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
                    tv_text.text = "同步请求成功=》$data"
                }
            } catch (e: IOException) {
                e.printStackTrace()
                Log.d(TAG, "同步请求失败=》${e.toString()}");
                Log.d(TAG, "同步请求失败=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}")
                tv_text.text = "同步请求失败=》${e.toString()}"
            }
        }).start()
    }

    /**
     * 异步GET请求
     */
    fun okhttpAsyncTest() {
        // 1.创建OkHttpClient对象，其内部也是new Builder()然后传到有一个参数的构造方法中，
        // 也属于Builder模式
        val okHttpClient = OkHttpClient()
        // 2.创建Request对象，设置一个url地址和设置请求方式。
        val request = Request.Builder()
            .url("http://wanandroid.com/wxarticle/chapters/json")
            .get()// 默认GET请求，可以不写
            .build()
        // 3.创建一个Call对象，参数就是Request请求对象
        val call = okHttpClient.newCall(request)
        // 4.异步请求加入调度，重写回调方法
        call.enqueue(object : Callback {
            // 请求成功执行的方法
            override fun onResponse(call: Call, response: Response) {
                val data = response.body()?.string()
                Log.d(TAG, "异步请求成功=》$data");
                Log.d(TAG, "异步请求成功=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}")
                // 注意子线程中不能操作更新UI
                runOnUiThread {
                    //Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show()
                    tv_text.text = "异步请求成功=》$data"
                }
            }

            // 请求失败执行的方法
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Log.d(TAG, "异步请求失败=》${e.toString()}");
                Log.d(TAG, "异步请求失败=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}")
                tv_text.text = "异步请求失败=》${e.toString()}"
            }

        })
    }

    fun okhttpAsyncBuild() {
//        val newClient = OkHttpClient().newBuilder()
//            .cache(Cache(mContext.cacheDir, 10240 * 1024))
//            .connectTimeout(20, TimeUnit.SECONDS)
//            .readTimeout(20, TimeUnit.SECONDS)
//            .build()
    }

    fun okhttpTest() {
        val url = "http://wanandroid.com/wxarticle/chapters/json  "
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        val call = okHttpClient.newCall(request)
        println("当前线程：" + Thread.currentThread().name)
        Thread(Runnable {
            try {
                // 同步请求
                call.execute()
                println("同步请求=》当前线程：" + Thread.currentThread().name)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }).start()
        // 异步请求
        call.enqueue(object : Callback {
            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                Log.d("TAG", "onResponse: " + response.body()!!.string())
                Log.d("TAG", "异步请求成功=》当前线程：" + Thread.currentThread().name)
                tv_text.text = "请求成功"
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("TAG", "onFailure: ")
                Log.d("TAG", "异步请求失败=》当前线程：" + Thread.currentThread().name)
                tv_text.text = "请求失败"
            }
        })
    }

    private fun retrofitTest() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://image.so.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val imageService: ImageService = retrofit.create<ImageService>(ImageService::class.java)
//        Thread(Runnable {
//            try {
//                // 同步请求
//                imageService.getImageResponse("北京", 0, 20).execute();
//                Log.d("TAG", "同步请求=》当前线程：" + Thread.currentThread().name)
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }).start()

        Log.d("TAG", "异步请求成功=》当前线程：" + Thread.currentThread().name)
        imageService.getImageResponse("北京", 0, 20)
            .enqueue(object : retrofit2.Callback<ImageResponse> {
                override fun onResponse(
                    call: retrofit2.Call<ImageResponse>,
                    response: retrofit2.Response<ImageResponse>
                ) {
                    Log.d("TAG", "onResponse: " + response.body().toString())
                    Log.d("TAG", "异步请求成功=》当前线程：" + Thread.currentThread().name)
                    tv_text.text = "请求成功"

                }

                override fun onFailure(call: retrofit2.Call<ImageResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                    Log.d("TAG", "异步请求失败=》当前线程：" + Thread.currentThread().name)
                    tv_text.text = "请求失败"
                }
            })
    }
}
