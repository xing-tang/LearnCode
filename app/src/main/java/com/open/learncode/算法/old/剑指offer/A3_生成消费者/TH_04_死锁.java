package com.open.learncode.算法.old.剑指offer.A3_生成消费者;

/**
 * 题目：
 * 写一个死锁程序
 * <p>
 * 解题思路:
 */
public class TH_04_死锁 {
    private final static Object lock1 = new Object();
    private final static Object lock2 = new Object();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new A().start();
            new B().start();
        }
    }
    public static class A extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock1) {
                        System.out.println("线程A lock lock1");
                        Thread.sleep(1000);
                        synchronized (lock2) {
                            System.out.println("线程A lock lock2");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public static class B extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (lock2) {
                        System.out.println("线程B lock lock1");
                        Thread.sleep(1000);
                        synchronized (lock1) {
                            System.out.println("线程B lock lock1");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
