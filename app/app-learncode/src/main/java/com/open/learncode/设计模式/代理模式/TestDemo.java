package com.open.learncode.设计模式.代理模式;

import android.view.Window;

import com.open.learncode.设计模式.代理模式.JDK动态代理.ProxyFactory;
import com.open.learncode.设计模式.代理模式.静态代理.IPerson;
import com.open.learncode.设计模式.代理模式.静态代理.Person;
import com.open.learncode.设计模式.代理模式.静态代理.PersonProxy;

/**
 * 示例：张三请别人帮忙打印资料。
 */
public class TestDemo {

    public static void main(String[] args) {
        Person person1 = new Person();
        // 静态代理
        PersonProxy personProxy = new PersonProxy(person1);
        personProxy.print();
        // 动态代理
        IPerson person2 = new Person();
        IPerson proxy = (IPerson) new ProxyFactory(person2).getProxyInstance();
        proxy.print();

    }
}
