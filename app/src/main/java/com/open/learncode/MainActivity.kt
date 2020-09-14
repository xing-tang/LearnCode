package com.open.learncode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.open.learncode.android.asynctask.AsyncTaskActivity
import com.open.learncode.android.handler.HandlerActivity_1
import com.open.learncode.android.handler.HandlerActivity_2
import com.open.learncode.android.handler.HandlerActivity_3
import com.open.learncode.android.handler.HandlerActivity_4
import com.open.learncode.android.launchmode.LuanchAActivity
import com.open.learncode.android.launchmode.LuanchBActivity
import com.open.learncode.android.launchmode.LuanchCActivity
import com.open.learncode.android.launchmode.LuanchDActivity
import com.open.learncode.android.handlerThread.HandlerThreadActivity_1
import com.open.learncode.android.handlerThread.HandlerThreadActivity_2
import com.open.learncode.android.三级缓存.ImageCacheActivity
import com.open.learncode.android.动画.AnimationActivity
import com.open.learncode.android.协程.CoroutineActivity
import com.open.learncode.android.生命周期.FragmentListArray
import com.open.learncode.开源框架.mvp.DaggerActivity
import com.open.learncode.开源框架.okhttp3.OkHttpActivity
import com.open.learncode.开源框架.retrofit2.Retrofit2Activity
import com.open.learncode.开源框架.rxjava2.RxJavaActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import learncode.open.com.learncode.R
import java.util.concurrent.TimeUnit
import androidx.recyclerview.widget.RecyclerView
import com.open.learncode.android.intentService.IntentServiceActivity


class MainActivity : AppCompatActivity() {

    private var activityNameList: ArrayList<String> =
        arrayListOf(
            "生命周期打印",
            "动画",
            "AsyncTask更新进度条",
            "Kotlin协程",
            "Dagger2",
            "子线程通过Handler发送消息给主线程",
            "子线程更新UI的4种方式",
            "主线程通过Handler发送消息给子线程",
            "子线程通过Handler发送消息给子线程",
            "HandlerThread_1",
            "HandlerThread_2",
            "IntentService",
            "标准模式",
            "栈顶复用模式",
            "栈内复用模式",
            "全局单例模式",
            "Okhttp3",
            "Retrofit2",
            "RxJava2",
            "自定义图片三级缓存框架"
        )
    private var activityList: ArrayList<Class<*>> = arrayListOf(
        FragmentListArray::class.java,
        AnimationActivity::class.java,
        AsyncTaskActivity::class.java,
        CoroutineActivity::class.java,
        DaggerActivity::class.java,
        HandlerActivity_1::class.java,
        HandlerActivity_2::class.java,
        HandlerActivity_3::class.java,
        HandlerActivity_4::class.java,
        HandlerThreadActivity_1::class.java,
        HandlerThreadActivity_2::class.java,
        IntentServiceActivity::class.java,
        LuanchAActivity::class.java,
        LuanchBActivity::class.java,
        LuanchCActivity::class.java,
        LuanchDActivity::class.java,
        OkHttpActivity::class.java,
        Retrofit2Activity::class.java,
        RxJavaActivity::class.java,
        ImageCacheActivity::class.java
    )
    private var mainDataList: ArrayList<MainData> = arrayListOf()
    private var mAdapter: MainAdapter = MainAdapter(mainDataList)
    private val pageNumber = 20
    private var currPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        btn.setOnClickListener {
            Observable.interval(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Long> {
                    override fun onSubscribe(d: Disposable) {
                        Log.e("xing", "onSubscribe")
                    }

                    override fun onNext(t: Long) {
                        Log.e("xing", "onNext=$t")
                        var mainListData =
                            MainData(activityNameList.get(0), activityList.get(0))
                        mainDataList.add(mainListData)
                        mAdapter.loadMoreModule.loadMoreComplete()
//                        if (isVisBottom(main_list_recycler))
                            main_list_recycler.scrollToPosition(mainDataList.size - 1);
                    }

                    override fun onError(e: Throwable) {
                        Log.e("xing", "onError")
                    }

                    override fun onComplete() {
                        Log.e("xing", "onComplete")
                    }
                })
        }
    }

    fun isVisBottom(recyclerView: RecyclerView): Boolean {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
        //屏幕中最后一个可见子项的position
        val lastVisibleItemPosition = layoutManager!!.findLastVisibleItemPosition()
        //当前屏幕所看到的子项个数
        val visibleItemCount = layoutManager.childCount
        //当前RecyclerView的所有子项个数
        val totalItemCount = layoutManager.itemCount
        //RecyclerView的滑动状态
        val state = recyclerView.scrollState
        return visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && state == recyclerView.scrollState
    }

    private fun initView() {
        main_list_recycler.setOnClickListener {

        }
        main_list_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }
        mAdapter.loadMoreModule.setOnLoadMoreListener(OnLoadMoreListener { onLoadMore() })
        mAdapter.loadMoreModule.isAutoLoadMore = true
        // 当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        mAdapter.loadMoreModule.isEnableLoadMoreIfNotFullPage = false
        mAdapter.setOnItemClickListener { adapter, view, position ->
            when (view.id) {
                R.id.item_home_bt_text -> {
                    startActivity(Intent(MainListActivity@ this, activityList.get(position)))
                }
            }
        }
        // 进入页面，刷新数据
        main_list_swiperefresh_layout.isRefreshing = true
        onRefresh()
    }

    /**
     * 刷新
     */
    private fun onRefresh() {
        // 这里的作用是防止下拉刷新的时候还可以上拉加载
        mAdapter.loadMoreModule.isEnableLoadMore = false
        // 下拉刷新，需要重置数据
        mainDataList.clear()
        requestDataSucces(0)
    }

    /**
     * 加载更多
     */
    private fun onLoadMore() {
        requestDataSucces(currPage)
    }

    private fun requestDataSucces(page: Int) {
        main_list_swiperefresh_layout.isRefreshing = false
        mAdapter.loadMoreModule.isEnableLoadMore = true
        var tempNumber = (page + 1) * pageNumber
        if (currPage == 0) {// 如果是加载的第一页数据，用setData()
            if (activityNameList.size == activityList.size) {
                for (index in (page * pageNumber)..(if (activityList.size <= tempNumber) (activityList.size - 1) else (tempNumber - 1))) {
                    var mainListData =
                        MainData(activityNameList.get(index), activityList.get(index))
                    mainDataList.add(mainListData)
                }
            }
        } else {// 不是第一页，则用addData()
            if (activityNameList.size == activityList.size) {
                for (index in (page * pageNumber)..(if (activityList.size <= tempNumber) (activityList.size - 1) else (tempNumber - 1))) {
                    var mainListData =
                        MainData(activityNameList.get(index), activityList.get(index))
                    mainDataList.add(mainListData)
                }
            }
        }
        // 如果是最后一页数组,显示没有更多数据布局
        if (currPage == (activityNameList.size / pageNumber)) {
            mAdapter.loadMoreModule.loadMoreEnd(currPage == 0)
        } else {
            mAdapter.loadMoreModule.loadMoreComplete()
        }
        currPage++
    }

    private fun requestDataFaild(errorMsg: String) {
        main_list_swiperefresh_layout.isRefreshing = false
        mAdapter.loadMoreModule.isEnableLoadMore = true
        mAdapter.loadMoreModule.loadMoreFail()
    }
}
