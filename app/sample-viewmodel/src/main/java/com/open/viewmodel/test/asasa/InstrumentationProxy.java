package com.open.viewmodel.test.asasa;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * InstrumentationProxy
 *
 * @Description: xxx
 * @Author: xing.tang
 */
public class InstrumentationProxy extends Instrumentation {

    private final static String TAG = "InstrumentationProxy";
    private Instrumentation mInstrumentation;

    public InstrumentationProxy(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token
            , Activity target, Intent intent, int requestCode, Bundle options) {
        Log.d(TAG, "execStartActivity: Hook 成功 ---who=" + who);
        try {
            // 通过反射 Instrumentation 的 execStartActivity() 方法
            Method execStartActivity = Instrumentation.class
                    .getDeclaredMethod("execStartActivity", Context.class, IBinder.class
                            , IBinder.class, Activity.class, Intent.class, int.class, Bundle.class);
            return (ActivityResult) execStartActivity.invoke(mInstrumentation, who, contextThread, token
                    , target, intent, requestCode, options);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
