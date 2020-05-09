package com.open.learncode.剑指offer;

/**
 * 题目：
 * 数字序列中某一位的数字：数字以0123456789101112131415...的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数，求任意
 * 第n位对应的数字。
 * <p>
 * 解题思路：
 *
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)
 * 【所求数位n对应数字num的位数digit最大为O(logn);第一步最多循环O(logn)次；
 * 第三步中将num转化为字符串使用O(logn)时间；因此总体为O(logn)】
 * 空间复杂度：O(logn)
 * 【将数字num转化为字符串str(num)，占用O(logn)的额外空间】
 * 注意：这里的log以10为底
 */

public class TestMethod44 {

    public static void main(String[] args) {

        int index = 1;
        System.out.println("第" + index + "位对应的数字为：" + method(index));

    }


    private static int method(int index) {

        if (index < 0)
            return -1;

        //如果要找第0位对应的数字，返回0
        if (index == 0)
            return 0;

        //digit：一个数的位数，从个位数1-9找起
        int digit = 1;
        //start：每digit位数的起始数字
        long start = 1;
        //count：digit位数的总个数
        long count = 9;

        while (index > count) { // 1.确定所求数位的所在数字的位数
            index -= count;

            //位数+1，十位数10-99，百位数100-999
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }

        long num = start + (index - 1) / digit; // 2.确定所求数位所在的数字
        return Long.toString(num).charAt((index - 1) % digit) - '0'; // 3.确定所求数位在 num 的哪一数位


    }

}