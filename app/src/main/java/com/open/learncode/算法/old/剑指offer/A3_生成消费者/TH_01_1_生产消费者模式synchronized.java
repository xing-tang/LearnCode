package com.open.learncode.算法.old.剑指offer.A3_生成消费者;

import java.util.Random;

/**
 * 题目：
 * 生产消费者模式
 * <p>
 * 解题思路:
 * 基于synchronized与wait/notify
 */
public class TH_01_1_生产消费者模式synchronized {

    private static int count = 0;
    private static final int MAX_COUNT = 5;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Producer().start();
            new Consumer().start();
        }
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock) {
                        while (count == MAX_COUNT) {
                            System.out.println("数据已满");
                            lock.wait();
                        }
                        count++;
                        System.out.println("生产者产生了一个数据，当前总数：" + count);
                        lock.notifyAll();
                    }
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock) {
                        while (count < 1) {
                            System.out.println("数据为空");
                            lock.wait();
                        }
                        count--;
                        System.out.println("消费者消费了一个数据，当前总数：" + count);
                        lock.notifyAll();
                    }
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
