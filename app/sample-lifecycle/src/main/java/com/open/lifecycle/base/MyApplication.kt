package com.open.lifecycle.base

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.open.common.base.BaseApplication


/**
 * MyApplication
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class MyApplication : BaseApplication() {

    override fun isOpenARouter(): Boolean = false

    override fun onCreate() {
        super.onCreate()
        // 注册 App 生命周期观察者
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }

    /**
     * Application 生命周期观察，提供整个应用进程的生命周期
     * 作用：监听应用程序进入前台或后台
     */
    private class ApplicationLifecycleObserver : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event) {
                Lifecycle.Event.ON_START -> {
                    Log.d("MyApplication", "onStateChanged: 应用程序移至前台")
                }
                Lifecycle.Event.ON_STOP -> {
                    Log.d("MyApplication", "onStateChanged: 应用程序移至后台")
                }
            }
        }
    }
}