package com.open.learncode.设计模式.观察者模式;

// 具体的观察者
public class PoliceObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("状态发生改变：");
        ((ThiefObservable) o).capture();
    }
}
