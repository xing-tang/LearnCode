package com.open.learncode.android.threadpoolexecutor;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，支持定时及周期性任务执行
 */
public class ScheduledThreadPoolActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟3秒执行
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {

                System.out.println("delay 3 seconds");
            }
        },3, TimeUnit.SECONDS);


        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                System.out.println("delay 5 seconds, and excute every 3 seconds");
            }
        },5,3,TimeUnit.SECONDS);
    }
}
