package com.open.learncode.设计模式.观察者模式;

import java.util.Vector;

// 被观察者管理类
public class Observable{

    public Vector<Observer> observers;

    public Observable() {
        observers = new Vector<Observer>();
    }

    public void addObserver(Observer observer) {
        if (observers == null) return;
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (observers == null && observers.size() <= 0) {
            return;
        }
        observers.remove(observer);
    }

    public void notifyObservables() {
        notifyObservables(null);
    }

    public void notifyObservables(Object object) {
        if (observers == null && observers.size() <= 0) {
            return;
        }
        for (Observer observer : observers) {
            observer.update(this, object);
        }
    }
}