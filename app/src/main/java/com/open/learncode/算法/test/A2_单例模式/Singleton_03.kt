package com.open.learncode.算法.test.A2_单例模式

class Singleton_03 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {}
        val instance: Singleton_03 by lazy { Singleton_03() }
    }
}