package com.open.viewmodel

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.open.common.base.BaseActivity
import com.open.viewmodel.databinding.ActivityMainBinding
import com.open.viewmodel.test.asasa.InstrumentationProxy
import ws.vinta.pangu.Pangu

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun isOpenARouter(): Boolean = false

    // private val mViewModel: TestModel by viewModels()
    private lateinit var testViewModel: TestModel

    private lateinit var savedstateViewModel: SavedstateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceActivityInstrumentation(this)

        testViewModel = ViewModelProvider(this)[TestModel::class.java]
        testViewModel.testLiveData.observe(this) {
            mViewBinding.tvViewmodelText.text = it.toString()
        }

        savedstateViewModel = ViewModelProvider(
            this,
            SavedStateViewModelFactory(application, this)
        )[SavedstateViewModel::class.java]
        savedstateViewModel.testLiveData.observe(this) {
            mViewBinding.tvViewmodelText.text = it.toString()
        }
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btn_viewmodel_loadinit -> {
                testViewModel.loadInitData()

                val pangu = Pangu()
                val newText = pangu.spacingText("請問Jackie的鼻子有幾個？123個！")
                Log.d("MainActivity", "onCreate: $newText")
            }
            R.id.btn_viewmodel_loadinit_by_savedstate -> {
                savedstateViewModel.loadInitData()
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://zhangsan.com")
                startActivity(intent)
            }
        }
    }

    fun replaceActivityInstrumentation(activity: Activity?) {
        try {
            // 得到 Activity 的 mInstrumentation 字段
            val field = Activity::class.java.getDeclaredField("mInstrumentation") // 1
            // 取消 Java 的权限控制检查
            field.isAccessible = true // 2
            val instrumentation = field[activity] as Instrumentation // 3
            val instrumentationProxy: Instrumentation = InstrumentationProxy(instrumentation) // 4
            field[activity] = instrumentationProxy
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}