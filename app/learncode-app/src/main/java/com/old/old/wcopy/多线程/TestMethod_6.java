package com.old.old.wcopy.多线程;

/**
 * 题目：
 * 写一个死锁程序
 * <p>
 * 解题思路:
 */
public class TestMethod_6 {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        TestMethod_6 method = new TestMethod_6();
        for (int i = 0; i < 10; i++) {
            method.new A().start();
            method.new B().start();
        }
    }

    class A extends Thread {
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

    class B extends Thread {
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
