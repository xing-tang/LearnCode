package com.open.learncode.设计模式.工厂模式.工厂方法模式;


public class XiaomiPhone implements IPhone {

    @Override
    public void plamGame(String gameName) {
        System.out.println("使用小米手机玩游戏：" + gameName);
    }

    @Override
    public void callPhone(String phoneNumber) {
        System.out.println("使用小米手机拨打电话：" + phoneNumber);
    }
}
