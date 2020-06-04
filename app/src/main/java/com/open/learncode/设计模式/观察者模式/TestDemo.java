package com.open.learncode.设计模式.观察者模式;

public class TestDemo {

    public static void main(String[] args) {
        // 创建被观察者对象
        ThiefObservable thiefObservable = new ThiefObservable();
        // 创建观察者对象，并将被观察者对象登记
        PoliceObserver policeObserver = new PoliceObserver();
        // 被观察者订阅观察者
        thiefObservable.addObserver(policeObserver);
        // 被观察者执行某些操作
        thiefObservable.steal();
        // 取消被观察者与观察者之间的订阅关系
        thiefObservable.removeObserver(policeObserver);
        // 被观察者执行某些操作
        thiefObservable.steal();
    }
}
