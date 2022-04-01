package com.open.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.open.common.extensions.getViewBinding

/**
 * BaseActivity
 *
 * @Description: Activity 的基类
 * @Author: xing.tang
 */
abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {

    /*** 提供给子类控制是否需要使用 ARouter 的 */
    open fun isOpenARouter(): Boolean = false

    /*** ContentView */
    private val _mViewBinding: V by lazy() {
        getViewBinding(layoutInflater)
    }
    protected val mViewBinding get() = _mViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isOpenARouter()) {
            // 注入参数和服务
            ARouter.getInstance().inject(this)
        }
        setContentView(_mViewBinding.root)
    }
}