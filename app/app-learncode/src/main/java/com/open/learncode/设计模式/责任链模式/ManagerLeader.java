package com.open.learncode.设计模式.责任链模式;

/**
 * 经理类
 */
public class ManagerLeader extends AbstractLeader {

    public ManagerLeader() {
        super(20000);
    }

    @Override
    protected void reply(AbstractPerson person) {
        System.out.println("经理批复申请: 同意报销（" + person.getMoney() + "）！");
    }
}
