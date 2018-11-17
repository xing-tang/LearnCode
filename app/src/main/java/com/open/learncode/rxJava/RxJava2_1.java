package com.open.learncode.rxJava;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import learncode.open.com.learncode.R;

public class RxJava2_1 extends Activity {

    private String TAG = "RxJava2_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2_1);
    }

    /**
     * 无背压的方式1
     *
     * @param view
     */
    public void initRxJava2_1(View view) {
        // 第一步：初始化Observable
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                emitter.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                emitter.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                emitter.onNext(3);
                //执行了这个方法之后再下游会回调onComplete()方法，并且上游后续的不再发送
                emitter.onComplete();
                Log.e(TAG, "Observable emit 4" + "\n");
                emitter.onNext(4);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // 第三步：订阅
                .subscribe(new Observer<Integer>() {

                    // 第二步：初始化Observer

                    private Disposable mDisposable;

                    @Override
                    public void onSubscribe(Disposable d) {//这里是入口，去告知上游开始发送数据给下游
                        Log.e(TAG, "onSubscribe : Disposable : " + d.isDisposed() + "\n");
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {//这里接收数据项
                        Log.e(TAG, "onNext : integer : " + integer + "\n");
                        if (integer == 2) {
                            // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                            mDisposable.dispose();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {//这里接收onError
                        Log.e(TAG, "onError : value : " + e.getMessage() + "\n");
                    }

                    @Override
                    public void onComplete() {//这里接收onComplete

                        Log.e(TAG, "onComplete" + "\n");
                    }
                });
    }

    /**
     * 无背压方式2
     *
     * @param view
     */
    public void initRxJava2_2(View view) {
        // 第一步：初始化Observable
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                emitter.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                emitter.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                emitter.onNext(3);
                //执行了这个方法之后再下游会回调onComplete()方法，并且上游后续的不再发送
                emitter.onComplete();
                Log.e(TAG, "Observable emit 4" + "\n");
                emitter.onNext(4);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // 第三步：订阅
                .subscribe(new Consumer<Integer>() {

                    // 第二步：初始化Observer

                    @Override
                    public void accept(Integer integer) throws Exception {//这里接收数据项
                        Log.e(TAG, "onNext : integer : " + integer + "\n");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {//这里接收onError

                        Log.e(TAG, "onError : value : " + throwable.getMessage() + "\n");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {//这里接收onComplete

                        Log.e(TAG, "onComplete" + "\n");
                    }
                });
    }

    /**
     * 背压方式
     * Flowable的几种背压策略：
     * 1. BackpressureStrategy.ERROR：缓存区默人大小128，流速不均衡时发射MissingBackpressureException信号。
     * 2. BackpressureStrategy.BUFFER：缓存区不限制大小，使用不当仍会OOM。
     * 3. BackpressureStrategy.DROP：缓存最近的nNext事件。
     * 4. BackpressureStrategy.LATEST：缓存区会保留最后的OnNext事件，覆盖之前缓存的OnNext事件。
     * 5. BackpressureStrategy.MISSING：OnNext事件没有任何缓存和丢弃，下游要处理任何溢出。
     *
     * @param view
     */
    public void initRxJava2_3(View view) {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; i < 128; i++) {
//                    Log.e(TAG, "Observable emit " + i + "\n");
                    emitter.onNext(i);
                }
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        subscription = s;
                        subscription.request(1);
                        Log.e(TAG, "onSubscribe : Subscription : " + s.toString() + "\n");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext : integer : " + integer + "\n");
                        subscription.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError : value : " + t.getMessage() + "\n");

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete" + "\n");
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void map(View view) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "subscribe: ");
                e.onNext(1);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                String mapStr = String.valueOf(integer + 1);
                return mapStr;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept: " + s);
            }
        });
    }

    @SuppressLint("CheckResult")
    public void flatMap(View view) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "subscribe: ");
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    String iStr = "flatMap value" + integer;
                    arrayList.add(iStr);
                }
                return Observable.fromIterable(Collections.singleton("12")).delay(10, TimeUnit.MICROSECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept: " + s);
            }
        });
    }

}
