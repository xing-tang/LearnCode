package com.open.learncode.算法.java.剑指offer.A1_单例模式

import com.open.learncode.算法.base.PrintUtils

/**
 * 题目：
 * 单例模式，by lazy。
 * <p>
 * 解题思路：
 * lateinit和by lazy的区别：
 * lateinit只能用于修饰变量var，不能用于可空的属性和Java的基本类型。
 * lateinit可以在任何位置初始化并且可以初始化多次。
 *
 * lazy()只能用于修饰常量val，并且lazy()是线程安全的。
 * lazy()是一个函数，可以接受一个Lambda表达式作为参数，第一次调用时会执行Lambda表达式，以后调用该属性会返回之前的结果。
 * 源码分析：https://www.jianshu.com/p/46f333d496b5
 */
class JZ0_3_单例模式 {

    companion object {

        val instance: JZ0_3_单例模式 by lazy { JZ0_3_单例模式() }

        @JvmStatic
        fun main(args: Array<String>) {
            PrintUtils.getInstance().print(JZ0_3_单例模式.instance.hashCode(), "hashCode()")
            PrintUtils.getInstance().print(JZ0_3_单例模式.instance.hashCode(), "hashCode()")
        }
    }
}