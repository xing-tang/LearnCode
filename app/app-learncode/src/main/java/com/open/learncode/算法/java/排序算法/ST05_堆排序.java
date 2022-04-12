package com.open.learncode.算法.java.排序算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 堆排序
 * 示例：测试b、d、e，分别对应三种情况
 * ******大根堆
 * *******9
 * ***** / \
 * *****6   8
 * *** /\  / \
 * ***5 3 4  7
 * * / \
 * *2  1
 * 其对应的映射数组：{9,6,8,5,3,4,7,2,1}
 * <p>
 * 解题思路:
 * 堆是一颗完全二叉树，可分为大根堆和小根堆；
 * 每个结点的值都大于其左孩子和右孩子结点的值，称之为大根堆；
 * 每个结点的值都小于其左孩子和右孩子结点的值，称之为小根堆；
 * 父结点索引：(i-1)/2，左孩子索引：2*i+1，右孩子索引：2*i+2
 * 大根堆：arr(i)>arr(2*i+1) && arr(i)>arr(2*i+2)
 * 小根堆：arr(i)<arr(2*i+1) && arr(i)<arr(2*i+2)
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(nlogn)。
 * 空间复杂度：O(1)。
 */
public class ST05_堆排序 {
    public static void main(String[] args) {
        // 测试用例
        int[] nums1 = {4, 7, 2, 1, 3, 5, 8, 9, 6};
        int[] nums2 = {4, 7, 2, 1, 3, 5, 8, 9, 6};
        solutionMax(nums1);
        PrintUtils.getInstance().printArray(nums1);
        solutionMin(nums2);
        PrintUtils.getInstance().printArray(nums2);
    }

    private static void solutionMax(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // 1. 从最后一个非叶节点开始构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeap(nums, i, nums.length);
        }
        // 2. 从最小的叶子节点开始与根节点进行交换并重新构建大顶堆
        for (int j = nums.length - 1; j >= 0; j--) {
            swap(nums, 0, j);
            maxHeap(nums, 0, j);
        }
    }

    // 大根堆
    public static void maxHeap(int[] nums, int i, int length) {
        // 先取出当前元素i
        int temp = nums[i];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && nums[k] < nums[k + 1]) k++;
            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (temp >= nums[k]) break;
            nums[i] = nums[k];
            nums[k] = temp;
            i = k;
        }
    }

    public static void solutionMin(int[] nums) {
        if (nums == null || nums.length == 0) return;

        for (int i = nums.length / 2; i >= 0; i--) {
            minHeap(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            minHeap(nums, 0, i - 1);
        }
    }

    // 小跟堆
    public static void minHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k <= length; k = k * 2) {
            if (k < length && nums[k] > nums[k + 1]) k++;
            if (temp <= nums[k]) break;
            nums[i] = nums[k];
            nums[k] = temp;
            i = k;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
