package com.alibaba.android.arouter.facade.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 预处理服务用于检查是否需要导航，跳转前第二次预处理
 * 实现 PretreatmentService 接口，并必须加以 @Route 注解
 *
 * @author zhilong [Contact me.](mailto:zhilong.liu@aliyun.com)
 * @version 1.0
 * @since 2019-05-08 11:53
 */
public interface PretreatmentService extends IProvider {
    /**
     * Do something before navigation.
     *
     * @param context  context
     * @param postcard meta
     * @return if need navigation.
     */
    boolean onPretreatment(Context context, Postcard postcard);
}
