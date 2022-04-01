package com.open.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PretreatmentService

/**
 * PretreatmentServiceImpl
 *
 * @Description: 跳转前第二次预处理
 *               实现 PretreatmentService 接口，并必须加以 @Route 注解
 *               path 地址只要保证正常的格式，内容是什么好像无所谓
 *               一般我们会使用 @Route(path = "/pretreatment/service") 为默认地址
 * @Author: xing.tang
 */
@Route(path = "/pretreatment/service")
class PretreatmentServiceImpl : PretreatmentService {

    private var context: Context? = null

    override fun init(context: Context?) {
        this.context = context
    }

    override fun onPretreatment(context: Context?, postcard: Postcard): Boolean {
        this.context = context
        // 跳转前预处理，如果需要自行跳转，该方法返回 false 即可
        Log.d("PretreatmentServiceImpl", "onPretreatment: $postcard")
        return true
    }
}