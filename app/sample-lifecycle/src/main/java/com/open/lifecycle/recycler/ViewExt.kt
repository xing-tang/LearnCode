package com.open.lifecycle.recycler

import android.view.View
import com.open.lifecycle.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

private const val TAG = R.id.autodispose_view_tag

val View.autoDisposeScope: CoroutineScope
    get() {

        val exist = getTag(TAG) as? CoroutineScope
        if (exist != null) {
            return exist
        }
        val newScope = CoroutineScope(
            SupervisorJob() +
                    Dispatchers.Main +
                    ViewAutoDisposeInterceptor(this)
        )
        setTag(TAG, newScope)
        return newScope
    }