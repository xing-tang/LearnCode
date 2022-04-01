package com.open.lifecycle.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * LifecycleTestView
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class LifecycleTestView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    lifecycleOwner: LifecycleOwner
) : View(context, attrs, defStyleAttr), LifecycleEventObserver {

    init {
        // Do something init
        Log.d("LifecycleTestView", "Init-------")
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                release()
                source.lifecycle.removeObserver(this)
            }
        }
    }

    private fun release() {
        // Do something release
        Log.d("LifecycleTestView", "Release-------")
    }
}