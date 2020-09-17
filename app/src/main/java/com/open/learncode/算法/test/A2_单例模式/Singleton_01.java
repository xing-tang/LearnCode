package com.open.learncode.算法.test.A2_单例模式;

public class Singleton_01 {
    private static volatile Singleton_01 singleton_01;
    private Singleton_01() { }
    public static Singleton_01 getInstance() {
        if (singleton_01 == null) {
            synchronized (Singleton_01.class) {
                if (singleton_01 == null) {
                    singleton_01 = new Singleton_01();
                }
            }
        }
        return singleton_01;
    }
}
