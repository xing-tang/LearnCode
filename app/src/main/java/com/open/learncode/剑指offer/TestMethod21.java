package com.open.learncode.剑指offer;


import java.util.Date;

/**
 * 题目：
 * 调整数组顺序使奇数位于偶数前面：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * <p>
 * 解题思路：
 * 快速排序
 * <p>
 * 复杂度分析：
 * 方法一、二：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod21 {

    public static void main(String[] args) {

        int data[] = {1, 2, 3, 4, 5};
        int length = data.length;


        print(data, length);

//        method_1(data, length);
        method_2(data, length);

        print(data, length);


    }

    //基本解法
    private static void method_1(int data[], int length) {

        if (data == null && length == 0)
            return;

        int begin = 0;
        int end = length - 1;

        while (begin < end) {

            //向后移动begin，直到它指向偶数
            while (begin < end && (data[begin] & 1) != 0)
                begin++;

            //向前移动end，直到它指向奇数
            while (begin < end && (data[end] & 1) == 0)
                end--;

            //begin指向偶数，end指向奇数，且begin<end，交换两者位置
            if (begin < end) {
                int temp = data[begin];
                data[begin] = data[end];
                data[end] = temp;
            }
        }
    }

    //扩展性更高，能适应更多的判断标准
    //如：使所有负数位于非负数前面；使能被3整除的数位于不能被3整除的数的前面
    private static void method_2(int data[], int length) {

        if (data == null || length == 0)
            return;

        int begin = 0;
        int end = length - 1;

        while (begin < end) {

            while (begin < end && !func(data, begin))
                begin++;

            while (begin < end && func(data, end))
                end--;

            //begin指向偶数，end指向奇数，且begin<end，交换两者位置
            if (begin < end) {
                int temp = data[begin];
                data[begin] = data[end];
                data[end] = temp;
            }

        }
    }

    private static boolean func(int data[], int position) {
        return ((data[position] & 1) == 0);
    }

    private static void print(int data[], int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i != length - 1)
                System.out.print(data[i] + ",");
            else
                System.out.print(data[i] + "]");
        }
        System.out.println();

    }

}