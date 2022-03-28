package com.open.learncode.设计模式.代理模式.静态代理;

/**
 * 具体主题类
 */
public class Person implements IPerson {

    /**
     * 具体的业务逻辑实现
     */
    @Override
    public void print() {
        System.out.println("张三打印资料...");
    }
}
