package com.open.learncode.android.handler.threadLocal;

public class ThreadLocalTest {

    private static ThreadLocal<Boolean> threadLocal;

    public static void main(String[] args) {
        threadLocal = new ThreadLocal<Boolean>();
        threadLocal.set(true);
        System.out.println("【MainThread】threadLocal="+threadLocal.get());
        new Thread("Thread#1"){
            @Override
            public void run() {
                threadLocal.set(false);
                System.out.println("【Thread#1】threadLocal="+threadLocal.get());
            }
        }.start();
        new Thread("Thread#2"){
            @Override
            public void run() {
                System.out.println("【Thread#2】threadLocal="+threadLocal.get());
            }
        }.start();
    }
}
