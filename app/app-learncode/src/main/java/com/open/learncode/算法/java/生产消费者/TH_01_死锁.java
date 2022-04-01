package com.open.learncode.算法.java.生产消费者;

/**
 * 题目：
 * 写一个死锁程序
 * <p>
 * 解题思路: synchronized 或 Lock
 */
public class TH_01_死锁 {

    private final static Object lockA = new Object();
    private final static Object lockB = new Object();

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("ThreadA 开始执行");
                synchronized (lockA) {
                    System.out.println("ThreadA 锁住了 lockA");
                    Thread.sleep(1000);// 此处等待是给 ThreadB 能锁住机会
                    synchronized (lockB) {
                        System.out.println("ThreadA 锁住了 lockB");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadB 开始执行");
            try {
                synchronized (lockB) {
                    System.out.println("ThreadB 锁住了 lockB");
                    Thread.sleep(1000);// 此处等待是给 ThreadB 能锁住机会
                    synchronized (lockA) {
                        System.out.println("ThreadB 锁住了 lockA");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
