package com.open.learncode.算法.java.nowcoder

/**
 *
 * {@link }
 */
class JZ02_3_单例模式 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            print(JZ02_3_单例模式.instance.hashCode())
            print(JZ02_3_单例模式.instance.hashCode())
        }

        val instance: JZ02_3_单例模式 by lazy { JZ02_3_单例模式() }
    }
}