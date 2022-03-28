package com.open.common.base

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import com.alibaba.android.arouter.launcher.ARouter

/**
 * BaseApplication
 *
 * @Description: Application 的基类
 * @Author: xing.tang
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 这两行必须写在 init 之前，否则这些配置在 init 过程中将无效
        if (isApkInDebug(this)) {
            ARouter.openLog()// 打印日志
            ARouter.openDebug()// 开启调试模式(如果在 InstantRun 模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)// 尽可能早，推荐在 Application 中初始化
    }

    open fun isApkInDebug(context: Context): Boolean {
        return try {
            val info: ApplicationInfo = context.applicationInfo
            info.flags and ApplicationInfo.FLAG_DEBUGGABLE !== 0
        } catch (e: Exception) {
            false
        }
    }
}