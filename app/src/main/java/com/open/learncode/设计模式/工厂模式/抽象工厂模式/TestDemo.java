package com.open.learncode.设计模式.工厂模式.抽象工厂模式;

public class TestDemo {
    public static void main(String[] args) {
        // 采购商需要采购100台华为P40和150台华为P30
        PhoneFactory phoneFactory = new PhoneFactory();
        phoneFactory.createHuaweiProduct().getHuaweiP30(100);
        phoneFactory.createHuaweiProduct().getHuaweiP40(150);
        // 采购商需要采购200台小米3和250台小米4
        phoneFactory.createXiaomiProduct().getXiaomi3(200);
        phoneFactory.createXiaomiProduct().getXiaomi4(250);
    }
}
