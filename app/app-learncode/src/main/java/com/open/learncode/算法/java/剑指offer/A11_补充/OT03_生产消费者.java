package com.open.learncode.算法.java.剑指offer.A11_补充;

import java.util.Random;

/**
 * OT_03_生产消费者
 */
public class OT03_生产消费者 {

    private static int count = 0;
    private final static int MAX_COUNT = 5;
    private final static Object object = new Object();

    public static void main(String[] args) {
        // 测试用例
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
