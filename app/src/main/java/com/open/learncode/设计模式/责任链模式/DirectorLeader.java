package com.open.learncode.设计模式.责任链模式;

/**
 * 主管类
 */
public class DirectorLeader extends AbstractLeader {

    public DirectorLeader() {
        super(10000);
    }

    @Override
    protected void reply(AbstractPerson person) {
        System.out.println("主管批复申请: 同意报销（" + person.getMoney() + "）！");
    }
}
