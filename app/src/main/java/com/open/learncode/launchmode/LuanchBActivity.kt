package com.open.learncode.launchmode

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_luanch_b.*
import learncode.open.com.learncode.R
import java.util.*

class LuanchBActivity : BaseActivty() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luanch_b)

        btn_change.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                tv_b.text = "修改了B页面的显示内容"
            }
        })
        btn_jump_a.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchBActivity, LuanchAActivity::class.java).addFlags(FLAG_ACTIVITY_CLEAR_TOP))
            }
        })
        btn_jump_b.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchBActivity, LuanchBActivity::class.java))
            }
        })
        btn_jump_c.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchBActivity, LuanchCActivity::class.java))
            }
        })
        btn_jump_d.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchBActivity, LuanchDActivity::class.java))
            }
        })
    }


}
