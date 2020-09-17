package com.open.learncode.算法.test.A2_单例模式

class Singltton_03 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {}
        val instance: Singltton_03 by lazy { Singltton_03() }
    }
}