package com.open.learncode.剑指offer.面试题02_单例模式;

/**
 * 单例模式，静态代码块
 * 提示：单线程安全，多线程安全，有个缺陷，不推荐使用这种方式。
 * <p>
 * 静态代码块只在类加载的时候调用一次（静态方法调用等第一次用到该类的时候），后续不再调用。
 * 但是调用任何当前类的静态方法，都会创建实例，从而导致过早创建。
 */
public class Singleton_05 {

    private static Singleton_05 singleton_05;

    private Singleton_05() {

    }

    static {
        singleton_05 = new Singleton_05();
    }

    public static void func() {

    }

    public static Singleton_05 getInstance() {
        return singleton_05;
    }

    public static void main(String[] args) {
        Singleton_05.func();
        System.out.println(Singleton_05.getInstance().hashCode());
        System.out.println(Singleton_05.getInstance().hashCode());
    }

}
