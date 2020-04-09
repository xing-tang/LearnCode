package com.open.learncode.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import learncode.open.com.learncode.R;

/**
 * 子线程向子线程进行通信
 */
public class HandlerActivity_4 extends Activity {

    private MyThread1 myThread1;
    private MyThread2 myThread2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_4);

        myThread1 = new MyThread1();
        myThread2 = new MyThread2();
        myThread1.start();
        myThread1.start();

        //子线程
        new Thread(new Runnable() {

            @Override
            public void run() {

                /**
                 * 这里设置休眠3秒的原因是：
                 * new Thread.start的速度可能快于myThread1.start() myThread2.start()
                 * myThread1 myThread1肯定已经创建好了，但是里面的handler是否已经创建成功却不一定
                 */

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myThread1.handler.sendEmptyMessage(1);
                myThread2.handler.sendEmptyMessage(2);
            }
        }).start();

    }

    class MyThread1 extends Thread {
        private Handler handler;

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    Log.e("tag", "MyThread1线程,子线程向子线程MyThread1发送消息,Thread.name="
                            + Thread.currentThread().getName() + "线程;what=" + msg.what);
                }
            };
            Looper.loop();
        }
    }

    class MyThread2 extends Thread {
        private Handler handler;

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    Log.e("tag", "MyThread2线程,子线程向子线程MyThread2发送消息,Thread.name="
                            + Thread.currentThread().getName() + "线程;what=" + msg.what);
                }
            };
            Looper.loop();
        }
    }
}
