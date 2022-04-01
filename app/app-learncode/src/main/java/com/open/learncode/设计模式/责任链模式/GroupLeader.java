package com.open.learncode.设计模式.责任链模式;

/**
 * 小组长类
 */
public class GroupLeader extends AbstractLeader {

    public GroupLeader() {
        super(5000);
    }

    @Override
    protected void reply(AbstractPerson person) {
        System.out.println("小组长批复申请: 同意报销（" + person.getMoney() + "）！");
    }
}
