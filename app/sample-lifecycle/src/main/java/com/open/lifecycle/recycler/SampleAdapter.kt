package com.open.lifecycle.recycler

import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * SampleAdapter
 *
 * @Description: xxx
 * @Author: xing.tang
 */
internal class SampleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        object : RecyclerView.ViewHolder(TextView(parent.context)) {}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as TextView).text = position.toString()
        val job = holder.itemView.autoDisposeScope.launch {
            delay(1000)
            Log.d("SampleAdapter", "success $position")
        }
        job.invokeOnCompletion {
            Log.d("SampleAdapter", "complete $position")
        }
    }

    override fun getItemCount(): Int = 300
}
