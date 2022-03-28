package com.open.learncode.java.泛型.kotlin

import com.open.learncode.java.泛型.java.接口.ShowClass_2
import com.open.learncode.java.泛型.java.继承泛型类实现泛型接口.SubClass
import com.open.learncode.java.泛型.kotlin.接口.ShowClass_1
import com.open.learncode.java.泛型.kotlin.方法.Test
import com.open.learncode.java.泛型.kotlin.泛型限定.QualifiedClass
import com.open.learncode.java.泛型.kotlin.类.TestClass
import com.open.learncode.java.泛型.kotlin.通配符.WildCard
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class TestMethod {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // 泛型类
            val testClass = TestClass<String, String>("泛型类key", "泛型类value")
            println(testClass.key)
            println(testClass.value)
            // 泛型接口
            // 实现类确定了类型
            val obj_1 = ShowClass_1()
            obj_1.show("Java")
            // 实现类类型不确定
            val obj_2 = ShowClass_2<Int>()
            obj_2.show(6)
            // 泛型方法
            val test = Test()
            test.show("Java")
            val arrayList = ArrayList<Int>()
            arrayList.add(1)
            arrayList.add(2)
            arrayList.add(3)
            test.print(arrayList)
            // 继承泛型类，实现泛型接口
            val subClass = SubClass<String, Int>()
            subClass.show(666)
            subClass.print("你今天吃饭了吗？")
            // 通配符
            var wildCard: WildCard<*>? = null
            wildCard = WildCard<ArrayList<*>>()
            wildCard = WildCard<LinkedList<*>>()
            // 泛型限定
            // 上行限定
            var qualifiedClass_1: QualifiedClass<out List<*>>? = null
            qualifiedClass_1 = QualifiedClass<ArrayList<*>>()
            qualifiedClass_1 = QualifiedClass<LinkedList<*>>()
            // 下行限定
            var qualifiedClass_2: QualifiedClass<in HashMap<*, *>>? = null
            qualifiedClass_2 = QualifiedClass<HashMap<*, *>>()
            qualifiedClass_2 = QualifiedClass<Map<*, *>>()
        }

    }
}