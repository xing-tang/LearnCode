package com.open.learncode

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import learncode.open.com.learncode.R

class MainAdapter(data: ArrayList<MainData>?) :
    BaseQuickAdapter<MainData, BaseViewHolder>(R.layout.item_main, data), LoadMoreModule {

    override fun convert(helper: BaseViewHolder, item: MainData) {
        item.let {
            helper.setText(R.id.item_home_bt_text, item.className ?: "")
        }
        addChildClickViewIds(R.id.item_home_bt_text)
    }
}