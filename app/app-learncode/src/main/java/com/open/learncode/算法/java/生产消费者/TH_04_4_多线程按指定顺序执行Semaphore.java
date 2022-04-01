package com.open.learncode.算法.java.生产消费者;

import java.util.concurrent.Semaphore;

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
public class TH_04_4_多线程按指定顺序执行Semaphore {

    private static Semaphore semaphore1 = new Semaphore(1,true);
    private static Semaphore semaphore2 = new Semaphore(0);
    private static Semaphore semaphore3 = new Semaphore(0);

    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore1.acquire();
                    System.out.println("线程1执行了...");
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore2.acquire();
                    System.out.println("线程2执行了...");
                    semaphore3.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore3.acquire();
                    System.out.println("线程3执行了...");
                    semaphore1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 线程随机打乱开启都能保证先1后2再3
        thread3.start();
        thread2.start();
        thread1.start();
    }
}
