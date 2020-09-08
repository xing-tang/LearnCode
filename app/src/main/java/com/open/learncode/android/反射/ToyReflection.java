package com.open.learncode.android.反射;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ToyReflection {
    public static void printInfo(String info, Object obj) {
        if (obj.getClass().isArray()) {
            System.out.println(info + ": ");
            int length = Array.getLength(obj);
            System.out.println("Array Size: " + length);
            for (int i = 0; i < length; i++) {
                System.out.print("Array[" + i + "]: " + Array.get(obj, i) + ", ");
            }
            if (length != 0)
                System.out.println();
        }
        System.out.println(info + ": " + obj.toString());
    }

    public static void main(String[] args) {
//        try { // 获得类对象
//            Class<?> c = Class.forName("***.***.***");
//            printInfo("获得类对象", c); // 获得超类
//            Class<?> superClass = c.getSuperclass();
//            printInfo("获得超类", superClass); // 获得所有父接口
//            Class<?>[] interfaces = c.getInterfaces();
//            printInfo("获得所有父接口", interfaces); // 实例化
//            Toy toy = (Toy) c.newInstance();
//            printInfo("实例化", toy); // 获得访问属性为public的构造方法
//            Constructor<?>[] constructors = c.getConstructors();
//            printInfo("获得构造方法", constructors); // 获得指定参数的构造方法
//            Constructor<?> constructor = c.getDeclaredConstructor(String.class, String.class, int.class);
//            printInfo("获得指定构造方法", constructor); // 获得方法，getMethod只能获得public方法，包括父类和接口继承的方法
//            Method method = c.getMethod("playToy", String.class);
//            printInfo("获得公有方法", method); // 调用方法
//            method.invoke(toy, "张三"); // 获得修饰符，包括private/public/protect,static
//            String modifier = Modifier.toString(method.getModifiers());
//            printInfo("获得修饰符", modifier); // 获得参数类型
//            Class<?>[] paramTypes = method.getParameterTypes();
//            printInfo("获得参数类型", paramTypes); // 获得返回值类型
//            Class<?> returnType = method.getReturnType();
//            printInfo("获得返回值类型", returnType); // 获得异常类型
//            Class<?>[] excepTypes = method.getExceptionTypes();
//            printInfo("获得异常类型", excepTypes); // 调用私有方法，getDeclaredMethod获得类自身的方法，包括public,protect,private方法
//            Method method2 = c.getDeclaredMethod("buildMsg", String.class);
//            method2.setAccessible(true);
//            String result = (String) method2.invoke(toy, "李四");
//            printInfo("获得私有方法", result); // 获得全部属性
//            Field[] fields = c.getFields();
//            printInfo("获得全部属性", fields); // 获得类自身定义的指定属性
//            Field field = c.getDeclaredField("name");
//            printInfo("获得自身属性", field); // 获得类及其父类，父接口定义的public属性
//            Field field2 = c.getField("color");
//            printInfo("获得公有属性", field2); // 获得权限修饰符，包括private/public/protect,static,final
//            String fieldModifier = Modifier.toString(field.getModifiers());
//            printInfo("获得权限修饰符", fieldModifier); // 操作数组
//            int[] exampleArray = {1, 2, 3, 4, 5}; // 获得数组类型
//            Class<?> componentType = exampleArray.getClass().getComponentType();
//            printInfo("数组类型", componentType.getName()); // 获得长度
//            printInfo("数组长度", Array.getLength(exampleArray)); // 获得指定元素
//            printInfo("获得数组元素", Array.get(exampleArray, 2)); // 修改指定元素
//            Array.set(exampleArray, 2, 6);
//            printInfo("修改数组元素", exampleArray); // 获得当前的类加载器
//            printInfo("获得当前类加载器", toy.getClass().getClassLoader().getClass().getName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }
}
