package com.open.learncode.算法.java.剑指offer.A07_排序;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * <p>
 * 注意：
 * 2 <= n <= 100000
 * <p>
 * 示例：
 * 示例1：输入：{2, 3, 1, 0, 2, 5, 3}，输出：2 或 3。
 * <p>
 * 解题思路:
 * 一维数组在内存空间占用连续的空间，因此可以根据下标定位对应的元素，然后两两交换。
 * <p>
 * 复杂度分析:
 * 时间复杂度 O(N) ： 遍历数组使用 O(N) ，每轮遍历的判断和交换操作使用 O(1) 。
 * 空间复杂度 O(1) ： 使用常数复杂度的额外空间。
 */
public class JZ03_1_整型数组中重复的元素 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution(new int[]{2, 3, 1, 0, 2, 5, 3}), "输出");
         PrintUtils.getInstance().print(solution(new int[]{3, 4, 2, 0, 0, 1}), "输出");
    }

    private static int solution(int[] nums) {
        if (nums == null || nums.length < 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) return nums[i];
                // 交换
                // swap(nums, i, nums[i]);
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

