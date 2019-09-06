package com.open.learncode.剑指offer.面试题02_单例模式;

/**
 * 单例模式，二次判空同步锁
 * 提示：单线程安全，多线程安全，推荐。
 * <p>
 * 只有第一次创建的时候才会加锁。
 */
public class Singleton_04 {

    private static Singleton_04 singleton_04;

    private Singleton_04() {

    }

    public static Singleton_04 getInstance() {
        if (singleton_04 == null) {
            synchronized (Singleton_04.class) {
                if (singleton_04 == null) {
                    singleton_04 = new Singleton_04();
                }
            }
        }
        return singleton_04;
    }

    public static void main(String[] args) {
        System.out.println(Singleton_04.getInstance().hashCode());
        System.out.println(Singleton_04.getInstance().hashCode());
    }

}
