package com.open.learncode.算法.java.剑指offer.A3_数组;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 注意：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 * <p>
 * 示例：
 * 示例1：输入：nums = [3,4,3,3]，输出：4
 * 示例2：输入：nums = [9,1,7,9,7,9,7]，输出：1
 * <p>
 * 解题思路：
 * 利用找规律，动态规划，按位与、按位异或、位移操作符
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)。
 * 空间复杂度：O(n)。
 */
public class JZ56_2_数组中数字出现的次数 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution(new int[]{3, 4, 3, 3}), "输出");
        PrintUtils.getInstance().print(solution(new int[]{9, 1, 7, 9, 7, 9, 7}), "输出");
    }

    private static int solution(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}

