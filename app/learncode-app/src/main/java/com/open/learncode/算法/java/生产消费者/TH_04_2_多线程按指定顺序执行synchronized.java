package com.open.learncode.算法.java.生产消费者;

/**
 * 题目：
 * 让多线程按照自己指定的顺序执行
 * <p>
 * 解题思路:
 * 基于 Thread.join()：是 Theard 的方法，作用是调用线程需等待该 join() 线程执行完成后，才能继续用下运行。
 * 基于 synchronized 与 wait()/notifyAll()
 * 基于 ReentractLock（可重入锁） 和 Condition（条件）
 * 基于 Semaphore（信号量）
 */
public class TH_04_2_多线程按指定顺序执行synchronized {

    private static Object object1 = new Object();
    private static Object object2 = new Object();
    private static Boolean threadRun1 = false;
    private static Boolean threadRun2 = false;

    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    System.out.println("线程1执行了...");
                    threadRun1 = true;
                    object1.notify();
                }
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    try {
                        if (!threadRun1) object1.wait();
                        synchronized (object2) {
                            System.out.println("线程2执行了...");
                            object2.notify();
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
                synchronized (object2) {
                    try {
                        if (!threadRun2) object2.wait();
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
