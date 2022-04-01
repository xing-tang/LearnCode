package com.open.learncode.设计模式.工厂模式.简单工厂模式;

public class TestDemo {
    public static void main(String[] args) {
        IPhone phone = PhoneFactory.createCar(PhoneFactory.TYPE_HUAWEI);
        phone.callPhone("17611643275");
    }
}
