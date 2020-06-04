package com.open.learncode.设计模式.观察者模式;

// 具体的被观察者
public class ThiefObservable extends Observable {

    public void steal() {
        System.out.println("小偷准备偷东西了");
        notifyObservables();
    }

    public void capture() {
        System.out.println("小偷被抓");
    }
}
