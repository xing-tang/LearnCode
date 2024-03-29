package com.old.old.wcopy.leetcode_剑指offer.A1_排序查找算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 冒泡排序
 * <p>
 * 解题思路:
 * 依次比较两个相邻的元素，如果顺序（如从小到大、从大到小、首字母从A到Z）不对就把他们两两交换过来
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(n^2)，空间复杂度：都为O(1)
 */
public class ST01_冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 7, 0};
        PrintUtils.getInstance().printArray(arr);
        bubbleSort(arr);
        PrintUtils.getInstance().printArray(arr);
    }

    /**
     * 冒泡排序
     * 第一轮 [0, end] 相邻的元素两两排序，得到最大的放在 end 位置
     * 第二轮 [0, end-1] 排序，得到次大的放在 end-1 位置
     * ...
     *
     * @param arr 待输入的数组
     * @return 返回排序后的数组
     */
    private static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 0) return arr;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    /**
     * 同上，不过就是两层循环中的条件发生了变化
     */
    private static int[] bubbleSort2(int[] arr) {
        if (arr == null || arr.length <= 0) return arr;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    /**
     * 交互数组中索引角标i和索引角标j对应的元素
     *
     * @param arr 待输入的数组
     * @param i   索引角标i
     * @param j   索引角标j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
