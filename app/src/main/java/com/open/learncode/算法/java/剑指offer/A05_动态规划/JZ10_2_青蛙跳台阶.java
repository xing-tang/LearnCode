package com.open.learncode.算法.java.剑指offer.A05_动态规划;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 青蛙🐸跳台阶问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上有个n级的台阶总共有多少种跳法
 * <p>
 * 注意：
 * 0 <= n <= 30。
 * <p>
 * 示例：
 * 示例1：输入：n = 0，输出：0。
 * 示例2：输入：n = 1，输出：1。
 * 示例3：输入：n = 2，输出：2。
 * 示例4：输入：n = 3，输出：3。
 * 示例5：输入：n = 4，输出：5。
 * 示例6：输入：n = 5，输出：8。
 * <p>
 * 解题思路：
 * 当n=1，只有一种跳法；
 * 当n=2，有两种跳法：一次跳2级；分两次跳，一次跳一级；
 * 当n>2，第一次跳有两种不同的跳法：
 * 第一次只跳1级，此时，跳法数目=剩下的n-1级台阶的跳法数目，为f(n-1)。
 * 第一次跳2级，此时，跳法数目=剩下的n-2级台阶的跳法数目，为f(n-2)。
 * 因此，n级台阶的不同跳法的总数f(n)=f(n-1)+f(n-2)。
 * 实际上，这就是斐波那契数列。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)，
 */
public class JZ10_2_青蛙跳台阶 {

    public static void main(String[] args) {
        // 测试用例
        for (int i = 0; i <= 30; i++) {
            PrintUtils.getInstance().print(solution(i), "输入" + i + "，输出");
        }
    }

    private static long solution(int n) {
        if (n < 0) return -1;
        if (n <= 1) return n;

        int pre2 = 0, pre1 = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            curr = pre2 + pre1;
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}

