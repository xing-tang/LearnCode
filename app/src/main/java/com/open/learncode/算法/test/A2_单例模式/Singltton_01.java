package com.open.learncode.算法.test.A2_单例模式;

public class Singltton_01 {

    private static volatile Singltton_01 singltton_01;

    public Singltton_01() {

    }

    public static Singltton_01 getInstance() {
        if (singltton_01 == null) {
            synchronized (Singltton_01.class) {
                if (singltton_01 == null) {
                    singltton_01 = new Singltton_01();
                }
            }
        }
        return singltton_01;
    }
}
