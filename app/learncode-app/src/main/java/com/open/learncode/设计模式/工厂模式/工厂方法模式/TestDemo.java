package com.open.learncode.设计模式.工厂模式.工厂方法模式;

public class TestDemo {
    public static void main(String[] args) {
        // 工厂方法模式
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        IPhone huaweiPhone = huaweiFactory.createPhone();
        huaweiPhone.plamGame("王者荣耀");
        huaweiPhone.callPhone("17611643275");

        XiaomiFactory xiaomiFactory = new XiaomiFactory();
        IPhone xiaomiPhone = huaweiFactory.createPhone();
        xiaomiPhone.plamGame("王者荣耀");
        xiaomiPhone.callPhone("17611643275");

    }
}
