package com.open.learncode.剑指offer.每日回顾.day_02;

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
        System.out.println(method_1(2, -3));
        System.out.println(method_1(0, -3));
        System.out.println(method_1(-2, -3));

        System.out.println(method_2(2, 0));
        System.out.println(method_2(0, 0));
        System.out.println(method_2(-2, 0));

        System.out.println(method_3(2, 2));
        System.out.println(method_3(0, 2));
        System.out.println(method_3(-2, 2));

    }

    private static double method_1(double base, int exponent) {

        //鲁棒性
        if (exponent == 0) return 1;
        if (base == 0) return 0;
        if (exponent == 1) return base;

        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }

        double res = 1.0;
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }

        return res;

    }

    /**
     * 递归的快速幂：
     * a^n=a^(n/2)*a^(n/2)，n为偶数
     * a^n=a^((n-1）/2)*a^((n-1）/2)*a，n为奇数
     * <p>
     * 细节：
     * 用右移运算符(>>)代替了求余运算符(%)来判断一个数是奇数还是偶数
     * 位运算的效率比乘除法及求余运算的效率要高很多
     *
     * @param base     底数
     * @param exponent 指数
     * @return
     */
    private static double method_2(double base, int exponent) {

        //鲁棒性
        if (exponent == 0) return 1;
        if (base == 0) return 0;
        if (exponent == 1) return base;

        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }

        double res = method_2(base, exponent >> 1);
        res *= res;

        if ((exponent & 1) == 1)
            res *= base;

        return res;
    }

    /**
     * 非递归的快速幂：
     *
     * @param base     底数
     * @param exponent 指数
     * @return
     */
    private static double method_3(double base, int exponent) {

        //鲁棒性
        if (exponent == 0) return 1;
        if (base == 0) return 0;
        if (exponent == 1) return base;

        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }

        double res = 1.0;

        while (exponent>0){
            if((exponent&1)==1)
                res*=base;
            base*=base;
            exponent>>=1;

        }
        return res;

    }


}