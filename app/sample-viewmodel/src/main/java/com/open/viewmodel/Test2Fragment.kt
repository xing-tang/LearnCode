package com.open.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/**
 * Test2Fragment
 *
 * @Description: xxx
 * @Author: xing.tang
 */
class Test2Fragment : Fragment() {

    private var sharedViewModel: SharedViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_test2, null)
        // 获取依附的 Activity 的 ViewModel
        sharedViewModel = activity?.let { ViewModelProvider(it)[SharedViewModel::class.java] }
        rootView.setOnClickListener {
            sharedViewModel?.updateMessage("Hello FragmentTest1")
        }
        return rootView
    }
}
