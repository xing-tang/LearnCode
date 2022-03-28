package com.open.learncode.java.泛型.kotlin.继承泛型类实现泛型接口

class SubClass<T1, T2> : ExtendClass<T2>(), IImpl<String> {

    override fun show(t: T2) {
        super.show(t)
    }

    override fun print(key: String) {
        println("实现泛型接口 IImpl print：$key")
    }
}