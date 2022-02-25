package com.open.learncode.算法.old.wcopy.leetcode_剑指offer.A4_跟数相关的算法;

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
public class JZ44_数字序列中某一位的数字 {

    public static void main(String[] args) {
        System.out.println(method(10));
        System.out.println(method(11));
        System.out.println(method(12));
        System.out.println(method(13));
        System.out.println(method(228));
    }

    /**
     * 根据数学归纳法
     *
     * @param n 待传入的整数
     * @return 返回1一共出现的次数
     */
    public static int method(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        System.out.println("num=" + num);
        int x = (n - 1) % digit;
        System.out.println("x=" + x);
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
