package com.open.learncode.算法.test.A3_生成消费者;

/**
 * 题目：
 * 让多线程按照自己指定的顺序执行
 * <p>
 * 解题思路:
 * Thread.join：是Theard的方法，作用是调用线程需等待该join()线程执行完成后，才能继续用下运行。
 * 基于synchronized与wait/notify
 * 基于ReentractLock和Condition
 * 基于Semaphore（信号量）
 */
public class TestMethod_5 {


    public static void main(String[] args) throws InterruptedException {
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程C执行");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadC.join();
                    System.out.println("线程B执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadB.join();
                    System.out.println("线程A执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
