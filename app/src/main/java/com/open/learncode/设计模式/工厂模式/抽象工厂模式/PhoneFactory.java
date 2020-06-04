package com.open.learncode.设计模式.工厂模式.抽象工厂模式;


public class PhoneFactory implements IPhoneFactory {
    @Override
    public IHuawei createHuaweiProduct() {
        return new HuaweiPhone();
    }

    @Override
    public IXiaomi createXiaomiProduct() {
        return new XiaomiPhone();
    }
}
