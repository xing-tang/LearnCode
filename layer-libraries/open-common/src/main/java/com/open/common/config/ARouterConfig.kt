package com.open.common.config

import com.alibaba.android.arouter.facade.template.IProvider


/**
 * IIProvider
 *
 * @Description: 路由提供者
 * @Author: xing.tang
 */
interface IIProvider : IProvider {

    fun startLoginActivity(from: String)

    fun startMainActivity(from: String)

    fun startSearchActivity(from: String)

    fun startEditorActivity(from: String)

}

/**
 * RouterPath
 *
 * @Description: 路由路径统一管理
 * @Author: xing.tang
 */
object RouterPath {
    /*** 拦截器 */
    object Interceptor {
        const val login = "/interceptor/login"
    }

    /*** 降级服务 */
    object DegradeService {
        const val degrade = "/service/degrade"
    }

    object App {
        const val main = "/app/mian"
        const val error = "/app/error"
        const val other = "/app/other"
    }

    object Login {
        const val phone = "/login/phone"
    }

    object Personal {
        const val detail = "/personal/detail"
    }
}

/**
 * RouteFlag
 *
 * @Description: 为什么可以使用 route 注解的 extra 参数为目标页指定属性
 *               因为 Int 数值在内存中占 4 个字节，每个字节占 8 位，所以利用 extras 字段我们可以为目标页指定 32 个开关
 * @Author: xing.tang
 */
object RouteFlag {
    const val FLAG_LOGIN: Int = 0x01
    const val FLAG_AUTHORITY = FLAG_LOGIN.shl(1)// 等同于 java 中的 FLAG_LOGIN << 1
    const val FLAG_VIP = FLAG_AUTHORITY.shl(1)
}
