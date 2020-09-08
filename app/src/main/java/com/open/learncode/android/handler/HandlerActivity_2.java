package com.open.learncode.android.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import learncode.open.com.learncode.R;

/**
 * 子线程更新UI的4种方式
 */
public class HandlerActivity_2 extends Activity {

    private final static String TAG = "HandlerActivity_2";
    private MyHandler handler = new MyHandler(this);
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_2);
        textView = (TextView) findViewById(R.id.text);
    }

    public void btnStart(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //子线程更新UI的几种方式
                    Thread.sleep(2000);
                    updateUImethod1();

                    Thread.sleep(2000);
                    updateUImethod2();

                    Thread.sleep(2000);
                    updateUImethod3();

                    Thread.sleep(2000);
                    updateUImethod4();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private static class MyHandler extends Handler {
        private final WeakReference<HandlerActivity_2> weakReference;

        private MyHandler(HandlerActivity_2 activity) {
            weakReference = new WeakReference<HandlerActivity_2>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerActivity_2 activity = weakReference.get();
            super.handleMessage(msg);
            if (activity != null) {
                activity.textView.setText(msg.obj.toString());
            }
        }
    }

    private void updateUImethod1() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("通过runOnUiThread()方法更新UI");
                Log.e(TAG, "updateUImethod1");
            }
        });
    }

    private void updateUImethod2() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("通过Handler的post()方法更新UI");
                Log.e(TAG, "updateUImethod2");

            }
        });
    }

    private void updateUImethod3() {
        Message message = new Message();
        message.what = 1;
        message.obj = "通过Handler的sendMessage()方法更新UI";
        handler.sendMessage(message);
        /**
         * 发送一个空的Message，但是可用what进行区分
         */
        //???发送一个空的Message，Message.obj为空，导致空指针异常
//        handler.sendEmptyMessage(1);

        /**
         * 注意：
         * 这里的写法只是为了避免了new Message()内存开销
         * 但是其内部里面也是执行了sendMessage()方法
         * 其实方法4和方法5可以归纳为一个方法，只是写法不一样而已
         */
        Message message2 = handler.obtainMessage(1, 2, 3,
                "通过Handler的obtainMessage()方法更新UI");
        message2.sendToTarget();
        Log.e(TAG, "updateUImethod3");
    }


    private void updateUImethod4() {
        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("通过View的post()方法更新UI");
                Log.e(TAG, "updateUImethod4");
            }
        });
    }
}
