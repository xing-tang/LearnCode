package com.open.learncode.设计模式.责任链模式;

/**
 * 员工抽象类
 */
public abstract class AbstractPerson {
    /**
     * 获取元具体的报销费用
     *
     * @return 要多少钱
     */
    public abstract int getMoney();

    /**
     * 申请报销
     *
     * @return Just a request
     */
    public abstract void getRequest(AbstractLeader leader);
}
