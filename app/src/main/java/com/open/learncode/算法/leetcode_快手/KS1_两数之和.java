package com.open.learncode.算法.leetcode_快手;

import com.open.learncode.算法.base.PrintUtils;

import java.util.HashMap;

/**
 * 题目：
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 示例：
 * 给定 nums = {2, 7, 11, 15}, target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 解题思路：
 * 利用HashMap的key不可重复
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class KS1_两数之和 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        PrintUtils.getInstance().printIntArray(nums);
        PrintUtils.getInstance().printIntArray(method(nums, 17));
    }


    private static int[] method(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return null;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
