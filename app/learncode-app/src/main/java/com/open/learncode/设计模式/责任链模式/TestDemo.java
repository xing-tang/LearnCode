package com.open.learncode.设计模式.责任链模式;

public class TestDemo {

    public static void main(String[] args) {
        // 初始化员工，并且赋值将要报销的出差金额
        Person person = new Person(3000);
        // 初始化各种领导
        AbstractLeader group = new GroupLeader();
        AbstractLeader director = new DirectorLeader();
        AbstractLeader manager = new ManagerLeader();
        AbstractLeader boss = new BossLeader();
        // 设置领导的领导
        group.setLeader(director);
        director.setLeader(manager);
        manager.setLeader(boss);
        // 申请报销
        person.getRequest(group);
    }
}
