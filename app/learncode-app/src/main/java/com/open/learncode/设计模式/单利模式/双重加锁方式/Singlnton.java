package com.open.learncode.设计模式.单利模式.双重加锁方式;

public class Singlnton {

    private static volatile Singlnton singlnton;

    public Singlnton() {
    }

    public static Singlnton getSinglnton() {
        if (singlnton == null) {
            synchronized (Singlnton.class) {
                if (singlnton == null) {
                    singlnton = new Singlnton();
                }
            }
        }
        return singlnton;
    }
}
