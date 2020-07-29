package com.open.learncode.剑指offer.每日回顾.day_01;

/**
 * 单例模式，静态代码块
 * 提示：单线程安全，多线程安全，推荐使用这种方式。
 * <p>
 * 静态代码块只在类加载的时候调用一次（静态方法调用等第一次用到该类的时候），后续不再调用。
 * 使用静态代码块，如果该类中还有其他静态方法，调用后就会执行静态代码块使得对象过早创建
 * 使用一个静态类来创建Singleton，其他静态方法只要没有调用Nested.singletonImp6就不会创建Singleton
 * 实现了需要时才创建实例对象，避免过早创建.
 */
public class Singleton_02 {

    public static void main(String[] args) {
        // 打印两次HashCode对比
//        System.out.println(Singleton_02.getInstance().hashCode());
//        System.out.println(Singleton_02.getInstance().hashCode());
    }

    public static Singleton_02 instance;

    public static Singleton_02 getInstance() {
        return Holder.singleton_02;
    }

    static class Holder{
        public static Singleton_02 singleton_02 = new Singleton_02();
    }

}
