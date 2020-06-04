package com.open.learncode.设计模式.工厂模式.抽象工厂模式;

public class XiaomiPhone implements IXiaomi {

    @Override
    public void getXiaomi3(int number) {
        System.out.println("出货" + number + "台小米3型号手机");
    }

    @Override
    public void getXiaomi4(int number) {
        System.out.println("出货" + number + "台小米4型号手机");
    }
}
