package com.open.learncode.java.泛型.kotlin.接口

import com.open.learncode.java.泛型.java.接口.IShow

class ShowClass_1 : IShow<String> {
    override fun show(str: String) {
        println("泛型接口，实现类确定了类型 show:$str")
    }
}