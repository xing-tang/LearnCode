package com.open.learncode.launchmode

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

open class BaseActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("xing", javaClass.name + "=>onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.e("xing", javaClass.name +"=>onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("xing", javaClass.name +"=>onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("xing", javaClass.name +"=>onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("xing", javaClass.name +"=>onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("xing", javaClass.name +"=>onDestroy()")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("xing", javaClass.name +"=>onNewIntent()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("xing", javaClass.name +"=>onRestart()")
    }

}