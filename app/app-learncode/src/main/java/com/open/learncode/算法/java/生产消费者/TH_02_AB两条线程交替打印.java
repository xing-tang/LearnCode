package com.open.learncode.算法.java.生产消费者;

/**
 * 题目：
 * AB两个线程交替打印0-100的数字
 * <p>
 * 解题思路:
 * 基于 synchronized 与 wait()/notifyAll()
 * 基于 ReentractLock（可重入锁） 和 Condition（条件）
 * 基于 Semaphore（信号量）
 */
public class TH_02_AB两条线程交替打印 {

    private static int count = 0;
    private final static Object object = new Object();

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (object) {
                        if (count < 100) {
                            if ((count & 1) == 1) {
                                object.wait();
                            }
                            System.out.println("ThreadA：" + count);
                            count++;
                            object.notifyAll();
                        }
                    }
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
                        if (count < 100) {
                            if ((count & 1) == 0) {
                                object.wait();
                            }
                            System.out.println("ThreadB：" + count);
                            count++;
                            object.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
