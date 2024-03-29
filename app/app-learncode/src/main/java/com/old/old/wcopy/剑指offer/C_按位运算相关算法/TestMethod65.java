package com.old.old.wcopy.剑指offer.C_按位运算相关算法;

/**
 * 题目：
 * 不用加减乘除做加法：写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 解题思路：
 * 通过位运算符
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)【最差情况下（例如a=0x7fffffff，b=1时），需循环31次，使用O(1)时间；每轮中的常数次位操作使用O(1)时间】
 * 空间复杂度：O(1)
 */
public class TestMethod65 {

    public static void main(String[] args) {
        System.out.println("17+5=" + method(17, 5));
        System.out.println("-6+3=" + method(-6, 3));
    }

    /**
     * 位算法符方法：数字a + 数字b = 无进位和a + 进位b = 和s
     *
     * @param a 待输入的整数
     * @param b 待输入的整数
     * @return 输出两数之和
     */
    public static int method(int a, int b) {
        // 当进位b=0时跳出，此时，和为a
        while (b != 0) {
            int c = (a & b) << 1;  // c = 进位
            //^：按位异或，不同为1, 相同为0.
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

}
