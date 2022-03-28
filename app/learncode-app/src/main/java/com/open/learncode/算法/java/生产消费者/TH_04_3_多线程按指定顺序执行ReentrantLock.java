package com.open.learncode.算法.java.生产消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
public class TH_04_3_多线程按指定顺序执行ReentrantLock {

    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Boolean threadRun1 = false;
    private static Boolean threadRun2 = false;

    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("线程1执行了...");
                threadRun1 = true;
                condition1.signalAll();
                lock.unlock();
            }
        });
        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    if (!threadRun1) condition1.await();
                    System.out.println("线程2执行了...");
                    threadRun2 = true;
                    condition2.signalAll();
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
                    if (!threadRun2) condition2.await();
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
