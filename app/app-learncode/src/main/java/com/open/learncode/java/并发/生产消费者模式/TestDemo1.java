package com.open.learncode.java.并发.生产消费者模式;

import java.util.Random;

/**
 * 生产消费者模式
 * 基于synchronized与wait/notify
 */
public class TestDemo1 {

    private int count = 0;
    private static final int MAX_COUNT = 5;
    private final Object lock = new Object();

    public static void main(String[] args) {
        TestDemo1 testDemo = new TestDemo1();
        for (int i = 0; i < 3; i++) {
            testDemo.new Producer().start();
        }
        for (int i = 0; i < 3; i++) {
            testDemo.new Consumer().start();
        }
    }

    class Producer extends Thread {
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

    class Consumer extends Thread {
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
