package com.open.learncode.设计模式.工厂模式.抽象工厂模式;

public class HuaweiPhone implements IHuawei {

    @Override
    public void getHuaweiP30(int number) {
        System.out.println("出货" + number + "台华为P30型号手机");
    }

    @Override
    public void getHuaweiP40(int number) {
        System.out.println("出货" + number + "台华为P40型号手机");
    }
}
