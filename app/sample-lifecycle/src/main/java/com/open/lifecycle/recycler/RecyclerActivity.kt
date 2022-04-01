package com.open.lifecycle.recycler

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.open.common.base.BaseActivity
import com.open.lifecycle.databinding.ActivityRecyclerBinding


class RecyclerActivity : BaseActivity<ActivityRecyclerBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = SampleAdapter()
        mViewBinding.rvRecycler.layoutManager = LinearLayoutManager(this)
        mViewBinding.rvRecycler.adapter = adapter
    }
}