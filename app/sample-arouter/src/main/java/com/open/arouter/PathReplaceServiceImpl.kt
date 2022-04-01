package com.open.arouter

import android.content.Context
import android.net.Uri
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PathReplaceService

/**
 * PathReplaceServiceImpl
 *
 * @Description: 跳转前第一次预处理
 *               实现 PathReplaceService 接口，并必须加以 @Route 注解
 *               path 地址只要保证正常的格式，内容是什么好像无所谓
 *               一般我们会使用 @Route(path = "/pathReplace/service") 为默认地址
 * @Author: xing.tang
 */
@Route(path = "/pathReplace/service")
class PathReplaceServiceImpl : PathReplaceService {

    private var context: Context? = null

    override fun init(context: Context?) {
        this.context = context
    }

    override fun forString(path: String): String {
        Log.d("PathReplaceServiceImpl", "forString: $path")
        return path
    }

    override fun forUri(uri: Uri): Uri {
        Log.d("PathReplaceServiceImpl", "forUri: $uri")
        return uri
    }
}