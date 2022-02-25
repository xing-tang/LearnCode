package com.open.learncode.算法.java.剑指offer.A2_数;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2的31次方, 2的31次方 − 1]。本题中，如果除法结果溢出，则返回 2的31次方 − 1。
 * -2的31次方 <= a, b <= 2的31次方 - 1，b != 0
 * <p>
 * 示例：
 * 示例1：输入：a = 15, b = 2, 输出：7，15/2 = solution(7.5) = 7
 * 示例2：输入：a = 7, b = -3，输出：-2，7/-3 = solution(-2.33333..) = -2
 * 示例3：输入：a = 0, b = 1，输出：0，0/1 = 0
 * 示例4：输入：a = 1, b = 0，输出：-2147483648，-2147483648/1 = -2147483648
 * 示例5：输入：a = -2147483648, b = -1，输出：-2147483647，-2147483648/-1 = 2147483647
 * 示例6：输入：a = -2147483648, b = 1，输出：-2147483648，-2147483648/1 = -2147483648
 * <p>
 * 解题思路：
 * 利用按位异或、位移操作符，注意正负数、0、数越界，Math.abs(-2147483648)=-2147483648
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)。
 * 空间复杂度：O(1)。
 */
public class JZ01_整数除法 {

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

