package com.open.learncode.java.泛型.java.继承泛型类实现泛型接口;

public class SubClass<T1, T2> extends ExtendClass<T2> implements IImpl<String> {

    @Override
    public void show(T2 t) {
        super.show(t);
    }

    @Override
    public void print(String key) {
        System.out.println("实现泛型接口 IImpl print：" + key);
    }
}
