package com.open.learncode.算法.java.生产消费者;

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
    private static final Object object = new Object();

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
                    synchronized (object) {
                        while (count == MAX_COUNT) {
                            System.out.println("数据已满");
                            object.wait();
                        }
                        count++;
                        System.out.println("生产者产生了一个数据，当前总数：" + count);
                        object.notifyAll();
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
                    synchronized (object) {
                        while (count < 1) {
                            System.out.println("数据为空");
                            object.wait();
                        }
                        count--;
                        System.out.println("消费者消费了一个数据，当前总数：" + count);
                        object.notifyAll();
                    }
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
