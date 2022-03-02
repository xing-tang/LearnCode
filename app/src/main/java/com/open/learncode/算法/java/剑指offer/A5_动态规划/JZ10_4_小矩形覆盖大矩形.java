package com.open.learncode.算法.java.剑指offer.A5_动态规划;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 我们可以用2x1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用8个2x1的小矩形无重叠地覆盖一个2x8的大矩形，总共有多少种方法？
 * ロ  ロロロロロロロロ
 * ロ  ロロロロロロロロ
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
 * 当n=1，只有一种排列方式
 * 当n=2，有两种跳法
 * 当n=3，有三种跳法
 * 当n=4，有五种跳法
 * 因此，因此可得还是一个斐波那契数列。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ10_4_小矩形覆盖大矩形 {

    public static void main(String[] args) {
        // 测试用例
        for (int i = 0; i < 30; i++) {
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

