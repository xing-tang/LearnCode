package com.open.learncode.设计模式.代理模式.静态代理;

public class PersonProxy implements IPerson {

    // 要代理的实现类
    private IPerson person;

    public PersonProxy(Person person) {
        this.person = person;
    }

    @Override
    public void print() {
        System.out.println("静态代理开始打印...");
        person.print();
        System.out.println("静态代理结束打印...");
    }
}
