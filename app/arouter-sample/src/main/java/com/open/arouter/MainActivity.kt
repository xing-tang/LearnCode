package com.open.arouter

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.facade.enums.RouteType
import com.alibaba.android.arouter.facade.model.RouteMeta
import com.alibaba.android.arouter.launcher.ARouter
import com.arouter.java.export.HelloService
import com.arouter.java.export.model.TestObj
import com.arouter.java.export.model.TestParcelable
import com.arouter.java.export.model.TestSerializable
import com.arouter.java.testactivity.TestDynamicActivity
import com.arouter.java.testservice.SingleService
import com.open.arouter.databinding.ActivityMainBinding
import com.open.common.base.BaseActivity
import com.open.common.config.RouterPath
import java.util.*

@Route(path = RouterPath.App.main)
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun bindingView(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * 单击视图时调用
     *
     * @param v View
     */
    fun onClick(v: View) {
        // Build test data.
        val testSerializable = TestSerializable("Titanic", 555)
        val testParcelable = TestParcelable("jack", 666)
        val testObj = TestObj("Rose", 777)
        val objList: MutableList<TestObj> = ArrayList<TestObj>()
        objList.add(testObj)
        val map: MutableMap<String, List<TestObj>> = HashMap<String, List<TestObj>>()
        map["testMap"] = objList
        when (v.id) {
            // =========================== 基本设置 ===========================
            R.id.openLog -> {// 打开日志并打印堆栈
                ARouter.openLog()
            }
            R.id.openDebug -> {//开启调试模式（InstantRun 需要开启）
                ARouter.openDebug()
            }
            R.id.init -> {//初始化 ARouter
                // 调试模式不是必须开启，但是为了防止有用户开启了 InstantRun，但是
                // 忘了开调试模式，导致无法使用 Demo，如果使用了 InstantRun，必须在
                // 初始化之前开启调试模式，但是上线前需要关闭，InstantRun 仅用于开
                // 发阶段，线上开启调试模式有安全风险，可以使用 BuildConfig.DEBUG
                // 来区分环境
                ARouter.openDebug()
                ARouter.init(application)
            }
            R.id.destroy -> {// 关闭 ARouter
                ARouter.getInstance().destroy()
            }
            // =========================== 基础功能（请先初始化） ===========================
            R.id.normalNavigation -> {// 简单的应用内跳转
                ARouter.getInstance()
                    .build("/test/activity2")
                    .navigation()
            }
            R.id.kotlinNavigation -> {// 跳转到 Kotlin 页面
                ARouter.getInstance()
                    .build("/kotlin/test")
                    .withString("name", "老王")
                    .withInt("age", 23)
                    .navigation()
            }
            R.id.normalNavigation2 -> {// 跳转 ForResult
                ARouter.getInstance()
                    .build("/test/activity2")
                    .navigation(this, 666)
            }
            R.id.getFragment -> {// 获取 Fragment 实例
                val fragment: Fragment = ARouter.getInstance().build("/test/fragment")
                    .withString("name", "老王")
                    .withInt("age", 18)
                    .withBoolean("boy", true)
                    .withLong("high", 180)
                    .withString("url", "https://a.b.c")
                    .withSerializable("ser", testSerializable)
                    .withParcelable("pac", testParcelable)
                    .withObject("obj", testObj)
                    .withObject("objList", objList)
                    .withObject("map", map).navigation() as Fragment
                Toast.makeText(this, "找到Fragment:" + fragment.toString(), Toast.LENGTH_SHORT).show()
            }
            R.id.normalNavigationWithParams -> {// 携带参数的应用内跳转
                // ARouter.getInstance()
                //         .build("/test/activity2")
                //         .withString("key1", "value1")
                //         .navigation();
                val testUriMix = Uri.parse("arouter://m.aliyun.com/test/activity2")
                ARouter.getInstance().build(testUriMix)
                    .withString("key1", "value1")
                    .navigation()
                ARouter.getInstance()
                    .build("/test/activity2")
                    .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                    .navigation(this)
            }
            R.id.oldVersionAnim -> {// 旧版本转场动画
                ARouter.getInstance()
                    .build("/test/activity2")
                    .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                    .navigation(this)
            }
            R.id.newVersionAnim -> {// 新版本转场动画
                if (Build.VERSION.SDK_INT >= 16) {
                    val compat: ActivityOptionsCompat =
                        ActivityOptionsCompat.makeScaleUpAnimation(
                            v,
                            v.width / 2,
                            v.height / 2,
                            0,
                            0
                        )
                    ARouter.getInstance()
                        .build("/test/activity2")
                        .withOptionsCompat(compat)
                        .navigation()
                } else {
                    Toast.makeText(this, "API < 16,不支持新版本动画", Toast.LENGTH_SHORT).show()
                }
            }
            // =========================== 进阶用法（请先初始化） ===========================
            R.id.navByUrl -> {// 通过 URL 跳转
                ARouter.getInstance()
                    .build("/test/webview")
                    .withString("url", "file:///android_asset/scheme-test.html")
                    .navigation()
            }
            R.id.interceptor -> {// 拦截器测试
                ARouter.getInstance()
                    .build("/test/activity4")
                    .navigation(this, object : NavCallback() {
                        override fun onArrival(postcard: Postcard) {}
                        override fun onInterrupt(postcard: Postcard) {
                            Log.d("ARouter", "被拦截了")
                        }
                    })
            }
            R.id.autoInject -> {// 依赖注入（参照代码）
                ARouter.getInstance().build("/test/activity1")
                    .withString("name", "老王")
                    .withInt("age", 18)
                    .withBoolean("boy", true)
                    .withLong("high", 180)
                    .withString("url", "https://a.b.c")
                    .withSerializable("ser", testSerializable)
                    .withParcelable("pac", testParcelable)
                    .withObject("obj", testObj)
                    .withObject("objList", objList)
                    .withObject("map", map)
                    .navigation()
            }
            R.id.navByName -> {// ByName 调用服务
                (ARouter.getInstance().build("/yourservicegroupname/hello")
                    .navigation() as HelloService).sayHello("mike")
            }
            R.id.navByType -> {// ByType 调用服务
                ARouter.getInstance().navigation(HelloService::class.java).sayHello("mike")
            }
            R.id.callSingle -> {// 调用单类
                ARouter.getInstance().navigation(SingleService::class.java).sayHello("Mike")
            }
            // =========================== 多模块测试（请先初始化） ===========================
            R.id.navToMoudle1 -> {// 跳转到模块 1
                ARouter.getInstance().build("/module/1").navigation()
            }
            R.id.navToMoudle2 -> {// 跳转到模块 2
                // 这个页面主动指定了Group名
                ARouter.getInstance().build("/module/2", "m2").navigation()
            }
            // =========================== 跳转失败测试（请先初始化） ===========================
            R.id.failNav -> {// 跳转失败，单独降级
                ARouter.getInstance().build("/xxx/xxx")
                    .navigation(this, object : NavCallback() {
                        override fun onFound(postcard: Postcard) {
                            Log.d("ARouter", "找到了")
                        }

                        override fun onLost(postcard: Postcard) {
                            Log.d("ARouter", "找不到了")
                        }

                        override fun onArrival(postcard: Postcard) {
                            Log.d("ARouter", "跳转完了")
                        }

                        override fun onInterrupt(postcard: Postcard) {
                            Log.d("ARouter", "被拦截了")
                        }
                    })
            }

            R.id.failNav2 -> {// 跳转失败，全局降级
                ARouter.getInstance().build("/xxx/xxx").navigation()
            }
            R.id.failNav3 -> {// 服务调用失败
                ARouter.getInstance().navigation(MainActivity::class.java)
            }
            // =========================== 动态增加路由测试 ===========================
            R.id.addGroup -> {// 动态增加路由
                ARouter.getInstance().addRouteGroup { atlas ->
                    atlas["/dynamic/activity"] = RouteMeta.build(
                        RouteType.ACTIVITY,
                        TestDynamicActivity::class.java,
                        "/dynamic/activity",
                        "dynamic", 0, 0
                    )
                }
            }
            R.id.dynamicNavigation -> {// 动态路由测试
                // 该页面未配置 Route 注解，动态注册到 ARouter
                ARouter.getInstance().build("/dynamic/activity")
                    .withString("name", "老王")
                    .withInt("age", 18)
                    .withBoolean("boy", true)
                    .withLong("high", 180)
                    .withString("url", "https://a.b.c")
                    .withSerializable("ser", testSerializable)
                    .withParcelable("pac", testParcelable)
                    .withObject("obj", testObj)
                    .withObject("objList", objList)
                    .withObject("map", map).navigation(this)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            666 -> {
                Log.e(
                    "activityResult",
                    "onActivityResult: requestCode=$requestCode,resultCode=$resultCode"
                )
                Toast.makeText(
                    this,
                    "onActivityResult: requestCode=$requestCode,resultCode=$resultCode",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}