package com.open.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * SavedstateViewModel
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class SavedstateViewModel(val savedState: SavedStateHandle) : ViewModel() {

    private val KEY_HOME_PAGE_DATA = "key_home_page_data"
    private val _TestLiveData = MutableLiveData<Test>()
    val testLiveData: LiveData<Test> = _TestLiveData

    fun loadInitData() {
        // 1. 从内存中获取数据
        if (_TestLiveData.value == null) {
            val memoryData = savedState.get<Test>(KEY_HOME_PAGE_DATA)
            memoryData?.let {
                _TestLiveData.postValue(it)
                return
            }
        }
        // 2. 从网络中获取数据
        val remotoData = Test("SavedState", 18)// 模拟从网络加载用户数据
        savedState.set(KEY_HOME_PAGE_DATA, remotoData)
        _TestLiveData.postValue(remotoData)
    }
}