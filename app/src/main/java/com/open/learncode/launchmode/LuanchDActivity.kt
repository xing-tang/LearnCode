package com.open.learncode.launchmode

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_luanch_d.*
import learncode.open.com.learncode.R

class LuanchDActivity : BaseActivty() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luanch_d)

        btn_change.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                tv_d.text = "修改了D页面的显示内容"
            }
        })
        btn_jump_b.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchDActivity, LuanchBActivity::class.java))
            }
        })

        btn_jump_c.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchDActivity, LuanchCActivity::class.java))
            }
        })

        btn_jump_d.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LuanchDActivity, LuanchDActivity::class.java))
            }
        })
    }
}
