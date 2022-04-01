package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 长度最小的子数组：给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 注意：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * 示例：
 * 示例1：输入：target = 7, nums = [2,3,1,2,4,3]，输出：2。
 * 示例2：输入：target = 4, nums = [1,4,4]，输出：1。
 * 示例3：输入：target = 11, nums = [1,1,1,1,1,1,1,1]，输出：0。
 * 示例4：输入：target = 3, nums = [3]，输出：1。
 * <p>
 * 解题思路：
 * 滑动窗口+双指针。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class OT_长度最小的子数组 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution(new int[]{2, 3, 1, 2, 4, 3}, 7));
        PrintUtils.getInstance().print(solution(new int[]{1, 4, 4}, 4));
        PrintUtils.getInstance().print(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11));
        PrintUtils.getInstance().print(solution(new int[]{3}, 3));
    }

    private static int solution(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return 0;

        int start = 0, end = 0;
        int sum = 0;
        int temp = 0;
        while (end < nums.length) {
            sum = sum + nums[end];
            while (sum >= target) {
                temp = end - start + 1;
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return temp;
    }
}
