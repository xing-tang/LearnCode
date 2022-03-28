package com.open.learncode.android.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import learncode.open.com.learncode.R;

/**
 * 主线程通过Handler发送消息给子线程
 */
public class HandlerActivity_3 extends Activity {

    private TextView textView;
    private MainHandler mainHandler;
    private MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_3);
        textView = (TextView) findViewById(R.id.text);
        mainHandler = new MainHandler(this);
        myThread = new MyThread();
        myThread.start();
    }

    public void btnStart(View view) {
        //在主线程调用子线程的Handler发送消息给子线程
        myThread.handler.sendEmptyMessage(1);
    }

    class MyThread extends Thread {

        public Handler handler;

        @Override
        public void run() {
            //在子线程调用主线程的handler发送消息给主线程
            mainHandler.sendEmptyMessage(2);
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    Log.e("tag", "MyThread线程,主线程向子线程发送消息,Thread.name="
                            + Thread.currentThread().getName() + "线程;what=" + msg.what);
                }
            };
//            Looper.loop();
        }
    }

    private static class MainHandler extends Handler {
        private final WeakReference<HandlerActivity_3> weakReference;

        private MainHandler(HandlerActivity_3 activity) {
            weakReference = new WeakReference<HandlerActivity_3>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerActivity_3 activity = weakReference.get();
            super.handleMessage(msg);
            if (activity != null) {
                Log.e("tag", "UI线程,子线程向主线程发送消息,Thread.name="
                        + Thread.currentThread().getName() + "线程;what=" + msg.what);
                activity.textView.setText("UI线程,子线程向主线程发送消息,Thread.name="
                        + Thread.currentThread().getName() + "线程;what=" + msg.what);
            }
        }
    }
}
