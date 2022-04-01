package com.open.learncode.java.泛型.java.接口;

public class ShowClass_1 implements IShow<String> {
    public void show(String str) {
        System.out.println("泛型接口，实现类确定了类型 show:" + str);
    }
}
