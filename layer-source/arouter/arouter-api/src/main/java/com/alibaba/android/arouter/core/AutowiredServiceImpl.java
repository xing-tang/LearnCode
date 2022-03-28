package com.alibaba.android.arouter.core;

import android.content.Context;
import android.util.LruCache;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.android.arouter.utils.Consts.SUFFIX_AUTOWIRED;

/**
 * param inject service impl.
 *
 * @author zhilong <a href="mailto:zhilong.lzl@alibaba-inc.com">Contact me.</a>
 * @version 1.0
 * @since 2017/2/28 下午6:08
 */
@Route(path = "/arouter/service/autowired")
public class AutowiredServiceImpl implements AutowiredService {
    private LruCache<String, ISyringe> classCache;
    private List<String> blackList;

    @Override
    public void init(Context context) {
        classCache = new LruCache<>(50);
        blackList = new ArrayList<>();
    }

    @Override
    public void autowire(Object instance) {
        doInject(instance, null);
    }

    /**
     * 递归注入
     *
     * @param instance who call me.
     * @param parent   parent of me.
     */
    private void doInject(Object instance, Class<?> parent) {
        Class<?> clazz = null == parent ? instance.getClass() : parent;

        ISyringe syringe = getSyringe(clazz);
        if (null != syringe) {
            // 调用辅助类的 inject 方法
            syringe.inject(instance);
        }
        // 获取父类
        Class<?> superClazz = clazz.getSuperclass();
        // 父类不为空，且不是 framework 的类
        if (null != superClazz && !superClazz.getName().startsWith("android")) {
            doInject(instance, superClazz);
        }
    }

    /**
     * 获取注解生成的辅助类
     *
     * @param clazz Class<?>
     * @return ISyringe
     */
    private ISyringe getSyringe(Class<?> clazz) {
        String className = clazz.getName();

        try {
            if (!blackList.contains(className)) {
                ISyringe syringeHelper = classCache.get(className);
                if (null == syringeHelper) {  // No cache.
                    // 类名$$ARouter$$Autowired（例如：KotlinTestActivity$$ARouter$$Autowired），反射
                    syringeHelper = (ISyringe) Class.forName(clazz.getName() + SUFFIX_AUTOWIRED).getConstructor().newInstance();
                }
                classCache.put(className, syringeHelper);
                return syringeHelper;
            }
        } catch (Exception e) {
            blackList.add(className);    // This instance need not autowired.
        }

        return null;
    }
}
