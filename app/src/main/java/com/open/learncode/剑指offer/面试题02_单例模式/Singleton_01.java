package com.open.learncode.剑指offer.面试题02_单例模式;

/**
 * 单例模式，饿汉模式，不管为不为空，先直接new一个出来
 * 提示：单线程安全，多线程不安全，不推荐使用这种方式。
 */
public class Singleton_01 {

    private static Singleton_01 singleton_01 = new Singleton_01();

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        return singleton_01;
    }

    public static void main(String[] args) {
        System.out.println(Singleton_01.getInstance().hashCode());
        System.out.println(Singleton_01.getInstance().hashCode());
    }

}