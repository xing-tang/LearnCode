package com.open.learncode.java.线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 多线程的实现方式
 */
public class MultiThreadDemo {

    public static void main(String[] args) {
        // 继承Thread类实现多线程
        MyThread myThread1_1 = new MyThread();
        MyThread myThread1_2 = new MyThread();
        myThread1_1.start();
        myThread1_2.start();
        // 实现Runnable接口方式实现多线程
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        // 实现Callable接口方式实现多线程
        MyCallable callable = new MyCallable("Hello 多线程");
        FutureTask<Integer> task1 = new FutureTask<Integer>(callable);
        new Thread(task1).start();
        FutureTask<Integer> task2 = new FutureTask<Integer>(callable);
        new Thread(task2).start();
    }

    /**
     * 第一种方式：继承Thread类实现多线程
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承Thread类实现多线程=>" + this.getName() + "运行");
        }
    }

    /**
     * 第二种方式：实现Runnable接口方式实现多线程
     */
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("实现Runnable接口方式实现多线程=>" + Thread.currentThread().getName() + "运行");
        }
    }

    /**
     * 第三种方式：实现Callable接口方式实现多线程
     */
    static class MyCallable implements Callable {

        private String str;

        public MyCallable(String str) {
            this.str = str;
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println("实现Callable接口方式实现多线程=>" + Thread.currentThread().getName() + "运行，传递的值为：" + str);
            return true;
        }
    }
}
