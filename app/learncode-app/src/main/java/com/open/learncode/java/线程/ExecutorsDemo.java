package com.open.learncode.java.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ExecutorsDemo {

    public static void main(String[] args) {
        newCachedThreadPool();
        newFixedThreadPool();
        newScheduledThreadPool();
        newSingleThreadExecutor();
    }

    /**
     * 创建一个可缓存线程池
     */
    private static void newCachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    // 打印正在执行的缓存线程信息,
                    System.out.println(Thread.currentThread().getName() + "正在被执行");
                }
            });
        }
    }

    /**
     * 创建一个可重用固定个数的线程池
     */
    private static void newFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        // 打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName() + "正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行——延迟执行
     */
    private static void newScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        // 延迟1秒执行
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "延迟1秒执行");
            }
        }, 1, TimeUnit.SECONDS);
        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "延迟1秒后每3秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    /**
     * 创建一个单线程化的线程池
     */
    private static void newSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        // 结果依次输出，相当于顺序执行各个任务
                        System.out.println(Thread.currentThread().getName() + "正在被执行,打印的值是:" + index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
