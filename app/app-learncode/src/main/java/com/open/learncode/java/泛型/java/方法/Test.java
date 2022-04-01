package com.open.learncode.java.泛型.java.方法;

import java.util.List;

public class Test {
    public <T> void show(T t) {
        System.out.println(t);
    }

    public <T extends List> void print(T t) {
        System.out.println(t.toString());
    }
}
