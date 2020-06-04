package com.open.learncode.设计模式.责任链模式;

/**
 * 所有领导的权利接口
 */
public interface IPower {
    /**
     * 处理请求
     *
     * @param persopn 具体某员工
     */
    public void handleRequest(AbstractPerson persopn);
}
