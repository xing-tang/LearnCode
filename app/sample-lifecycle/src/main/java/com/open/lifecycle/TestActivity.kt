package com.open.lifecycle

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class TestActivity : Activity(), LifecycleOwner {

    private lateinit var mLifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLifecycleRegistry = LifecycleRegistry(this)
        mLifecycleRegistry.currentState = Lifecycle.State.CREATED
        lifecycle.addObserver(LifecycleEventObserver { source, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    Log.d("TestActivity", "ON_START: ")
                }
                Lifecycle.Event.ON_STOP -> {
                    Log.d("TestActivity", "ON_STOP: ")
                }
            }
        })
    }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }

    override fun onStart() {
        super.onStart()
        mLifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    override fun onPause() {
        super.onPause()
        mLifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    override fun onDestroy() {
        super.onDestroy()
        mLifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }
}

//class TestActivity : Activity() , LifecycleOwner{
//
//    private val mLifecycleRegistry = LifecycleRegistry(this)
//
//    @SuppressLint("RestrictedApi")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        ReportFragment.injectIfNeededIn(this)
//        setContentView(R.layout.activity_test)
//        lifecycle.addObserver(LifecycleEventObserver { source, event ->
//            when (event) {
//                Lifecycle.Event.ON_START -> {
//                    Log.d("TestActivity", "ON_START: ")
//                }
//                Lifecycle.Event.ON_STOP -> {
//                    Log.d("TestActivity", "ON_STOP: ")
//                }
//            }
//        })
//    }
//
//    override fun getLifecycle(): Lifecycle {
//        return mLifecycleRegistry
//    }
//}