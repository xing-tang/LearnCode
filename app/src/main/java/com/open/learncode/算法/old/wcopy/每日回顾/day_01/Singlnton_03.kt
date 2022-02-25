package com.open.learncode.算法.old.wcopy.每日回顾.day_01

/**
 * kotlin单例模式，静态代码块
 * 提示：单线程安全，多线程安全，推荐使用这种方式。
 * <p>
 * lateinit和by lazy的区别：
 * lateinit只能用于修饰变量var，不能用于可空的属性和Java的基本类型。
 * lateinit可以在任何位置初始化并且可以初始化多次。
 * <p>
 * lazy()只能用于修饰常量val，并且lazy()是线程安全的。
 * lazy()是一个函数，可以接受一个Lambda表达式作为参数，第一次调用时会执行Lambda表达式，以后调用该属性会返回之前的结果。
 * 源码分析：https://www.jianshu.com/p/46f333d496b5
 */
class Singlnton_03 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }

        val instance: Singlnton_03 by lazy { Singlnton_03() }
    }
}