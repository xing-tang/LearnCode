package com.open.learncode

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import learncode.open.com.learncode.R

class MainAdapter(data: ArrayList<MainData>?) :
    BaseQuickAdapter<MainData, BaseViewHolder>(R.layout.item_main, data), LoadMoreModule {

    override fun convert(helper: BaseViewHolder, item: MainData) {
        var tem = item.let {
            helper.setText(R.id.item_home_bt_text, item.activityName ?: "")
        }
        addChildClickViewIds(R.id.item_home_bt_text)
    }
}