package com.open.learncode.开源框架.okhttp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_okhttp_test.*
import learncode.open.com.learncode.R
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class OkHttpTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp_test)
//        okhttpTest()
        retrofitTest()
    }

    fun okhttpTest() {
        val url = "http://wanandroid.com/wxarticle/chapters/json  "
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .build()
        val call = okHttpClient.newCall(request)
        println("当前线程：" + Thread.currentThread().name)
//        Thread(Runnable {
//            try {
//                // 同步请求
//                call.execute()
//                println("同步请求=》当前线程：" + Thread.currentThread().name)
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }).start()
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
                    override fun onResponse(call: retrofit2.Call<ImageResponse>, response: retrofit2.Response<ImageResponse>) {
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
