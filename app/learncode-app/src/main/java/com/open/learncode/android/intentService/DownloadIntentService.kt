package com.open.learncode.android.intentService


import android.app.IntentService
import android.content.Intent
import android.util.Log

import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class DownloadIntentService : IntentService {

    companion object {
        private val TAG: String = "IntentService"
    }

    constructor() : super("Download") {
        Log.i(TAG, "DownloadIntentService构造函数, Thread: " + Thread.currentThread().getName());
    }

    override fun onCreate() {
        super.onCreate()
        // 只要第一次startService()才会执行
        Log.i(TAG, "DownloadIntentService -> onCreate, Thread: " + Thread.currentThread().name)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // 每次startService都会被执行
        Log.i(TAG, "DownloadIntentService -> onStartCommand, Thread: " + Thread.currentThread().name + " , startId: " + startId)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
        // 每次startService都会被执行，这是子线程，可以在此执行耗时操作
        var conn: HttpURLConnection? = null
        var inputStream: InputStream? = null
        val blogUrl = intent?.getStringExtra("url")
        val blogName = intent?.getStringExtra("name")
        try {
            // 下载指定的文件
            val url = URL(blogUrl)
            conn = url.openConnection() as HttpURLConnection
            conn?.let {
                // 我们在此处得到所下载文章的输入流，可以将其以文件的形式写入到存储卡上面或
                // 将其读取出文本显示在App中
                inputStream = conn.inputStream
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            conn?.disconnect()
            inputStream?.close()
        }
        Log.i(TAG, "DownloadIntentService -> onHandleIntent, Thread: " + Thread.currentThread().name + ", 《" + blogName + "》下载完成")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "DownloadIntentService -> onDestroy, Thread: " + Thread.currentThread().name)
    }
}