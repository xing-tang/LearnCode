package com.open.learncode.android.threadpoolexecutor;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 */
public class SingleThreadExecutorActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExecutorService singleThreadExecutor=Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {

            final int index=i;

            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {

                    try {
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
