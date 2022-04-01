package com.open.learncode.java.并发.锁;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Manager2());
        TimeUnit.SECONDS.sleep(1);
        exec.execute(new Manager1());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main()");
    }
}

class NotifyDest {

    public synchronized void methodA() {
        System.out.println("methodA()");
        // 唤醒等待该锁的所有线程
        notify();
        System.out.println("exit");
    }

    public synchronized void methodB() {
        try {
            wait();//挂起当前线程，并释放锁
            System.out.println("methodB()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Manager {
    static NotifyDest notifyDest = new NotifyDest();
}

class Manager1 extends Manager implements Runnable {
    public void run() {
        notifyDest.methodA();
    }
}

class Manager2 extends Manager implements Runnable {
    public void run() {
        notifyDest.methodB();
    }
}