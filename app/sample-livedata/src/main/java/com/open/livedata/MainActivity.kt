package com.open.livedata

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.open.common.base.BaseActivity
import com.open.livedata.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun isOpenARouter(): Boolean = false

    private val mViewModel: TestModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 指定源数据类型为 String
        val helloLiveData = MutableLiveData<String>()
        helloLiveData.observe(this) { message ->
            Log.d("MainActivity", "onChanged:$message")
        }
        // 更新源数据，限定在主线程
        helloLiveData.setValue("Hello LiveData")
        // 更新源数组，主线程和子线程都可
        helloLiveData.postValue("Hello LiveData")
        // LiveData + ViewModel
        mViewModel.helloLiveData.observe(this) { message ->
            Log.d("TestModel", "onChanged:$message")
        }
        mViewModel.helloLiveData.postValue("Hello LiveData And ViewModel")
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btn_transformed_map -> {
                val mutableLiveData = MutableLiveData<String>()
                mutableLiveData.observe(this) {
                    Log.d("MainActivity", "onChanged1: $it")
                }
                // LiveData 返回值实例转换
                val transformedLiveData = Transformations.map(mutableLiveData) { name ->
                    "${name}，This is LiveData map()"
                }
                transformedLiveData.observe(this) {
                    Log.d("MainActivity", "onChange2: $it")
                }
                mutableLiveData.postValue("Hello LiveData ")
            }
            R.id.btn_transformed_switchMap -> {
                val mutableLiveData1 = MutableLiveData<String>()
                val mutableLiveData2 = MutableLiveData<String>()
                val liveDataSwitch = MutableLiveData<Boolean>()
                val transformedLiveData: LiveData<String> =
                    Transformations.switchMap(liveDataSwitch) {
                        if (it) mutableLiveData1 else mutableLiveData2
                    }
                transformedLiveData.observe(this) {
                    Log.d("MainActivity", "onChanged: $it")
                }
                liveDataSwitch.postValue(false)
                mutableLiveData1.postValue("LiveData1 postValue")
                mutableLiveData2.postValue("LiveData2 postValue")
            }
            R.id.btn_mediator_livedata -> {
                val mutableLiveData1 = MutableLiveData<String>()
                val mutableLiveData2 = MutableLiveData<String>()
                val mediatorLiveData = MediatorLiveData<String>()
                val observer = Observer<String> {

                }
                mediatorLiveData.addSource(mutableLiveData1, observer)
                mediatorLiveData.addSource(mutableLiveData2, observer)
                mediatorLiveData.observe(this) {
                    Log.d("MainActivity", "onChanged: $it")
                }
                mutableLiveData1.postValue("LiveData1 postValue")
                mutableLiveData2.postValue("LiveData2 postValue")
                Thread.sleep(300)
                mutableLiveData1.postValue("change LiveData1 data")
            }
        }
    }
}