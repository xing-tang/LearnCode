package com.open.learncode.java.泛型.java;

import com.open.learncode.java.泛型.java.接口.ShowClass_1;
import com.open.learncode.java.泛型.java.接口.ShowClass_2;
import com.open.learncode.java.泛型.java.方法.Test;
import com.open.learncode.java.泛型.java.泛型限定.QualifiedClass;
import com.open.learncode.java.泛型.java.类.TestClass;
import com.open.learncode.java.泛型.java.继承泛型类实现泛型接口.SubClass;
import com.open.learncode.java.泛型.java.通配符.WildCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestMethod {

    public static void main(String[] args) {
        // 泛型类
        TestClass<String, String> testClass = new TestClass<String, String>("泛型类key", "泛型类value");
        System.out.println(testClass.getKey());
        System.out.println(testClass.getValue());
        // 泛型接口
        // 实现类确定了类型
        ShowClass_1 obj_1 = new ShowClass_1();
        obj_1.show("Java");
        // 实现类类型不确定
        ShowClass_2<Integer> obj_2 = new ShowClass_2<Integer>();
        obj_2.show(6);
        // 泛型方法
        Test test = new Test();
        test.show("Java");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        test.print(arrayList);
        // 继承泛型类，实现泛型接口
        SubClass<String, Integer> subClass = new SubClass<String, Integer>();
        subClass.show(666);
        subClass.print("你今天吃饭了吗？");
        // 通配符
        WildCard<?> wildCard = null;
        wildCard = new WildCard<ArrayList>();
        wildCard = new WildCard<LinkedList>();
        // 泛型限定
        // 上行限定
        QualifiedClass<? extends List> qualifiedClass_1 = null;
        qualifiedClass_1 = new QualifiedClass<ArrayList>();
        qualifiedClass_1 = new QualifiedClass<LinkedList>();
        // 下行限定
        QualifiedClass<? super HashMap> qualifiedClass_2 = null;
        qualifiedClass_2 = new QualifiedClass<HashMap>();
        qualifiedClass_2 = new QualifiedClass<Map>();
    }


}
