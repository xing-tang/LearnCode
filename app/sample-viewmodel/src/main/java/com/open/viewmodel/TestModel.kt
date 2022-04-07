package com.open.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * TestModel
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class TestModel : ViewModel() {

    private val _TestLiveData = MutableLiveData<Test>()
    val testLiveData: LiveData<Test> = _TestLiveData

    init {
        // 模拟从网络加载用户数据
        _TestLiveData.postValue(Test("张三", 18))
    }

    fun loadInitData() {
        val test = _TestLiveData.value
        test?.let {
            it.age = 20
            it.name = "李四"
            _TestLiveData.value = it
        }
    }
}