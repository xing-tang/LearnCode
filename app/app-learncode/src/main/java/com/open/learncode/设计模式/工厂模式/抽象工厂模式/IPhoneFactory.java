package com.open.learncode.设计模式.工厂模式.抽象工厂模式;

public interface IPhoneFactory {
    // 创建华为产品
    IHuawei createHuaweiProduct();

    // 创建小米产品
    IXiaomi createXiaomiProduct();
}
