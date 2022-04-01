package com.open.lifecycle.recycler

import android.view.View
import kotlinx.coroutines.Job
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 * ViewAutoDisposeInterceptor
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class ViewAutoDisposeInterceptor(
    private val view: View
) : ContinuationInterceptor {
    override val key: CoroutineContext.Key<*>
        get() = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        val job = continuation.context[Job]
        if (job != null) {
            view.addOnAttachStateChangeListener(ViewStateListener(view, job))
        }
        return continuation
    }
}