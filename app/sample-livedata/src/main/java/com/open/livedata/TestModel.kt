package com.open.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * TestModel
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class TestModel : ViewModel() {

    private val _helloLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val helloLiveData = _helloLiveData

    fun updateMessage(message: String) {
        _helloLiveData.postValue(message)
    }
}
