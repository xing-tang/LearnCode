package com.open.livedata.base

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
    }
}