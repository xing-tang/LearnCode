package com.open.learncode.算法.java.生产消费者;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 题目：
 * 写一个程序实现生产者消费者
 * <p>
 * 解题思路:
 * 基于 ReentractLock（可重入锁） 和 Condition（条件）
 * Lock#lock()：加锁
 * Lock#unlock()：释放锁
 * Condition#await()：释放当前锁，使该线程进入等待状态（阻塞状态）
 * Condition#signal()：在所有等待线程中随机唤醒一个线程，让它获得锁
 * Condition#signalAll()：唤醒所有等待的线程，让它们一起竞争锁，最后其中之一获得锁
 * ThreadA 为生产者，ThreadB 为消费者
 */
public class TH_03_2_生产消费者模式ReentractLock {

    private static int count = 0;
    private final static int MAX_COUNT = 5;
    private final static Lock lock = new ReentrantLock();
    private final static Condition fullCondition = lock.newCondition();
    private final static Condition emptyCondition = lock.newCondition();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new ThreadA().start();
            new ThreadB().start();
        }
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count == MAX_COUNT) {
                        System.out.println("数据已满");
                        fullCondition.await();
                    }
                    count++;
                    System.out.println("生产者产生了一个数据，当前总数：" + count);
                    // 唤醒所有消费者
                    emptyCondition.signalAll();
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 最后要注意手动释放锁
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count < 1) {
                        System.out.println("数据为空");
                        emptyCondition.await();
                    }
                    count--;
                    System.out.println("消费者消费了一个数据，当前总数：" + count);
                    // 唤醒所有生产者
                    fullCondition.signalAll();
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 最后要注意手动释放锁
                    lock.unlock();
                }
            }
        }
    }
}

