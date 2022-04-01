package com.open.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.open.common.base.BaseActivity
import com.open.lifecycle.databinding.ActivityMainBinding
import com.open.lifecycle.recycler.RecyclerActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun isOpenARouter(): Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 方式一：观察宿主的生命周期状态
        lifecycle.addObserver(TestObserver())
        // 方式二：观察宿主的生命周期状态的两种写法
        lifecycle.addObserver(TestEventObserver())
        lifecycle.addObserver(LifecycleEventObserver { source, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    Log.d("MainActivity", "ON_START: ")
                }
                Lifecycle.Event.ON_STOP -> {
                    Log.d("MainActivity", "ON_STOP: ")
                }
            }
        })
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btn_jump_test -> {
                startActivity(Intent(this, TestActivity::class.java))
            }
            R.id.btn_jump_recycler -> {
                startActivity(Intent(this, RecyclerActivity::class.java))
            }
        }
    }
}