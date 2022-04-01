package com.open.lifecycle.recycler

import android.util.Log
import android.view.View
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.Job

/**
 * ViewStateListener
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class ViewStateListener(
    private val view: View,
    private val job: Job
) : View.OnAttachStateChangeListener, CompletionHandler {
    override fun onViewDetachedFromWindow(v: View) {
        view.removeOnAttachStateChangeListener(this)
        Log.d("ViewStateListener", "release")
        job.cancel()
    }

    override fun onViewAttachedToWindow(v: View) {}

    override fun invoke(cause: Throwable?) {
        view.removeOnAttachStateChangeListener(this)
        job.cancel()
    }
}