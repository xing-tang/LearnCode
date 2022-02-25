package com.open.learncode.算法.java.生产消费者;

/**
 * 题目：
 * 让多线程按照自己指定的顺序执行
 * <p>
 * 解题思路:
 * Thread.join：是Theard的方法，作用是调用线程需等待该join()线程执行完成后，才能继续用下运行。
 * 基于synchronized与wait/notify
 * 基于ReentractLock和Condition
 * 基于Semaphore（信号量）
 */
public class TH_03_2_多线程按指定顺序执行synchronized {
    private static Object myLock1 = new Object();
    private static Object myLock2 = new Object();
    private static Boolean t1Run = false;
    private static Boolean t2Run = false;
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock1) {
                    System.out.println("线程1执行了...");
                    t1Run = true;
                    myLock1.notify();
                }
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock1) {
                    try {
                        if (!t1Run) myLock1.wait();
                        synchronized (myLock2) {
                            System.out.println("线程2执行了...");
                            myLock2.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myLock2) {
                    try {
                        if (!t2Run) myLock2.wait();
                        System.out.println("线程3执行了...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 线程随机打乱开启都能保证先1后2再3
        thread3.start();
        thread2.start();
        thread1.start();
    }
}
