package com.open.learncode.算法.test.A4_跟数相关的算法;

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
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod10_3 {

    public static void main(String[] args) {
        System.out.println(method(3));
    }

    /**
     * 循环，从下往上计算
     *
     * @param n 输入的参数
     * @return 返回第n项的结果值
     */
    private static long method(int n) {
        if (n <= 2) return n;

        int current = 2;

        for (int i = 3; i <= n; i++) {
            current = current * 2;
        }

        return current;
    }
}

