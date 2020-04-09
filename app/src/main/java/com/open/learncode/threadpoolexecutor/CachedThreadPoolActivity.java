package com.open.learncode.threadpoolexecutor;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import learncode.open.com.learncode.R;

/**
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，
 * 会复用执行第一个任务的线程，而不用每次新建线程。
 */
public class CachedThreadPoolActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_4);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("index：" + index);
                }
            });
        }


    }

}
