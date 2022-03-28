package com.old.old.剑指offer.A3_生成消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
public class TH_03_3_多线程按指定顺序执行ReentrantLock {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Boolean t1Run = false;
    private static Boolean t2Run = false;
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("线程1执行了...");
                t1Run = true;
                condition1.signal();
                lock.unlock();
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    if (!t1Run) condition1.await();
                    System.out.println("线程2执行了...");
                    t2Run = true;
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    if (!t2Run) condition2.await();
                    System.out.println("线程3执行了...");
                    lock.unlock();
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
