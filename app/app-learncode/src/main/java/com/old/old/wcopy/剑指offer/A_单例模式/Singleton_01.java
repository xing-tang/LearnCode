package com.old.old.wcopy.剑指offer.A_单例模式;

/**
 * 单例模式，二次判空同步锁
 * 提示：单线程安全，多线程安全，推荐。
 * <p>
 * 只有第一次创建的时候才会加锁。
 * <p>
 * 两次判空加锁的作用？
 * 第一次：避免加锁
 * 第二次：进行实例化
 * <p>
 * 构造函数私有？
 * 无法通过调用该类的构造函数来实例化该类的对象，只有通过该类提供的静态方法 getInstance 来得到该类的唯一实例
 * <p>
 * synchronized的作用？
 * 假设有两个线程同时想创建一个实例，由于在一个时刻只有一个线程能得到同步锁，当第一个线程加上锁时，
 * 第二个线程只能等待。当第一个线程发现实例还没有创建，它创建出一个实例。接着第一个线程释放同步锁，
 * 此时第二个线程可以加上同步锁，并运行接下来的代码。这时候由于实例已经被第一个线程创建出来了，
 * 第二个线程就不会重复创建实例了，这样就保证了我们在多线程环境中也只能得到一个实例。
 * 但是这里有个缺陷，每次通过Instance得到其实例的时候，都会试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要的时候我们应该尽量避免。
 * <p>
 * volatile关键字的作用？
 * 双重检锁单例模式在 CPU 的工作流，主要分为三步，1：分配内存对象空间。2：初始化对象。3：设置 instance 执行刚才分配的内存地址。
 * 注意 JVM 和 CPU 优化会指令重排，上面顺序会变成 1 -> 3 -> 2，单线程环境下，此顺序是没有问题，2 和 3 前后没有依赖性，
 * 但是在多线程情况下会有这种情况，当线程 A 在执行第 5 行代码时，B 线程进来执行到第 2 行代码。
 * 假设此时 A 执行的过程中发生了指令重排序，即先执行了 1 和 3，没有执行 2。那么由于 A 线程执行了 3 导致 instance 指向了一段地址，
 * 所以 B 线程判断 instance 不为 null，会直接跳到第 6 行并返回一个未初始化的对象，此时会产生空指针异常。
 * volatile 能保持指令的有序性，能够有效禁止指令重排序。
 */
public class Singleton_01 {

    private static volatile Singleton_01 singleton_01;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() { // 1
        if (singleton_01 == null) { // 2
            synchronized (Singleton_01.class) { // 3
                if (singleton_01 == null) { // 4
                    singleton_01 = new Singleton_01(); // 5
                }
            }
        }
        return singleton_01;
    }

    public static void main(String[] args) {
        System.out.println(Singleton_01.getInstance().hashCode());
        System.out.println(Singleton_01.getInstance().hashCode());
    }
}
