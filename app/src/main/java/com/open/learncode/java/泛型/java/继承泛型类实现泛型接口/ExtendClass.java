package com.open.learncode.java.泛型.java.继承泛型类实现泛型接口;

public class ExtendClass<V> {

    public void show(V value) {
        System.out.println("继承泛型类 ExtendClass show：" + value);
    }
}
