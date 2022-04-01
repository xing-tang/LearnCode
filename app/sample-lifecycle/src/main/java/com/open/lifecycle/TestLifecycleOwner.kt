package com.open.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * TestLifecycleOwner
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class TestLifecycleOwner : LifecycleOwner {

    private var mLifecycleRegistry: LifecycleRegistry? = null

    init {
        initLifecycle()
    }

    private fun initLifecycle() {
        mLifecycleRegistry = LifecycleRegistry(this)
    }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry!!
    }

    fun performCreate() {
        mLifecycleRegistry!!.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    fun performStart() {
        mLifecycleRegistry!!.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }
}