package com.open.learncode.算法.java.剑指offer.A2_数;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 注意：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 示例：
 * 示例1：输入: a = "11", b = "10"，输出: "101"
 * 示例2：输入: a = "1010", b = "1011"，输出: "10101"
 * <p>
 * 解题思路：
 * 利用按位异或、位移操作符，注意正负数、0、数越界，Math.abs(-2147483648)=-2147483648
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)。
 * 空间复杂度：O(1)。
 */
public class JZ02_二进制加法_todo {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution(15, 2), "商为");
        PrintUtils.getInstance().print(solution(7, -3), "商为");
        PrintUtils.getInstance().print(solution(0, 1), "商为");
        PrintUtils.getInstance().print(solution(1, 0), "商为");
        PrintUtils.getInstance().print(solution(-2147483648, -1), "商为");
        PrintUtils.getInstance().print(solution(-2147483648, 1), "商为");
    }

    private static int solution(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        if (a == Integer.MIN_VALUE && b == 1) return Integer.MIN_VALUE;
        if (b == 0) return Integer.MIN_VALUE;

        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        int res = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) {
                a -= b << i;
                // if (res > Integer.MAX_VALUE - (1 << i)) {
                //   return Integer.MIN_VALUE;
                // }
                res += 1 << i;
            }
        }
        return sign == 1 ? res : -res;
    }
}

