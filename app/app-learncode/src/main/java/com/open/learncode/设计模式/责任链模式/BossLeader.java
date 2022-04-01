package com.open.learncode.设计模式.责任链模式;

/**
 * 老板类
 */
public class BossLeader extends AbstractLeader {

    public BossLeader() {
        super(40000);
    }

    @Override
    protected void reply(AbstractPerson person) {
        System.out.println("老板批复申请: 同意报销（" + person.getMoney() + "）！");
    }
}
