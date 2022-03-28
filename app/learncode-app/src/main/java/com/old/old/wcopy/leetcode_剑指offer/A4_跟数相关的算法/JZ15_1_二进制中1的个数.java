package com.old.old.wcopy.leetcode_剑指offer.A4_跟数相关的算法;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 二进制中1的个数：请实现一个函数，输入一个整数，输入该数二进制表示中1的个数。
 * 例如，把9表示成二进制是1001，有2位是1。因此，如果输入9，则该函数输出2
 * <p>
 * 解题思路：
 * 位与"&"运算
 * <p>
 * 复杂度分析：
 * n为数值的二进制表示的位数
 * 方法一：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ15_1_二进制中1的个数 {

    public static void main(String[] args) {
        PrintUtils.getInstance().print(method(3));
    }

    /**
     * 惊喜解法：把一个数减去1，再和原整数做与运算，会把该整数最右边的1变成0
     * 一个整数的二进制表示中有多少1，就可以进行多少次这样的运算
     *
     * @param n 输入一个整数
     * @return 返回二进制中1的个数
     */
    private static int method(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}