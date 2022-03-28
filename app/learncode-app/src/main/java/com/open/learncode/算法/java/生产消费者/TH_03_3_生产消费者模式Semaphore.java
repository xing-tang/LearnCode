package com.open.learncode.算法.java.生产消费者;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 题目：
 * 写一个程序实现生产者消费者
 * <p>
 * 解题思路:
 * 基于 Semaphore（信号量）
 * new Semaphore(1)：互斥的信号量
 * Semaphore#acquire()：获取一个许可，如果没有就等待
 * Semaphore#release()：释放一个许可
 * ThreadA 为生产者，ThreadB 为消费者
 */
public class TH_03_3_生产消费者模式Semaphore {

    private static int count = 0;
    private static final int MAX_COUNT = 5;
    // 实现数据消耗互斥的信号量
    private static final Semaphore semaphore = new Semaphore(1);
    // 控制生产者的信号量
    private static final Semaphore fullSemaphore = new Semaphore(MAX_COUNT);
    // 控制消费者的信号量
    private static final Semaphore emptySemaphore = new Semaphore(0);

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
                    // 请求一个生产者信号量，如果当前信号量为 MAX_COUNT 时，则阻塞
                    fullSemaphore.acquire();
                    semaphore.acquire();
                    count++;
                    System.out.println("生产者产生了一个数据，当前总数：" + count);
                    semaphore.release();
                    // 设置消费者可以消费的信号量个数 +1
                    emptySemaphore.release();
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // 请求一个消费者信号量，如果当前信号量为 0 时，则阻塞
                    emptySemaphore.acquire();
                    semaphore.acquire();
                    count--;
                    System.out.println("消费者消费了一个数据，当前总数：" + count);
                    semaphore.release();
                    fullSemaphore.release();
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
