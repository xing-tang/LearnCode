package com.old.old.剑指offer.A4_跟数相关的算法;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 求斐波那契数列的第n项：写入一个函数，输入n，求斐波那契数列的第n项。斐波那契数列的定义如下：
 * f(n)=0               n=0
 * f(n)=1               n=1
 * f(n)=f(n-1)+f(n-2)   n>1
 * <p>
 * 注意：
 * 0 <= n <= 30。
 * <p>
 * 示例：
 * 示例1：输入：n = 2，输出：1。
 * 示例2：输入：n = 5，输出：5。
 * <p>
 * 解题思路：
 * 递归：需要重复计算的节点数太多
 * 循环：从下往上计算，避免重复计算
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ10_1_斐波那契数列 {

    public static void main(String[] args) {
        // 测试用例
        for (int i = 0; i <= 30; i++) {
            PrintUtils.getInstance().print(solution(i), "输入" + i + "，输出");
        }
    }

    private static int solution(int n) {
        if (n < 0) return -1;
        if (n <= 1) return n;

        int pre2 = 0;
        int pre1 = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr = pre1 + pre2;
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}

