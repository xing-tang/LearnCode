package com.open.learncode.handler;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import learncode.open.com.learncode.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 * 子线程发送消息给主线程
 * 正确Handler写法，不会导致内存泄露（可以回收的情况下无法被回收）
 * 注意点：
 * 1.在使用Handler的时候，要注意内存泄漏，因为非静态内部类会持有外部类的一个引用，从而导致无法被GC。
 * 2.子线程调用方法时候，如果当前Activity已经被注销，但是子线程还在调用，这个时候必须中断线程。
 */
public class HandlerActivity_1 extends Activity {

    private TextView textView;

    //中断线程的标志
    private volatile boolean isActivityExist = true;
    //子线程
    private Thread thread;
    private MyHandler mHandler;



    /**
     * 创建静态内部类
     * 声明静态内部类不会持有外部类的隐式引用
     * 持有弱引用HandlerActivity,GC回收时会被回收掉.
     */
    private static class MyHandler extends Handler {
        private final WeakReference<HandlerActivity_1> mActivty;

        public MyHandler(HandlerActivity_1 activity) {
            mActivty = new WeakReference<HandlerActivity_1>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerActivity_1 activity = mActivty.get();
            super.handleMessage(msg);
            if (activity != null) {
                activity.textView.setText(System.currentTimeMillis() + "=接收到的消息为：" + msg.toString());
                Log.e("tag", System.currentTimeMillis() + "=接收到的消息为：" + msg.toString());
            }
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_1);
        textView = (TextView) findViewById(R.id.text);

        mHandler = new MyHandler(this);

    }


    public void sendHandlerMessage(View view) {
        isActivityExist = true;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (isActivityExist) {
                        try {
                            Thread.sleep(1000);
                            Message message = new Message();
                            message.what = 1;
                            message.obj = "你好";
                            mHandler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //中断线程方法2
                            return;
                        }
                    } else {
                        //中断线程方法1
                        break;
                    }

                }
            }
        });
        thread.start();
    }

    /**
     * 中断线程
     *
     * @param view
     */
    public void stopHandlerMessage(View view) {
        //mHandler.removeCallbacks(runnable);//无效，为什么？

        //中断线程方法1,配合break使用
        isActivityExist = false;
        //中断线程方法2,配合return使用
        thread.interrupt();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopHandlerMessage(null);
    }
}
