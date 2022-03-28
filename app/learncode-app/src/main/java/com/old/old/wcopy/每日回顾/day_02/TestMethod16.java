package com.old.old.wcopy.每日回顾.day_02;

/**
 * 题目：
 * 数值的整数次方：实现函数double Power(double base,int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题
 * <p>
 * 解题思路：
 * 直接乘法，递归
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(exponent)   空间复杂度：O(1)
 * 方法二：时间复杂度：O(log(exponent))   空间复杂度：O(log(exponent))【系统栈】
 * 方法一：时间复杂度：O(log(exponent))   空间复杂度：O(1)
 */
public class TestMethod16 {

    public static void main(String[] args) {
        //测试用例：底数 指数分别设为正数 负数 零
        System.out.println(method(2, 3));
        System.out.println(method(0, 2));
        System.out.println(method(-2, 3));

    }

    private static double method(double m, int n) {
        if (n == 0) return 1;
        if (m == 0) return 0;
        if (n == 1) return m;
        if (n < 0) {
            m = 1 / m;
            n = -n;
        }
        double res = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = m * res;
            }
            m = m * m;
            n = n >> 1;
        }
        return res;
    }
}