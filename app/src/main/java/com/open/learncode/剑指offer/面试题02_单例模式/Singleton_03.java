package com.open.learncode.剑指offer.面试题02_单例模式;

/**
 * 单例模式，一次判空同步锁
 * 提示：单线程安全，多线程安全，但是效率不高，因为加锁是一件非常耗时的操作，不推荐。
 * <p>
 * 假设有两个线程同时想创建一个实例，由于在一个时刻只有一个线程能得到同步锁，当第一个线程加上锁时，
 * 第二个线程只能等待。当第一个线程发现实例还没有创建，它创建出一个实例。接着第一个线程释放同步锁，
 * 此时第二个线程可以加上同步锁，并运行接下来的代码。这时候由于实例已经被第一个线程创建出来了，
 * 第二个线程就不会重复创建实例了，这样就保证了我们在多线程环境中也只能得到一个实例。
 * 但是这里有个缺陷，每次通过Instance得到其实例的时候，都会试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要的时候我们应该尽量避免。
 */
public class Singleton_03 {

    private static Singleton_03 singleton_03;

    private Singleton_03() {

    }

    public static Singleton_03 getInstance() {
        synchronized (Singleton_03.class) {
            if (singleton_03 == null) {
                singleton_03 = new Singleton_03();
            }
        }
        return singleton_03;
    }

    public static void main(String[] args) {
        System.out.println(Singleton_03.getInstance().hashCode());
        System.out.println(Singleton_03.getInstance().hashCode());
    }

}
