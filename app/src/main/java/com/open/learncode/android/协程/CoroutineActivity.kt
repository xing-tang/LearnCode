package com.open.learncode.android.协程

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.*
import learncode.open.com.learncode.R

class CoroutineActivity : AppCompatActivity() {

    var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        Thread.sleep(2000)
        launch()
    }

    // launch方式创建协程
    private fun launch() {
        job = GlobalScope.launch(Dispatchers.IO) {
            var content = getNetworkJson()
            tv_text.text = "xiugai"
            Log.d("Coroutine", "111=>" + Thread.currentThread().toString())
            Log.d("Coroutine", content)
            withContext(Dispatchers.Main) {
                // 拿到数据后切换回UI线程刷新页面
                var x =1
                Log.d("Coroutine", "222=>" + Thread.currentThread().toString())
            }
        }
    }

    // runBlocking方式创建协程，注意这里会阻塞UI线程
    private fun runBlocking() {
        runBlocking(Dispatchers.IO) {
            var content = getNetworkJson()
            Log.d("Coroutine", content)
            withContext(Dispatchers.Main) {
                // 拿到数据后切换回UI线程刷新页面
            }
        }
    }

    // 模拟网络请求
    private suspend fun getNetworkJson(): String {
        return "{\"data\": \"这是网络请求数据\",\"errorCode\": 200,\"errorMsg\": \"请求成功\"}"
    }

    // 让协程运行完
//    private suspend fun join() = job?.join()

    // 取消协程
    private fun cancel() = job?.cancel()

    override fun onDestroy() {
        super.onDestroy()
        // 取消掉所有协程内容
        cancel()
    }
}
