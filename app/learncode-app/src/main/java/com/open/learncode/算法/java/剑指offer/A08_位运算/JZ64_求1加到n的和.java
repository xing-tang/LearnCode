package com.open.learncode.算法.java.剑指offer.A08_位运算;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 求1+2+...+n：求1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 * <p>
 * 注意：
 * 1 <= n <= 10000。
 * <p>
 * 示例：
 * 示例1：输入: n = 3，输出: 6。
 * 示例2：输入: n = 5，输出: 15。
 * <p>
 * 解题思路：
 * 递归+通过逻辑运算的短路操作来进行，&&当前者不成立时后者区域不会执行。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(n)，递归会占用系统额外空间。
 */
public class JZ64_求1加到n的和 {

    public static void main(String[] args) {
        // 测试用例
        for (int i = 0; i < 10; i++) {
            PrintUtils.getInstance().print(solution(i), "输入" + i + "，输出");
        }
    }

    private static int solution(int n) {
        // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归，">1"条件不重要随便写
        boolean x = n > 1 && (n += solution(n - 1)) > 1;
        return n;
    }
}
