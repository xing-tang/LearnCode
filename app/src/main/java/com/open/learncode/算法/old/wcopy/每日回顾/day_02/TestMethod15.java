package com.open.learncode.算法.old.wcopy.每日回顾.day_02;


/**
 * 题目：
 * 二进制中1的个数：请实现一个函数，输入一个整数，输入该数二进制表示中1的个数。
 * 例如，把9表示成二进制是1001，有2位是1。
 * 因此，如果输入9，则该函数输出2
 * <p>
 * 解题思路：
 * 位与"&"运算
 * <p>
 * 复杂度分析：
 * n为数值的二进制表示的位数
 * 方法一：时间复杂度：O(n)   空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)   空间复杂度：O(1)
 * 方法三：时间复杂度：O(n)   空间复杂度：O(1)
 */
public class TestMethod15 {

    public static void main(String[] args) {
        for (int i = -3; i <= 9; i++) {
            System.out.println(i + "的二进制有" + method(i) + "个1");
        }
    }

    private static int method(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num - 1) & num;
        }
        return count;
    }
}