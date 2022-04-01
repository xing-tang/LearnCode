package com.open.learncode.android.intentService

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent_service.*
import learncode.open.com.learncode.R

class IntentServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)

        tv_down.setOnClickListener {
            val list = ArrayList<String>()
            list.add("Android中Handler的使用;http://blog.csdn.net/iispring/article/details/47115879")
            list.add("深入源码解析Android中的Handler,Message,MessageQueue,Looper;http://blog.csdn.net/iispring/article/details/47180325")
            list.add("Android新线程中更新主线程UI中的View方法汇总;http://blog.csdn.net/iispring/article/details/47300819")
            list.add("Android中HandlerThread的使用及原理解析;http://blog.csdn.net/iispring/article/details/47320407")
            list.add("Android中Looper的quit方法和quitSafely方法;http://blog.csdn.net/iispring/article/details/47622705")

            val iterator = list.iterator()

            while (iterator.hasNext()) {
                val str = iterator.next()
                val splits = str.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                val name = splits[0]
                val url = splits[1]
                val intent = Intent(this, DownloadIntentService::class.java)
                intent.putExtra("name", name)
                intent.putExtra("url", url)
                // 启动IntentService
                startService(intent)
            }
        }
    }
}
