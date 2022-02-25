package com.open.learncode.算法.old.wcopy.剑指offer.C_按位运算相关算法;


/**
 * 题目：
 * 判断两个整数m和n，计算m的二进制中的需要改变多少位才能得到n。
 * <p>
 * 解题思路：
 * 利用按位异或"^"运算和按位与"&"运算
 * <p>
 * 复杂度分析：
 * n为数值的二进制表示的位数
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod15_3 {

    public static void main(String[] args) {
        System.out.println("3的二进制中改变多少位才能得到15=>" + method(3, 15));
        System.out.println("-3的二进制中改变多少位才能得到-15=>" + method(-3, -15));
    }

    /**
     * 计算需要改变m的二进制中的多少位才能得到n
     *
     * @param m 输入的整数m
     * @param n 输入的整数n
     * @return 返回将会修改的二进制位数
     */
    private static int method(int m, int n) {
        int temp = m ^ n;
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp & (temp - 1);
        }
        return count;
    }
}