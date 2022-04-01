package com.open.learncode.java.泛型.kotlin.接口

import com.open.learncode.java.泛型.java.接口.IShow

class ShowClass_2<T> : IShow<T> {
    override fun show(t: T) {
        println("泛型接口 实现类类型不确定，show:$t")
    }
}