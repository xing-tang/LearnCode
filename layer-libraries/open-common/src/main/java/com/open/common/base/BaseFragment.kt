package com.open.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.open.common.extensions.getViewBinding

/**
 * BaseFragment
 *
 * @Description: Fragment 的基类
 * @Author: xing.tang
 */
abstract class BaseFragment<V : ViewBinding> : Fragment() {

    /*** ContentView */
    protected lateinit var _mViewBinding: V
        private set
    protected val mViewBinding get() = _mViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _mViewBinding = getViewBinding(inflater, container)
        return _mViewBinding.root
    }
}