package com.open.learncode.算法.java.剑指offer.A2_数;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 不用加减乘除做加法：写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 注意：
 * a, b 均可能是负数或 0，结果不会溢出 32 位整数。
 * <p>
 * 示例：
 * 示例1：输入: a = 3, b = 5，输出: 8。
 * 示例2：输入: a = -6, b = 3，输出: -3。
 * <p>
 * 解题思路：
 * 通过按位与 "&" 和按位异或 "^" 运算符。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)【最差情况下（例如a=0x7fffffff，b=1时），需循环31次，使用O(1)时间；每轮中的常数次位操作使用O(1)时间】。
 * 空间复杂度：O(1)。
 */
public class JZ65_不用加减乘除做加法 {

    public static void main(String[] args) {
        // 测试提包费库
        PrintUtils.getInstance().print(solution(3, 5), "3+5");
        PrintUtils.getInstance().print(solution(-6, 3), "-6+3");
    }

    private static int solution(int a, int b) {
        while (b != 0) { // 当进位b=0时跳出，此时，和为a
            int c = (a & b) << 1;  // c = 进位
            //^：按位异或，不同为1, 相同为0.
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
