package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <p>
 * 解题思路：
 * 从后往前替代+双指针
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ05_2_合并两个排序数组 {

    public static void main(String[] args) {
        int[] A1 = new int[7];
        for (int i = 0; i < 4; i++)
            A1[i] = i + 1; // [1, 2, 3, 4, 0, 0, 0]
        int A1Size = 4;
        int[] A2 = {0, 7, 8};
        PrintUtils.getInstance().printArray(method(A1, A1Size, A2, A2.length));
//        PrintUtils.getInstance().printArray(method2(A1, A1Size, A2, A2.length));
    }

    /**
     * 从后往前替代+双指针
     * 时间复杂度 O(m+n)
     */
    public static int[] method(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length <= 0) return nums2;
        if (nums2 == null || nums2.length <= 0) return nums1;
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[index--] = nums1[i];
            i--;
        }
        while (j >= 0) {
            nums1[index--] = nums2[j];
            j--;
        }
        return nums1;
    }

    /**
     * 从后往前替代+双指针
     * 时间复杂度 O(m+n)
     */
    public static int[] method2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length <= 0) return nums2;
        if (nums2 == null || nums2.length <= 0) return nums1;
        int i = m - 1, j = n - 1, index = m + n - 1, cur;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                cur = nums2[j--];
            } else if (j == -1) {
                cur = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                cur = nums1[i--];
            } else {
                cur = nums2[j--];
            }
            nums1[index--] = cur;
        }
        return nums1;
    }
}

