package com.open.learncode.算法.test.A2_单例模式;

public class Singltton_02 {

    public Singltton_02() {

    }

    public static Singltton_02 getInstance() {
        return Holder.singltton_02;
    }

    private static class Holder {
        private static Singltton_02 singltton_02 = new Singltton_02();
    }

}
