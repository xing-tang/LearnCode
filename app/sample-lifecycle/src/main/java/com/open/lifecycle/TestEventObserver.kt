package com.open.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * TestEventObserver
 *
 * @Description: 自定义的 DefaultLifecycleObserver 观察者，用注解声明每个方法观察的宿主的状态
 * @Author: xing.tang
 */
class TestEventObserver : LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                Log.d("TestEventObserver", "ON_CREATE: ")
            }
            Lifecycle.Event.ON_START -> {
                Log.d("TestEventObserver", "ON_START: ")
            }
            Lifecycle.Event.ON_RESUME -> {
                Log.d("TestEventObserver", "ON_RESUME: ")
            }
            Lifecycle.Event.ON_PAUSE -> {
                Log.d("TestEventObserver", "ON_PAUSE: ")
            }
            Lifecycle.Event.ON_STOP -> {
                Log.d("TestEventObserver", "ON_STOP: ")
            }
            Lifecycle.Event.ON_DESTROY -> {
                Log.d("TestEventObserver", "ON_DESTROY: ")
            }
        }
    }
}