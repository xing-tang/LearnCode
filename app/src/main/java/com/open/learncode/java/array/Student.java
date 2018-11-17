package com.open.learncode.java.array;

/**
 * 自定义的学生类型
 * 具备姓名、年龄信息
 */
public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Student(name：%s，age：%d)", name, age);
    }
}
