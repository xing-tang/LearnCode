package com.open.learncode.剑指offer.每日回顾.day_01;

/**
 * 题目：
 * 我们可以用2x1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用8个2x1的小矩形无重叠地覆盖一个2x8的大矩形，总共有多少种方法？
 * ロ  ロロロロロロロロ
 * ロ  ロロロロロロロロ
 * <p>
 * 解题思路：
 * 当n=1，只有一种排列方式
 * 当n=2，有两种跳法
 * 当n=3，有三种跳法
 * 当n=4，有五种跳法
 * 因此，因此可得还是一个斐波那契数列。
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(2^n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod10_4 {

    public static void main(String[] args) {
        System.out.println();
    }

}

