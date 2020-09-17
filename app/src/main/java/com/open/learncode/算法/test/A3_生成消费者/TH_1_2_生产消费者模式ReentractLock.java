package com.open.learncode.算法.test.A3_生成消费者;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 题目：
 * 生产消费者模式
 * <p>
 * 解题思路:
 * 基于ReentractLock和Condition
 */
public class TH_1_2_生产消费者模式ReentractLock {
    private int count = 0;
    private final int MAX_COUNT = 5;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    public static void main(String[] args) {
        TH_1_2_生产消费者模式ReentractLock method = new TH_1_2_生产消费者模式ReentractLock();
        for (int i = 0; i < 3; i++) {
            method.new Producer().start();
        }
        for (int i = 0; i < 3; i++) {
            method.new Consumer().start();
        }
    }
    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count == MAX_COUNT) {
                        System.out.println("数据已满");
                        notFull.await();
                    }
                    count++;
                    System.out.println("生产者产生了一个数据，当前总数：" + count);
                    // 唤醒所有消费者
                    notEmpty.signalAll();
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
    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count < 1) {
                        System.out.println("数据为空");
                        notEmpty.await();
                    }
                    count--;
                    System.out.println("消费者消费了一个数据，当前总数：" + count);
                    // 唤醒所有生产者
                    notFull.signalAll();
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

