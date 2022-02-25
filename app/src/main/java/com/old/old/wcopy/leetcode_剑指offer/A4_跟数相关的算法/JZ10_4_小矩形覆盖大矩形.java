package com.old.old.wcopy.leetcode_剑指offer.A4_跟数相关的算法;

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
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ10_4_小矩形覆盖大矩形 {

    public static void main(String[] args) {
        System.out.println(method(5));
    }

    /**
     * 循环，从下往上计算
     *
     * @param n 输入的参数
     * @return 返回斐波那契数列的第n项
     */
    private static long method(int n) {
        if (n <= 2) return n;

        int current = 0;
        int prev1 = 2;
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}

