package com.open.learncode.java.并发.锁;

public class SynchronizedDemo {

    /**
     * 方法锁
     */
    public synchronized void method1() {
        // ...
    }

    /**
     * 对象锁
     */
    public void method2() {
        synchronized (this) {
            // ...
        }
    }

    /**
     * 对象锁
     */
    public void method3(Object object) {
        synchronized (object) {
            // ...
        }
    }

    /**
     * 类锁
     */
    public static synchronized void method4() {

    }

    /**
     * 类锁
     */
    public void method4(Object object) {
        synchronized (SynchronizedDemo.class) {
            // ...
        }
    }
}
