package com.open.learncode.算法.java.剑指offer.A00_单例模式

import com.open.learncode.算法.base.PrintUtils

/**
 * 题目：
 * 单例模式，by lazy。
 * <p>
 * 解题思路：
 * lateinit 和 by lazy 的区别：
 * lateinit 只能用于修饰变量 var，不能用于可空的属性和 Java 的基本类型。
 * lateinit 可以在任何位置初始化并且可以初始化多次。
 *
 * lazy() 只能用于修饰常量 val，并且 lazy() 是线程安全的。
 * lazy() 是一个函数，可以接受一个 Lambda 表达式作为参数，第一次调用时会执行 Lambda 表达式，以后调用该属性会返回之前的结果。
 * 源码分析：https://www.jianshu.com/p/46f333d496b5
 */
class JZ0_3_单例模式 {

    companion object {

        val instance: JZ0_3_单例模式 by lazy { JZ0_3_单例模式() }

        @JvmStatic
        fun main(args: Array<String>) {
            PrintUtils.getInstance().print(instance.hashCode(), "hashCode()")
            PrintUtils.getInstance().print(instance.hashCode(), "hashCode()")
        }
    }
}