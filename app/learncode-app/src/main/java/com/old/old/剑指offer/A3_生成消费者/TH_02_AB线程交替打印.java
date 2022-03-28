package com.old.old.剑指offer.A3_生成消费者;

/**
 * 题目：
 * AB两个线程交替打印0-100的数字
 * <p>
 * 解题思路:
 * 基于synchronized与wait/notify
 * 基于ReentractLock和Condition
 * 基于Semaphore（信号量）
 */
public class TH_02_AB线程交替打印 {
    private int count = 0;
    private final Object lock = new Object();
    public static void main(String[] args) {
        TH_02_AB线程交替打印 method = new TH_02_AB线程交替打印();
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
