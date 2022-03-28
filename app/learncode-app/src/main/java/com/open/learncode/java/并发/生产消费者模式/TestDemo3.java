package com.open.learncode.java.并发.生产消费者模式;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 生产消费者模式
 * 基于Semaphore（信号量）
 */
public class TestDemo3 {

    private int count = 0;
    private static final int MAX_COUNT = 5;
    // 实现数据消耗互斥的信号量
    private final Semaphore mutex = new Semaphore(1);
    // 控制生产者的信号量
    private final Semaphore notFull = new Semaphore(MAX_COUNT);
    // 控制消费者的信号量
    private final Semaphore notEmpty = new Semaphore(0);

    public static void main(String[] args) {
        TestDemo3 testDemo = new TestDemo3();
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
                    // 请求一个生产者信号量，如果当前信号量为MAX_COUNT时，则阻塞
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println("生产者产生了一个数据，当前总数：" + count);
                    mutex.release();
                    // 设置消费者可以消费的信号量个数 +1
                    notEmpty.release();
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
                    // 请求一个消费者信号量，如果当前信号量为0时，则阻塞
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println("消费者消费了一个数据，当前总数：" + count);
                    mutex.release();
                    notFull.release();
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
