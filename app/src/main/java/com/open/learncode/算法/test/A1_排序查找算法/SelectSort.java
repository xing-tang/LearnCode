package com.open.learncode.算法.test.A1_排序查找算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 选择排序
 * <p>
 * 解题思路:
 * 将指定索引位置的元素与数组其它元素分别对比，从而找出最小或最大元素，然后两两交换位置。
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(n^2)，空间复杂度：都为O(1)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 7, 0};
        PrintUtils.getInstance().printIntArray(arr);
        selectSort(arr);
        PrintUtils.getInstance().printIntArray(arr);
    }

    /**
     * 选择排序
     *
     * @param arr 待输入的数组
     * @return 返回排序后的数组
     */
    private static int[] selectSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
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
