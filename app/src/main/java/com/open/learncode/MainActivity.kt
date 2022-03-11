package com.open.learncode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.oepn.config.MyConfig
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import learncode.open.com.learncode.R
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private var mainDataList: ArrayList<MainData> = arrayListOf()
    private var mAdapter: MainAdapter = MainAdapter(mainDataList)
    private val pageNumber = 20
    private var currPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initClickListener()
    }

    private fun initView() {
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
                    val itemData = adapter.getItem(position) as MainData;
                    val className = itemData.className
                    val cls: Class<*>? = itemData.classActivity;
                    startActivity(Intent(MainListActivity@ this, cls))
                    Log.d(MyConfig.TAG, "onItemClick: className=$className,cls=$cls")
                }
            }
        }
        // 进入页面，刷新数据
        main_list_swiperefresh_layout.isRefreshing = true
        onRefresh()
    }

    private fun initClickListener() {
        main_list_recycler.setOnClickListener {

        }
        btn.setOnClickListener {
            Observable.interval(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Long> {
                    override fun onSubscribe(d: Disposable) {
                        Log.d(MyConfig.TAG, "onSubscribe")
                    }

                    override fun onNext(t: Long) {
                        Log.d(MyConfig.TAG, "onNext=$t")
                        mainDataList.add(MainData.lifeCycle)
                        mAdapter.loadMoreModule.loadMoreComplete()
                        // if (isVisBottom(main_list_recycler))
                        main_list_recycler.scrollToPosition(mainDataList.size - 1);
                    }

                    override fun onError(e: Throwable) {
                        Log.d(MyConfig.TAG, "onError")
                    }

                    override fun onComplete() {
                        Log.d(MyConfig.TAG, "onComplete")
                    }
                })
        }
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
            for (index in (page * pageNumber)..(if (MainData.values().size <= tempNumber) (MainData.values().size - 1) else (tempNumber - 1))) {
                mainDataList.add(MainData.values().get(index))
            }
        } else {// 不是第一页，则用addData()
            for (index in (page * pageNumber)..(if (MainData.values().size <= tempNumber) (MainData.values().size - 1) else (tempNumber - 1))) {
                mainDataList.add(MainData.values().get(index))
            }
        }
        // 如果是最后一页数组,显示没有更多数据布局
        if (currPage == (MainData.values().size / pageNumber)) {
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
}
