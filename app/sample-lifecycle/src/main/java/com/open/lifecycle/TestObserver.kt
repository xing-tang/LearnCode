package com.open.lifecycle

import android.util.Log
import androidx.lifecycle.*

/**
 * TestObserver
 *
 * @Description: 自定义的 DefaultLifecycleObserver 观察者，用注解声明每个方法观察的宿主的状态
 * @Author: xing.tang
 */
class TestObserver : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("TestObserver", "onCreate: ")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("TestObserver", "onStart: ")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("TestObserver", "onResume: ")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("TestObserver", "onPause: ")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("TestObserver", "onStop: ")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("TestObserver", "onDestroy: ")
    }
}