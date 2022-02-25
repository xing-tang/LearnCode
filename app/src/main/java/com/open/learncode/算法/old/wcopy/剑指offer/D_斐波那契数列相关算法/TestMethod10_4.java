package com.open.learncode.算法.old.wcopy.剑指offer.D_斐波那契数列相关算法;

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
        System.out.println(method_1(5));
        System.out.println(method_2(5));
    }

    /**
     * 递归方法
     *
     * @param n 输入参数
     * @return 返回斐波那契数列的第n项
     */
    public static long method_1(int n) {
        if (n <= 2) {
            return n;
        }
        return method_1(n - 1) + method_1(n - 2);
    }

    /**
     * 循环，从下往上计算
     *
     * @param n 输入的参数
     * @return 返回斐波那契数列的第n项
     */
    private static long method_2(int n) {
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

