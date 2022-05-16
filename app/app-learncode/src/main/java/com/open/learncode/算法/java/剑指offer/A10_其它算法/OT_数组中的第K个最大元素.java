package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 注意：
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * <p>
 * 示例：
 * 示例1：输入：输入: [3,2,1,5,6,4] 和 k = 2，输出：5。
 * 示例2：输入：输入: [3,2,3,1,2,4,5,5,6] 和 k = 4，输出：4。
 * <p>
 * 解题思路：
 * 快排、堆排序
 * <p>
 * 快速排序复杂度分析：
 * 时间复杂度：最好O(nlogn)，最差O(n^2)。
 * 空间复杂度：O(logn)。
 * 堆排序复杂度分析：
 * 时间复杂度：O(nlogn)。
 * 空间复杂度：O(1)。
 */
public class OT_数组中的第K个最大元素 {

    public static void main(String[] args) {
        // 测试用例
        // 快速排序
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        solution1(nums1, 0, nums1.length - 1, nums1.length - k1);
        PrintUtils.getInstance().printArray(nums1);
        // 堆排序
        int[] nums2 = {3, 2, 3, 1, 2, 5, 4, 5, 6};
        int k2 = 4;
        solution2(nums2);
        PrintUtils.getInstance().print(nums2[nums2.length - k2]);
    }

    private static void solution1(int[] nums, int left, int right, int k) {
        if (nums == null || nums.length <= 0 || left > right) return;

        int start = left;
        int end = right;
        int base = nums[left];
        while (start < end) {
            while (start < end && nums[end] >= base) end--;
            while (start < end && nums[start] <= base) start++;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        nums[left] = nums[start];
        nums[start] = base;
        if (start < k) {
            solution1(nums, start + 1, right, k);
        }
        else if (start > k) {
            solution1(nums, left, start - 1, k);
        }
    }

    private static void solution2(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeap(nums, i, nums.length);
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            swap(nums, 0, j);
            maxHeap(nums, 0, j);
        }
    }

    private static void maxHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
