package com.open.learncode.java.泛型.kotlin.方法

class Test {
    fun <T> show(t: T) {
        println(t)
    }

    fun <T : List<*>> print(t: T) {
        println(t.toString())
    }
}