package com.open.common.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter

/**
 * BaseActivity
 *
 * @Description: Activity 的基类
 * @Author: xing.tang
 */
abstract class BaseActivity<V : ViewBinding> : AppCompatActivity() {

    /*** ContentView */
    private lateinit var _mViewBinding: V
    protected val mViewBinding get() = _mViewBinding

    /**
     * 绑定布局，如果 [bindingView] 返回 null, 框架则不会调用 [Activity.setContentView]
     *
     * @param inflater LayoutInflater
     * @return V?
     */
    abstract fun bindingView(inflater: LayoutInflater): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 注入参数和服务
        ARouter.getInstance().inject(this)
        setContentView(layoutInflater)
    }

    /**
     * 设置内容视图
     *
     * @param inflater LayoutInflater
     * @return View?
     */
    private fun setContentView(inflater: LayoutInflater): View? {
        try {
            _mViewBinding = bindingView(inflater)
            setContentView(_mViewBinding.root)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}