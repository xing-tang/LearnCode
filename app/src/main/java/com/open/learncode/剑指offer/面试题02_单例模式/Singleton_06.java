package com.open.learncode.剑指offer.面试题02_单例模式;

/**
 * 单例模式，静态代码块
 * 提示：单线程安全，多线程安全，推荐使用这种方式。
 * <p>
 * 静态代码块只在类加载的时候调用一次（静态方法调用等第一次用到该类的时候），后续不再调用。
 * 使用静态代码块，如果该类中还有其他静态方法，调用后就会执行静态代码块使得对象过早创建
 * 使用一个静态类来创建Singleton，其他静态方法只要没有调用Nested.singletonImp6就不会创建Singleton
 * 实现了需要时才创建实例对象，避免过早创建.
 */
public class Singleton_06 {

    private Singleton_06() {

    }

    private static class Nested {
        private static Singleton_06 singleton_06;

        static {
            singleton_06 = new Singleton_06();
        }
    }

    public static void func() {

    }

    public static Singleton_06 getInstance() {
        return Nested.singleton_06;
    }

    public static void main(String[] args) {
        Singleton_06.func();
        System.out.println(Singleton_06.getInstance().hashCode());
        System.out.println(Singleton_06.getInstance().hashCode());
    }

}
