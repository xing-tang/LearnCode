package com.open.learncode.算法.java.生产消费者;

import java.util.Random;

/**
 * 题目：
 * 写一个程序实现生产者消费者
 * <p>
 * 解题思路:
 * 基于 synchronized 关键字与 Object#wait()/notifyAll()
 * Object#wait()：释放当前锁，使该线程进入等待状态（阻塞状态）
 * Object#notify()：在所有等待线程中随机唤醒一个线程，让它获得锁
 * Object#notifyAll()：唤醒所有等待的线程，让它们一起竞争锁，最后其中之一获得锁
 * ThreadA 为生产者，ThreadB 为消费者
 */
public class TH_03_1_生产消费者模式synchronized {

    private static int count = 0;
    private final static int MAX_COUNT = 5;
    private final static Object object = new Object();

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

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (object) {
                        while (count <= 0) {
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