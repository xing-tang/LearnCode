package com.open.learncode.android.获取View的宽高

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_get_view.*
import learncode.open.com.learncode.R

/**
 * GetViewActivity
 *
 * @Description: 获取 View 的宽高的示例 Activity
 * @Author: xing.tang
 */
class GetViewActivity : AppCompatActivity() {

    private val strb: StringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_view)
        // 获取不到 View 的宽高
        strb.append("onCreate: width=${tv_get_view.width}, height=${tv_get_view.height}\n")
        tv_get_view.text = strb.toString()
        /*** 方式一：通过 View.post() 来实现 */
        tv_get_view.post {
            strb.append("post: width=${tv_get_view.width}, height=${tv_get_view.height}\n")
            tv_get_view.text = strb.toString()
        }
        /*** 方式二：通过 ViewTreeObserver 的 OnGlobalLayoutListener 回调 */
        tv_get_view.viewTreeObserver.addOnGlobalLayoutListener {
            tv_get_view.viewTreeObserver.removeOnGlobalLayoutListener { this }
            strb.append("onGlobalLayout: width=${tv_get_view.width}, height=${tv_get_view.height}\n")
            tv_get_view.text = strb.toString()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        /*** 方式三：通过 onWindowFocusChanged() 方法 */
        if (hasFocus) {
            strb.append("onWindowFocusChanged: width=${tv_get_view.width}, height=${tv_get_view.height}\n")
            tv_get_view.text = strb.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        // 获取不到 View 的宽高
        strb.append("onResume: width=${tv_get_view.width}, height=${tv_get_view.height}\n")
        tv_get_view.text = strb.toString()
    }
}