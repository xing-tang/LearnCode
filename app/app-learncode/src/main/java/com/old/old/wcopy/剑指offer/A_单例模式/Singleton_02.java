package com.old.old.wcopy.剑指offer.A_单例模式;

/**
 * 单例模式，静态代码块
 * 提示：单线程安全，多线程安全，推荐使用这种方式。
 * <p>
 * 利用 JAVA 虚拟机加载类的特性实现延迟加载和线程安全【类加载机制】
 *
 * 由于静态单例对象没有作为 Singleton 的成员变量直接实例化，因此类加载时不会实例化 Singleton，
 * 第一次调用 getInstance() 时将加载内部类 Holder，在该内部类中定义了一个 static 类型的变量 singleton_02，此时会首先初始化这个成员变量，
 * 由 Java 虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。
 * 由于 getInstance() 方法没有任何线程锁定，因此其性能不会造成任何影响。
 */
public class Singleton_02 {

    private Singleton_02() {
    }

    private static class Holder {
        private static Singleton_02 singleton_02 = new Singleton_02();
    }

    public static Singleton_02 getInstance() {
        return Holder.singleton_02;
    }

    public static void func() {

    }

    public static void main(String[] args) {
        Singleton_02.func();
        System.out.println(Singleton_02.getInstance().hashCode());
        System.out.println(Singleton_02.getInstance().hashCode());
    }
}
