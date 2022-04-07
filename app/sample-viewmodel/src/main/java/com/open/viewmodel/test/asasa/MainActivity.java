package com.open.viewmodel.test.asasa;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.open.viewmodel.R;

import java.lang.reflect.Field;

/**
 * MainActivity
 *
 * @Description: xxx
 * @Author: xing.tang
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        // replaceActivityInstrumentation
        replaceActivityInstrumentation(this);
        // replaceContextInstrumentation
        replaceContextInstrumentation(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // replaceActivityInstrumentation
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse("http://zhangsan.com"));
        startActivity(intent1);
        // replaceContextInstrumentation
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setData(Uri.parse("http://zhangsan.com"));
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent2);
    }



    public void replaceActivityInstrumentation(Activity activity){
        try{
            // 得到 Activity 的 mInstrumentation 字段
            Field field = Activity.class.getDeclaredField("mInstrumentation");// 1
            // 取消 Java 的权限控制检查
            field.setAccessible(true);// 2
            Instrumentation instrumentation = (Instrumentation) field.get(activity);// 3
            Instrumentation instrumentationProxy = new InstrumentationProxy(instrumentation);// 4
            field.set(activity,instrumentationProxy);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void replaceContextInstrumentation(Activity activity){
        try{
            // 获取 ActivityThread 类
            Class<?> activityThreadClazz =  Class.forName("android.app.ActivityThread");
            Field activityThreadField = activityThreadClazz.getDeclaredField("sCurrentActivityThread");// 1
            activityThreadField.setAccessible(true);
            Object currentActivityThread = activityThreadField.get(null);// 2
            // 获取 ActivityThread 中的 mInstrumentation 字段
            Field mInstrumentationField = activityThreadClazz.getDeclaredField("mInstrumentation");
            mInstrumentationField.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) mInstrumentationField.get(currentActivityThread);
            Instrumentation instrumentationProxy = new InstrumentationProxy(instrumentation);// 3
            mInstrumentationField.set(currentActivityThread,mInstrumentationField);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
