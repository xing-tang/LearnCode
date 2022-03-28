package com.open.learncode.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Lte_1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 6, 3};
        int target = 9;
        twoSum_1(nums, target);
        twoSum_2(nums, target);
        twoSum_3(nums, target);

    }

    /**
     * 方法一：暴力法
     *
     * @param nums   整型数组
     * @param target 目标值
     * @return 存储两个下标的整型数组
     */
    private static int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    System.out.println("new int[]{" + i + "," + j + "}");
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法二：两遍哈希表
     *
     * @param nums   整型数组
     * @param target 目标值
     * @return 存储两个下标的整型数组
     */
    private static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println("new int[]{" + i + "," + map.get(complement) + "}");
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：一遍哈希表
     *
     * @param nums   整型数组
     * @param target 目标值
     * @return 存储两个下标的整型数组
     */
    private static int[] twoSum_3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println("new int[]{" + map.get(complement) + "," + i + "}");
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


