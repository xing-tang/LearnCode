package com.open.learncode.设计模式.工厂模式.工厂方法模式;

public class HuaweiFactory implements IPhoneFactory{

    @Override
    public IPhone createPhone() {
        return new HuaweiPhone();
    }
}
