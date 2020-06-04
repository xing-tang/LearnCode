package com.open.learncode.设计模式.责任链模式;

/**
 * 员工类
 */
public class Person extends AbstractPerson {

    // 声明整型成员变量表示报销费用
    private int money;

    /**
     * 含参构造方法
     */
    public Person(int money) {
        this.money = money;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void getRequest(AbstractLeader leader) {
        System.out.println("出差费用报销申请=>");
        leader.handleRequest(this);
    }
}
