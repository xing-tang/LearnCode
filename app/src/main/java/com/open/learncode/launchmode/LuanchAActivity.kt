package com.open.learncode.launchmode

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_luanch_a.*
import learncode.open.com.learncode.R

class LuanchAActivity : BaseActivty() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luanch_a)

        btn_change.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                tv_a.text = "修改了A页面的显示内容"
            }
        })
        btn_jump_a.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchAActivity, LuanchAActivity::class.java).addFlags(FLAG_ACTIVITY_CLEAR_TOP))
            }
        })
        btn_jump_b.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchAActivity, LuanchBActivity::class.java))
            }
        })
        btn_jump_c.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchAActivity, LuanchCActivity::class.java))
            }
        })
        btn_jump_d.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchAActivity, LuanchDActivity::class.java))
            }
        })
    }
}
