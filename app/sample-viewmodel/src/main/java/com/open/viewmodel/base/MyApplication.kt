package com.open.viewmodel.base

import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.open.common.base.BaseApplication


/**
 * MyApplication
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class MyApplication : BaseApplication(), ViewModelStoreOwner {

    override fun isOpenARouter(): Boolean = false

    private val applicationViewModelStore: ViewModelStore by lazy {
        ViewModelStore()
    }

    override fun getViewModelStore(): ViewModelStore = applicationViewModelStore
}