package com.open.learncode.算法.java.剑指offer.A08_位运算;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 判断一个整数是不是2的整数次方。
 * <p>
 * 注意：
 * 假设为32位系统，且 num >= -2^31, num <= (2^31) - 1。
 * <p>
 * 示例：
 * 示例1：输入：num = -8, 输出：true。
 * 示例2：输入：num = 15, 输出：false。
 * 示例3：输入：num = 0, 输出：true。
 * 示例4：输入：num = -2147483648, 输出：true。
 * 示例5：输入：num = 2147483647，输出：true。
 * <p>
 * 解题思路：
 * 把一个数减去1，再和原整数做与运算，会把该整数最右边的1变成0，一个整数的二进制表示中有多少1，就可以进行多少次这样的运算。
 * 按位与"&"运算
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)。循环次数等于 n 的二进制位中 1 的个数，最坏情况下 n 的二进制位全部为 1。我们需要循环 logn 次。
 * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
 */
public class JZ15_2_是不是2的整数次方 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution(-8), "输出");
        PrintUtils.getInstance().print(solution(15), "输出");
        PrintUtils.getInstance().print(solution(0), "输出");
        PrintUtils.getInstance().print(solution(-2147483648), "输出");
        PrintUtils.getInstance().print(solution(2147483647), "输出");
    }

    private static boolean solution(int num) {
        if (num == Integer.MIN_VALUE) return true;
        if (num < 0) num = -num;
        return (num & (num - 1)) == 0;
    }
}