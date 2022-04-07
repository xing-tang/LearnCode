package com.open.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ShareViewModel
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class SharedViewModel : ViewModel() {

    private val _messageLiveData: MutableLiveData<String> = MutableLiveData()
    private val messageLiveData: LiveData<String> = _messageLiveData

    fun updateMessage(message: String) {
        _messageLiveData.value = message
    }
}
