package com.old.old.wcopy.leetcode_剑指offer.A3_生成消费者;

import java.util.concurrent.Semaphore;

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
public class TH_03_4_多线程按指定顺序执行Semaphore {
    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1执行了...");
                semaphore1.release();
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore1.acquire();
                    System.out.println("线程2执行了...");
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore2.acquire();
                    thread2.join();
                    semaphore2.release();
                    System.out.println("线程3执行了...");
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
