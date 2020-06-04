package com.open.learncode.设计模式.单利模式.静态内部类;

public class Singlnton {

    public Singlnton() {

    }

    private static class SinglntonHolder {
        public static Singlnton INSTANCE = new Singlnton();
    }

    private static Singlnton getInstance() {
        return SinglntonHolder.INSTANCE;
    }
}
