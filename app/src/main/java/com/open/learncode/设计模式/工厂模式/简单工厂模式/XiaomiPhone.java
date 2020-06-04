package com.open.learncode.设计模式.工厂模式.简单工厂模式;

public class XiaomiPhone implements IPhone {
    @Override
    public void callPhone(String phoneNumber) {
        System.out.println("使用小米手播机打电话：" + phoneNumber);
    }
}
