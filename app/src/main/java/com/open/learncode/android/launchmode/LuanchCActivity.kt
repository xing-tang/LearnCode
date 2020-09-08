package com.open.learncode.android.launchmode

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_luanch_c.*
import learncode.open.com.learncode.R

class LuanchCActivity : BaseActivty() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luanch_c)

        btn_change.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                tv_c.text = "修改了C页面的显示内容"
            }
        })
        btn_jump_b.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchCActivity, LuanchBActivity::class.java))
            }
        })

        btn_jump_c.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchCActivity, LuanchCActivity::class.java))
            }
        })

        btn_jump_d.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchCActivity, LuanchDActivity::class.java))
            }
        })
    }
}
