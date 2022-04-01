package com.open.learncode

import com.open.learncode.android.asynctask.AsyncTaskActivity
import com.open.learncode.android.handler.HandlerActivity_1
import com.open.learncode.android.handler.HandlerActivity_2
import com.open.learncode.android.handler.HandlerActivity_3
import com.open.learncode.android.handler.HandlerActivity_4
import com.open.learncode.android.handlerThread.HandlerThreadActivity_1
import com.open.learncode.android.handlerThread.HandlerThreadActivity_2
import com.open.learncode.android.intentService.IntentServiceActivity
import com.open.learncode.android.launchmode.LuanchAActivity
import com.open.learncode.android.launchmode.LuanchBActivity
import com.open.learncode.android.launchmode.LuanchCActivity
import com.open.learncode.android.launchmode.LuanchDActivity
import com.open.learncode.android.三级缓存.ImageCacheActivity
import com.open.learncode.android.动画.AnimationActivity
import com.open.learncode.android.协程.CoroutineActivity
import com.open.learncode.android.生命周期.LifeCycleActivity
import com.open.learncode.android.获取View的宽高.GetViewActivity
import com.open.learncode.开源框架.mvp.DaggerActivity
import com.open.learncode.开源框架.okhttp3.OkHttpActivity
import com.open.learncode.开源框架.retrofit2.Retrofit2Activity
import com.open.learncode.开源框架.rxjava2.RxJavaActivity

enum class MainData(className: String, classActivity: Class<*>) {

    getView("获取View的宽高", GetViewActivity::class.java),
    lifeCycle("生命周期打印", LifeCycleActivity::class.java),
    animation("动画", AnimationActivity::class.java),
    asyncTask("AsyncTask更新进度条", AsyncTaskActivity::class.java),
    coroutine("Kotlin协程", CoroutineActivity::class.java),
    dagger("Dagger2", DaggerActivity::class.java),
    handler1("子线程通过Handler发送消息给主线程", HandlerActivity_1::class.java),
    handler2("子线程更新UI的4种方式", HandlerActivity_2::class.java),
    handler3("主线程通过Handler发送消息给子线程", HandlerActivity_3::class.java),
    handler4("子线程通过Handler发送消息给子线程", HandlerActivity_4::class.java),
    handlerThread1("HandlerThread_1", HandlerThreadActivity_1::class.java),
    handlerThread2("HandlerThread_2", HandlerThreadActivity_2::class.java),
    intentService("IntentService", IntentServiceActivity::class.java),
    standard("标准模式", LuanchAActivity::class.java),
    singleTop("栈顶复用模式", LuanchBActivity::class.java),
    singleTask("栈内复用模式", LuanchCActivity::class.java),
    singleInstance("全局单例模式", LuanchDActivity::class.java),
    okhttp3("Okhttp3", OkHttpActivity::class.java),
    retrofit2("Retrofit2", Retrofit2Activity::class.java),
    rxJava2("RxJava2", RxJavaActivity::class.java),
    imageCache("自定义图片三级缓存框架", ImageCacheActivity::class.java);

    /**
     * className
     */
    var className: String = ""

    /**
     * classActivity
     */
    var classActivity: Class<*>? = null

    init {
        this.className = className
        this.classActivity = classActivity
    }
}