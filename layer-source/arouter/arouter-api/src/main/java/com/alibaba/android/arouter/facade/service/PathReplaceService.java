package com.alibaba.android.arouter.facade.service;

import android.net.Uri;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 预处理你的路径，跳转前第一次预处理
 * 实现 PathReplaceService 接口，并必须加以 @Route(path = "/pathReplace/service") 注解
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a>
 * @version 1.0
 * @since 2016/12/9 16:48
 */
public interface PathReplaceService extends IProvider {

    /**
     * For normal path.
     *
     * @param path raw path
     */
    String forString(String path);

    /**
     * For uri type.
     *
     * @param uri raw uri
     */
    Uri forUri(Uri uri);
}
