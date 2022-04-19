package com.open.learncode.算法.java.剑指offer.A11_补充;

import com.open.learncode.算法.base.PrintUtils;

/**
 * OT_02_单例模式懒汉饱汉
 */
public class OT02_单例模式懒汉饱汉 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(Singleton1.getInstance().hashCode(), "hashCode()");
        PrintUtils.getInstance().print(Singleton1.getInstance().hashCode(), "hashCode()");
        PrintUtils.getInstance().print(Singleton2.getInstance().hashCode(), "hashCode()");
        PrintUtils.getInstance().print(Singleton2.getInstance().hashCode(), "hashCode()");
    }

    // 懒汉-双重判空加锁
    public static class Singleton1 {
        private static volatile Singleton1 instance = null;

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            if (instance == null) {
                synchronized (Singleton1.class) {
                    if (instance == null) {
                        instance = new Singleton1();
                    }
                }
            }
            return instance;
        }
    }

    // 饿汉-静态内部类
    public static class Singleton2 {
        private Singleton2() {
        }

        private static class Holder {
            public static Singleton2 instance = new Singleton2();
        }

        public static Singleton2 getInstance() {
            return Singleton2.Holder.instance;
        }
    }
}
