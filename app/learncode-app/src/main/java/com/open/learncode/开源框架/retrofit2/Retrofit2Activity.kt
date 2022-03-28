package com.open.learncode.开源框架.retrofit2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_retrofit2.*
import learncode.open.com.learncode.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Retrofit2Activity : AppCompatActivity() {

    private val TAG = "Retrofit2Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit2)
        Thread.sleep(1000)
        var info = "当前UI线程为：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}"
        Log.d(TAG, info)
        tv_retrofit2_text1.text = info
        retrofit2SyncTest()
        retrofit2AsyncTest()
    }

    private fun retrofit2SyncTest() {
        var baseUrl: String = "http://wanandroid.com/"
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        val testApi = retrofit.create(TestApi::class.java)
        Thread(Runnable {
            try {
                var response: Response<ChaptersResponse> = testApi.getChapters().execute()
                var data = response.body()?.data
                var info = "同步请求成功=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}，结果：$data"
                Log.d(TAG, info);
                runOnUiThread {
                    tv_retrofit2_text2.text = info
                }

            } catch (e: Exception) {
                e.printStackTrace()
                var info = "同步请求失败=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}，结果：${e.toString()}"
                Log.d(TAG, info);
                runOnUiThread {
                    tv_retrofit2_text2.text = info
                }
            }
        }).start()
    }

    private fun retrofit2AsyncTest() {
        var baseUrl: String = "http://wanandroid.com/"
        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        val testApi = retrofit.create(TestApi::class.java)
        testApi.getChapters().enqueue(object : Callback<ChaptersResponse> {
            // 成功的回调，Retrofit成功或者失败的回调都自动切换到UI线程
            override fun onResponse(call: Call<ChaptersResponse>, response: Response<ChaptersResponse>) {
                val data = response.body()?.data
                var info = "异步请求成功=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}，结果：$data"
                Log.d(TAG, info);
                tv_retrofit2_text2.text = info
            }

            override fun onFailure(call: Call<ChaptersResponse>, t: Throwable) {
                t.printStackTrace()
                var info = "异步请求失败=》当前线程：id=${Thread.currentThread().id}，name=${Thread.currentThread().name}，结果：${t.toString()}"
                Log.d(TAG, info)
                tv_retrofit2_text2.text = info
            }
        })
    }
}
