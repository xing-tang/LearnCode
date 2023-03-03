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
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
 */
public class OT_数组中的第K个最大元素 {

    public static void main(String[] args) {
        // 测试用例
        // 快速排序
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        solution1(nums1, 0, nums1.length - 1, nums1.length - k1);
        PrintUtils.getInstance().printArray(nums1);
        PrintUtils.getInstance().print(nums1[nums1.length - k1]);
        // 堆排序
        int[] nums2 = {3, 2, 3, 1, 2, 5, 4, 5, 6};
        int k2 = 4;
        solution2(nums2, k2);
        PrintUtils.getInstance().printArray(nums2);
        PrintUtils.getInstance().print(nums2[0]);
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
        } else if (start > k) {
            solution1(nums, left, start - 1, k);
        }
    }

    private static void solution2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
    }

    /**
     * 构造最大堆
     */
    private static void buildMaxHeap(int[] a, int heapSize) {
        // 从第一个非叶子节点为根节点的子树开始
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    /**
     * 调整最大堆
2     */
    private static void maxHeapify(int[] a, int i, int heapSize) {
        // l：节点 i 的左孩子，r：节点 i 的右孩子
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        // 两个 if 判断 父亲节点、左孩子、右孩子 之间的最大值
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        // 如果节点 i 对应的不是最大值
        if (largest != i) {
            // 交换值
            swap(a, i, largest);
            // 调整以 largest 的值为根节点的子树的堆
            maxHeapify(a, largest, heapSize);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
