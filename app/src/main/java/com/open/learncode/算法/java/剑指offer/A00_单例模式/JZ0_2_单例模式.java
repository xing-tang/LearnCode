package com.open.learncode.算法.java.剑指offer.A00_单例模式;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 单例模式，静态代码块。
 * <p>
 * 解题思路：
 * 静态代码块只在类加载的时候调用一次（静态方法调用等第一次用到该类的时候），后续不再调用。
 * 使用静态代码块，如果该类中还有其他静态方法，调用后就会执行静态代码块使得对象过早创建
 * 使用一个静态类来创建Singleton，其他静态方法只要没有调用Nested.singletonImp6就不会创建Singleton
 * 实现了需要时才创建实例对象，避免过早创建.
 */
public class JZ0_2_单例模式 {

    private JZ0_2_单例模式() {

    }

    private static class Holder {
        public static JZ0_2_单例模式 instance = new JZ0_2_单例模式();
    }

    public static JZ0_2_单例模式 getInstance() {
        return Holder.instance;
    }

    public static void main(String[] args) {
        PrintUtils.getInstance().print(JZ0_2_单例模式.getInstance().hashCode(), "hashCode()");
        PrintUtils.getInstance().print(JZ0_2_单例模式.getInstance().hashCode(), "hashCode()");
    }
}
