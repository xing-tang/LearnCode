package com.open.learncode.剑指offer.每日回顾.day_01;

/**
 * 题目：
 * 青蛙🐸跳台阶问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶，也可以跳上n级台阶。
 * 求该青蛙跳上有个n级的台阶总共有多少种跳法。
 * <p>
 * 解题思路：
 * 当n=1，只有一种跳法
 * 当n=2，有两种跳法：一次跳2级；分两次跳，一次跳一级
 * 当n=3，有四种跳法：111，21，12，3
 * 当n=4，有八种跳法：1111，211，121，112，22，13，31，4
 * 因此，我们用数学归纳法可以证明，n级台阶的不同跳法的总数f(n)=2的(n-1)次方
 * f(0)=0,f(1)=1,f(2)=2,f(3)=4,f(4)=8,f(5)=16,f(6)=32
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(2^n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod10_3 {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println("f(" + i + ")=" + method(i));
        }
    }

    private static int method(int n) {
        if (n < 0) return -1;
        if (n <= 2) return n;

        int curr = 2;
        for (int i = 3; i <= n; i++) {
            curr = curr << 1;
        }
        return curr;
    }
}

