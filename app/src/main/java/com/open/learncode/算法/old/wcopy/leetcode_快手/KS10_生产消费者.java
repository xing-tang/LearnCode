package com.open.learncode.算法.old.wcopy.leetcode_快手;

public class KS10_生产消费者 {

    private static int count = 0;
    private static final int maxCount = 100;
    private static final Object object = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread1().start();
            new Thread2().start();
        }
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (object) {
                        if (count >= maxCount) {
                            System.out.println("数据满了：" + count);
                            object.wait();
                        } else {
                            count++;
                            System.out.println("数据生产了一个：" + count);
                            object.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (object) {
                        if (count <= 0) {
                            System.out.println("没有数据了：" + count);
                            object.wait();
                        } else {
                            count--;
                            System.out.println("数据消费了一个：" + count);
                            object.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
