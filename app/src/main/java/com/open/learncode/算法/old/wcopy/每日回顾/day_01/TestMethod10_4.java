package com.open.learncode.算法.old.wcopy.每日回顾.day_01;

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
 * f(0)=0,f(1)=1,f(2)=2,f(3)=3,f(4)=5,f(5)=8,f(6)=13
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(2^n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod10_4 {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println("f(" + i + ")=" + method(i));
        }
    }

    private static int method(int n) {
        if (n < 0) return -1;
        if (n <= 3) return n;

        int curr = 0;
        int pre2 = 2;
        int pre1 = 3;
        for (int i = 4; i <= n; i++) {
            curr = pre1 + pre2;
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}

