package com.open.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService

/**
 * DegradeServiceImpl
 *
 * @Description: 全局降级服务（当参数跳转错误时）
 *               path 地址只要保证正常的格式，内容是什么好像无所谓
 *               一般我们会使用 @Route(path = "/degradeService/service") 为默认地址
 * @Author: xing.tang
 */
@Route(path = "/degradeService/service")
class DegradeServiceImpl : DegradeService {

    private var context: Context? = null

    override fun init(context: Context?) {
        this.context = context
    }

    override fun onLost(context: Context?, postcard: Postcard?) {
        Log.d("DegradeServiceImpl", "onLost: $postcard")
    }
}