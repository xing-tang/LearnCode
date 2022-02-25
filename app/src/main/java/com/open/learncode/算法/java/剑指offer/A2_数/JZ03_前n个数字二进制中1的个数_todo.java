package com.open.learncode.算法.java.剑指offer.A2_数;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * 注意：
 * 0 <= n <= 10的5次方
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 示例：
 * 示例1：输入: n = 2，输出: [0,1,1]
 * 示例2：输入: n = 5，输出: [0,1,1,2,1,2]
 * <p>
 * 解题思路：
 * 0 = 0000 => 0
 * 1 = 0001 => 1
 * 2 = 0010 => 1
 * 3 = 0011 => 2
 * 4 = 0100 => 1
 * 5 = 0101 => 2
 * 利用找规律，动态规划，按位与、按位异或、位移操作符
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)。
 * 空间复杂度：O(n)。
 */
public class JZ03_前n个数字二进制中1的个数_todo {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution3(15), "输出");
//        for (int i = 0; i <= 5; i++) {
//            PrintUtils.getInstance().printArray(solution(i), "i=" + i + ",输出");
//        }
//        for (int i = 0; i <= 5; i++) {
//            PrintUtils.getInstance().print(solution2(i), "i=" + i + ",输出");
//        }
    }

    private static int solution3(int n) {
        int count = 0;
        int res = n;
        while (res != 0) {
            if ((res & 1) == 1) {
                count++;
                res = (res ^ 1) >> 1;
            }
        }
        return count;
    }

    private static int[] solution(int n) {
        int[] res = new int[n + 1];
        // int count = 0;
        for (int i = 1; i <= n; i++) {
            // 如果当前num为偶数，则二进制中1的个数为 num >> 1 的二进制中1的个数。
            // 如果当前num为奇数，则二进制中1的个数为前一个数二进制1的个数+1。
            // res[i] = i % 2 == 0 ? res[i >> 1] : res[i - 1] + 1;
            res[i] = res[i >> 1] + (i & 1);
            // count = count + res[i];
        }
        return res;
    }

    private static int solution2(int n) {
        int[] res = new int[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // 如果当前num为偶数，则二进制中1的个数为 num >> 1 的二进制中1的个数。
            // 如果当前num为奇数，则二进制中1的个数为前一个数二进制1的个数+1。
            // res[i] = i % 2 == 0 ? res[i >> 1] : res[i - 1] + 1;
            res[i] = res[i >> 1] + (i & 1);
            count = count + res[i];
        }
        return count;
    }
}

