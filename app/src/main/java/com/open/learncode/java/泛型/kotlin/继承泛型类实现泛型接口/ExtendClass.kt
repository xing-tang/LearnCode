package com.open.learncode.java.泛型.kotlin.继承泛型类实现泛型接口

open class ExtendClass<V> {

    open fun show(value: V) {
        println("继承泛型类 ExtendClass show：$value")
    }
}