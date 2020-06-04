package com.open.learncode.设计模式.单利模式.Kotlin中的单例

class Singlnton {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        val instance: Singlnton by lazy { Singlnton() }
    }
}