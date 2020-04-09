package com.open.learncode.threadpoolexecutor;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import learncode.open.com.learncode.R;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 */
public class FixedThreadPoolActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_4);

        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(3);

        for (int i = 0; i <10 ; i++) {
            final int index=i;

            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        //因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
                        System.out.println("index:"+index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
