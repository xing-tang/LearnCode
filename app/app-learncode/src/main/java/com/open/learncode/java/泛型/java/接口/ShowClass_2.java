package com.open.learncode.java.泛型.java.接口;

public class ShowClass_2<T> implements IShow<T> {
    public void show(T t) {
        System.out.println("泛型接口 实现类类型不确定，show:" + t);
    }
}
