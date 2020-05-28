package com.open.learncode.剑指offer.每日回顾.day_05;

/**
 * 题目：
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 解题思路：
 * 通过位运算符
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)，空间复杂度：O(1)
 */
public class TestMethod65 {

    public static void main(String[] args) {
        System.out.println("17+5=" + method(17, 5));
        System.out.println("-6+3=" + method(-6, 3));
    }

    /**
     * 位算法符方法
     *
     * @param a 待输入的整数
     * @param b 待输入的整数
     * @return 输出两数之和
     */
    public static int method(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
