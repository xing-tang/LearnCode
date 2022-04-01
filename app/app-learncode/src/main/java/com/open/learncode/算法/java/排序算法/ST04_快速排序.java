package com.open.learncode.算法.java.排序算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 快速排序
 * <p>
 * 解题思路：
 * 快速排序
 * <p>
 * 复杂度分析：
 * 时间复杂度：最好O(nlogn)，最差O(n^2)。
 * 空间复杂度：O(logn)。
 */
public class ST04_快速排序 {

    public static void main(String[] args) {
        // 测试用例
        // int[] arr = {};
        // int[] arr = null;
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        solution(arr, 0, arr.length - 1);
        PrintUtils.getInstance().printArray(arr);
    }

    private static void solution(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 0 || left > right) return;

        int start = left;
        int end = right;
        int base = nums[left];
        while (start < end) {
            while (nums[end] >= base && start < end) {
                end--;
            }
            while (nums[start] <= base && start < end) {
                start++;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        nums[left] = nums[start];
        nums[start] = base;
        solution(nums, left, end - 1);
        solution(nums, end + 1, right);
    }
}
