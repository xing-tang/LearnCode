package com.open.learncode.android.view的事件分发

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import learncode.open.com.learncode.R

class ViewTouchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_touch)
        savedInstanceState?:null
        savedInstanceState!!.getBundle("")
    }
}