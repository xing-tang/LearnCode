package com.open.learncode.android.threadhandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import learncode.open.com.learncode.R;

public class ThreadHandlerActivity_2 extends AppCompatActivity {


    private static final int MSG_STOOP_INFO = 2;
    private TextView mInfoText;

    private boolean isUpdate;
    private Handler mCheckMsgHandler;
    private HandlerThread mHandlerThread;
    private Message msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handlerthread_2);

        mCheckMsgHandler = new Handler();

        initBackThread();

        mInfoText = (TextView) findViewById(R.id.tv_info_count);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始更新
                isUpdate = true;

                msg = Message.obtain();
                msg.what = 1; //消息的标识
                msg.obj = "A"; // 消息的存放

//                mCheckMsgHandler.sendEmptyMessage(MSG_UPDATE_INFO);
                mCheckMsgHandler.sendMessage(msg);
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //停止更新
                isUpdate = false;
//                mCheckMsgHandler.removeMessages(MSG_UPDATE_INFO);
                mCheckMsgHandler.removeMessages(msg.what);
            }
        });
    }

    private void initBackThread() {
        // 1.创建HandlerThread
        mHandlerThread = new HandlerThread("check-message-coming");
        // 2.启动HandlerThread线程
        mHandlerThread.start();
        // 3.创建Handler对象绑定该线程的Looper
        mCheckMsgHandler = new Handler(mHandlerThread.getLooper()) {
            @Override
            public void handleMessage(final Message msg) {


                switch (msg.what) {
                    case 1:

                        //模拟耗时操作
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 主线程更新数据
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String result = "每隔1秒更新一下数据：" + Math.random();
                                mInfoText.setText(result);
                            }
                        });

                        if (isUpdate) { //1s后再次发送消息进行耗时操作
                            mCheckMsgHandler.sendEmptyMessageDelayed(msg.what, 1000);
                        }

                        break;

                    case 2:

                        onPause();
                        break;

                    default:
                        break;

                }
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        isUpdate = false;
        mCheckMsgHandler.removeMessages(MSG_STOOP_INFO);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        mHandlerThread.quit();
    }
}
