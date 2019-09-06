package com.open.learncode.剑指offer.面试题02_单例模式;

/**
 * 单例模式，懒汉模式，为空才new
 * 提示：单线程安全，多线程不安全，不推荐使用这种方式。
 * <p>
 * 如果多个线程同时运行到if (singletonImp2 == null) 就会创建多个对象，不推荐使用这种方式
 */
public class Singleton_02 {

    private static Singleton_02 singleton_02;

    private Singleton_02() {

    }

    public static Singleton_02 getInstance() {
        if (singleton_02 == null) {
            singleton_02 = new Singleton_02();
        }
        return singleton_02;
    }

    public static void main(String[] args) {
        System.out.println(Singleton_02.getInstance().hashCode());
        System.out.println(Singleton_02.getInstance().hashCode());
    }
}
