package com.open.learncode.设计模式.建造者Builder模式;

public class TestDemo {
    public static void main(String[] args) {
        Person.Builder builder = new Person.Builder();
        Person person = builder.name("张三")
                .age(18)
                .height(178.5)
                .weight(67.4)
                .build();
        person.toString();
    }
}
