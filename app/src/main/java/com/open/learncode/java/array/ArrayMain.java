package com.open.learncode.java.array;

public class ArrayMain {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<Integer>(10);
        for (int i = 0; i < 12; i++) {
            arr.addLast(i);
            System.out.println("向数组中所有元素后添加一个新的元素" + i + "=>" + arr.toString());
        }
        System.out.println();
        arr.add(1, 100);
        System.out.println("向数组中索引为1位置添加一个新的元素100=>" + arr.toString());
        arr.addFrist(-1);
        System.out.println("向数组中所有元素前添加一个新的元素-1=>" + arr.toString());
        System.out.println("获取索引坐标为2的元素值=>" + arr.get(2));
        arr.set(2, 101);
        System.out.println("修改索引坐标为2的元素值为101=>" + arr.toString());
        System.out.println("检查当前数组是否包含元素101=>" + arr.contains(101));
        System.out.println("查找数组中元素101的索引坐标=>" + arr.find(101));
        System.out.println("从数组中删除索引坐标为0位置元素=>" + arr.remove(0));
        System.out.println("从数组中删除第一个元素=>" + arr.removeFrist());
        System.out.println("从数组中删除最后一个元素=>" + arr.removeLast());
        arr.removeElement(2);
        System.out.println("从数组中删除元素2=>" + arr.toString());

        System.out.println();
        Student zhangsan = new Student("张三", 22);
        Student lisi = new Student("李四", 33);
        Student wangwu = new Student("王五", 44);
        Array<Student> arr2 = new Array<Student>(10);
        arr2.addFrist(zhangsan);
        arr2.addFrist(lisi);
        arr2.addFrist(wangwu);
        System.out.println("打印Student数组=>" + arr2.toString());



    }
}
