package com.alibaba.android.arouter.core;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Warehouse 数据存储仓库
 * Storage of route meta and other data.
 *
 * @author zhilong <a href="mailto:zhilong.lzl@alibaba-inc.com">Contact me.</a>
 * @version 1.0
 * @since 2017/2/23 下午1:39
 */
class Warehouse {
    // 路由组集合，key 为组名，value 为路由组的 Class（HashMap）
    static Map<String, Class<? extends IRouteGroup>> groupsIndex = new HashMap<>();
    // 路由组按需加载完成后，存放到路由集合中（HashMap）
    static Map<String, RouteMeta> routes = new HashMap<>();

    // 每个服务的原始信息加载完成后存放到这里（HashMap）
    static Map<String, RouteMeta> providersIndex = new HashMap<>();
    // 服务集合，key 为服务的 Class，value 为服务的实例，需要时才会创建实例（HashMap）
    static Map<Class, IProvider> providers = new HashMap<>();

    // 拦截器的集合 （TreeMap）
    static Map<Integer, Class<? extends IInterceptor>> interceptorsIndex = new UniqueKeyTreeMap<>("More than one interceptors use same priority [%s]");
    // 拦截器按需加载完成后，存放到该拦截器集合中（ArrayList）
    static List<IInterceptor> interceptors = new ArrayList<>();

    /**
     * 清除所有集合的数据
     */
    static void clear() {
        routes.clear();
        groupsIndex.clear();
        providers.clear();
        providersIndex.clear();
        interceptors.clear();
        interceptorsIndex.clear();
    }
}
