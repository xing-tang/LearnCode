package com.open.learncode.算法.java.剑指offer.A00_单例模式;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 单例模式，双重判空加锁。
 * <p>
 * 解题思路：
 * synchronized 的作用？
 * 假设有两个线程同时想创建一个实例，由于在一个时刻只有一个线程能得到同步锁，当第一个线程加上锁时，
 * 第二个线程只能等待。当第一个线程发现实例还没有创建，它创建出一个实例。接着第一个线程释放同步锁，
 * 此时第二个线程可以加上同步锁，并运行接下来的代码。这时候由于实例已经被第一个线程创建出来了，
 * 第二个线程就不会重复创建实例了，这样就保证了我们在多线程环境中也只能得到一个实例。
 * 但是这里有个缺陷，每次通过 Instance 得到其实例的时候，都会试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要的时候我们应该尽量避免。
 * <p>
 * volatile 关键字的作用？
 * 双重检锁单例模式在 CPU 的工作流，主要分为三步，1：分配内存对象空间。2：初始化对象。
 * 3：设置 instance 执行刚才分配的内存地址，注意 jvm 和 cpu 优化会指令重排，上面顺序会变成 1-3-2，
 * 单线程环境下，此顺序是没有问题，2和3 前后没有依赖性，但是在多线程情况下会有这种情况，
 * 当线程A在执行第 5 行代码时，B线程进来执行到第 2 行代码。假设此时 A 执行的过程中发生了指令重排序，
 * 即先执行了 1和3，没有执行 2。那么由于A线程执行了 3 导致 instance指向了一段地址，
 * 所以B线程判断 instance 不为 null，会直接跳到第 6 行并返回一个未初始化的对象。
 * volatile 保持指令的有序性，能够有效禁止指令重排序。
 */
public class JZ0_1_单例模式 {

    private static volatile JZ0_1_单例模式 instance = null;

    private JZ0_1_单例模式() {

    }

    public static JZ0_1_单例模式 getInstance() {
        if (instance == null) {
            synchronized (JZ0_1_单例模式.class) {
                if (instance == null) {
                    instance = new JZ0_1_单例模式();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        PrintUtils.getInstance().print(JZ0_1_单例模式.getInstance().hashCode(), "hashCode()");
        PrintUtils.getInstance().print(JZ0_1_单例模式.getInstance().hashCode(), "hashCode()");
    }
}
