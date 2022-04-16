package com.open.learncode.算法.java.剑指offer.A08_位运算;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 二进制中1的个数：请实现一个函数，输入一个整数，输入该数二进制表示中1的个数。
 * <p>
 * 注意：
 * 假设为32位系统，且 num >= -2^31, num <= (2^31) - 1。
 * <p>
 * 示例：
 * 示例1：输入：num = 15, 输出：4。
 * 示例2：输入：num = -15, 输出：29。
 * 示例3：输入：num = 0, 输出：0。
 * 示例4：输入：num = -2147483648, 输出：1。
 * 示例5：输入：num = 2147483647，输出：31。
 * <p>
 * 解题思路：
 * 把一个数减去1，再和原整数做与运算，会把该整数最右边的1变成0，一个整数的二进制表示中有多少1，就可以进行多少次这样的运算。
 * 按位与"&"运算
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(log n)。循环次数等于 n 的二进制位中 1 的个数，最坏情况下 n 的二进制位全部为 1。我们需要循环 log n 次。
 * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
 */
public class JZ15_1_二进制中1的个数 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution(15), "输出");
        PrintUtils.getInstance().print(solution(-15), "输出");
        PrintUtils.getInstance().print(solution(0), "输出");
        PrintUtils.getInstance().print(solution(-2147483648), "输出");
        PrintUtils.getInstance().print(solution(2147483647), "输出");
    }

    private static int solution(int num) {
        int count = 0;
        while (num != 0) {
            num = (num - 1) & num;
            count++;
        }
        return count;
    }
}