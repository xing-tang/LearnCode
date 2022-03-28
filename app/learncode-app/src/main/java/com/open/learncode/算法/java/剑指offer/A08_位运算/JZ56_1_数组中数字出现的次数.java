package com.open.learncode.算法.java.剑指offer.A08_位运算;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 注意：
 * 2 <= nums.length <= 10000
 * <p>
 * 示例：
 * 示例1：输入：nums = [4,1,4,6]，输出：[1,6] 或 [6,1]
 * 示例2：输入：nums = [1,2,10,4,1,4,3,3]，输出：[2,10] 或 [10,2]
 * <p>
 * 解题思路：
 * 利用找规律，动态规划，按位与、按位异或、位移操作符
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)。
 * 空间复杂度：O(n)。
 */
public class JZ56_1_数组中数字出现的次数 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().printArray(solution(new int[]{4, 1, 4, 6}), "输出");
        PrintUtils.getInstance().printArray(solution(new int[]{1, 2, 10, 4, 1, 4, 3, 3}), "输出");
    }

    private static int[] solution(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int div = 1;
        while ((div & res) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}

