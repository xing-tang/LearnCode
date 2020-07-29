package com.open.learncode.线程;

/**
 * 如何中断线程
 */
public class ExitThreadDemo {

    public static void main(String[] args) {
        exitThread_1();
        exitThread_2();
    }

    public static volatile boolean isThreadExit = false;  //退出标志

    private static void exitThread_1() {
        new Thread() {
            public void run() {
                System.out.println("线程1启动了");
                while (true) {
                    if (!isThreadExit) {
                        try {
                            System.out.println("线程1运行中...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("线程1结束了");
                        // break配合中断线程1
                        break;
                    }
                }
            }
        }.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 5秒后更改退出标志的值,没有这段代码，线程就一直不能停止
        isThreadExit = true;
    }

    private static void exitThread_2() {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("线程2启动了");
                while (true) {
                    try {
                        System.out.println("线程2运行中...");
//                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("线程2结束了");
                        // retrun配合中断线程2
                        return;
                    }
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 5秒后更改退出标志的值,没有这段代码，线程就一直不能停止
        thread.interrupt();
    }
}
