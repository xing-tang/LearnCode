package com.old.old.wcopy.多线程;

/**
 * 题目：
 * AB两个线程交替打印0-100的数字
 * <p>
 * 解题思路:
 * 基于synchronized与wait/notify
 * 基于ReentractLock和Condition
 * 基于Semaphore（信号量）
 */
public class TestMethod_4 {

    private int count = 0;
    private final Object lock = new Object();

    public static void main(String[] args) {
        TestMethod_4 method = new TestMethod_4();
        method.new A().start();
        method.new B().start();
    }

    class A extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock) {
                        if (count < 100) {
                            if ((count & 1) == 1) {
                                lock.wait();
                            }
                            System.out.println("线程A：" + count);
                            count++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class B extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock) {
                        if (count < 100) {
                            if ((count & 1) == 0) {
                                lock.wait();
                            }
                            System.out.println("线程B：" + count);
                            count++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
