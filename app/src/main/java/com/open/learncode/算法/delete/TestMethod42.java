package com.open.learncode.算法.delete;

/**
 * 题目：
 * 输入一个整型数组，数组里面有正数也有负数。数组里面的一个或者连续多个整数组成一个子数组。
 * 求所以子数组和的最大值。要求时间复杂度为O(n)。
 * 例如：数组{1,-2,3,10,-4,7,2,-5}
 * <p>
 * 解题思路：
 * 数组找规律、动态规划
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod42 {

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(method_1(nums));
    }

    /**
     * 数组找规律，不用更改原数组
     *
     * @param nums 传入的数组
     * @return 返回子数组和的最大值
     */
    public static int method_1(int[] nums) {
        int maxSum = 0;
        int curSum = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 当sum小于0时，就从下一个数重新开始
            // 同时更新每次叠加的最大值
            if (curSum <= 0) {
                curSum = nums[i];
            } else {// 和大于0时
                curSum += nums[i];
            }

            // 不断更新子串的最大值
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    /**
     * 动态规划，需要更改原数组
     *
     * @param nums 传入的数组
     * @return 返回子数组和的最大值
     */
    public static int method(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }


}
