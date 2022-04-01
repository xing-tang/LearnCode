package com.open.common.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType


inline fun <V : ViewBinding> Any.getViewBinding(inflater: LayoutInflater, position: Int = 0): V {
    val vClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<*>>()
    val inflate = vClass[position].getDeclaredMethod("inflate", LayoutInflater::class.java)
    return inflate.invoke(null, inflater) as V
}

inline fun <V : ViewBinding> Any.getViewBinding(inflater: LayoutInflater, container: ViewGroup?, position: Int = 0): V {
    val vbClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments.filterIsInstance<Class<V>>()
    val inflate = vbClass[position].getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
    return inflate.invoke(null, inflater, container, false) as V
}

