package com.old.old.剑指offer.A4_跟数相关的算法;


/**
 * 题目：
 * 数值的整数次方：实现函数double Power(double base,int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题
 * <p>
 * 解题思路：
 * 直接乘法，递归
 * <p>
 * 复杂度分析：
 * exponent为指数
 * 时间复杂度：O(log(exponent))。
 * 空间复杂度：O(1)。
 */
public class JZ16_数值的整数次方 {

    public static void main(String[] args) {
        // 测试用例：底数 指数分别设为正数 负数 零
        System.out.println(method_3(2, 3));
        System.out.println(method_3(0, 2));
        System.out.println(method_3(-2, 2));
    }

    /**
     * 非递归的快速幂：
     *
     * @param base     底数
     * @param exponent 指数
     * @return 返回数值的整数次方
     */
    private static double method_3(double base, int exponent) {
        if (exponent == 0) return 1;
        if (base == 0) return 0;
        if (exponent == 1) return base;

        //如果指数<0
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double res = 1.0;
        //如果指数>0
        while (exponent > 0) {
            if ((exponent & 1) == 1) res *= base;
            base *= base;
            exponent >>= 1;// exponent/2
        }
        return res;
    }
}