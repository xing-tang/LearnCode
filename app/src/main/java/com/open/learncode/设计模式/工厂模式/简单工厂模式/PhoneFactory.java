package com.open.learncode.设计模式.工厂模式.简单工厂模式;

public class PhoneFactory {
    public static final int TYPE_HUAWEI = 1; // 华为
    public static final int TYPE_XIAOMI = 2; // 小米

    public static IPhone createCar(int type) {
        switch (type) {
            case TYPE_HUAWEI:
                return new HuaweiPhone();
            case TYPE_XIAOMI:
            default:
                return new XiaomiPhone();
        }
    }
}
