package com.open.learncode.算法.java.剑指offer.A2_数;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 判断两个整数 m 和 n，计算 m 的二进制中的需要改变多少位才能得到 n。
 * <p>
 * 注意：
 * 假设为32位系统，且 m 或者 n >= -2^31,  m 或者 n <= (2^31) - 1。
 * <p>
 * 示例：
 * 示例1：输入：m = -2147483648，n = 2147483647，输出：32。
 * 示例2：输入：m = 3，n = 15，输出：2。
 * 示例3：输入：m = 3，n = -15，输出：29。
 * 示例4：输入：m = -3，n = 15，输出：29。
 * 示例5：输入：m = -3，n = -15，输出：2。
 * <p>
 * 解题思路：
 * 利用按位异或 "^" 运算、按位与 "&" 运算。
 * <p>
 * 复杂度分析：
 * n为数值的二进制表示的位数
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ15_3_m的二进制改变多少位得到n {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution(-2147483648, 2147483647), "-2147483648的二进制中改变多少位才能得到2147483647");
        PrintUtils.getInstance().print(solution(3, 15), "3的二进制中改变多少位才能得到15");
        PrintUtils.getInstance().print(solution(3, -15), "3的二进制中改变多少位才能得到-15");
        PrintUtils.getInstance().print(solution(-3, 15), "-3的二进制中改变多少位才能得到15");
        PrintUtils.getInstance().print(solution(-3, -15), "-3的二进制中改变多少位才能得到-15");
    }

    private static int solution(int m, int n) {
        int temp = m ^ n;
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp & (temp - 1);
        }
        return count;
    }
}