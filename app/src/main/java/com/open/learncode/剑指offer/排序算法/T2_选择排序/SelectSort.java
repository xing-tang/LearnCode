package com.open.learncode.剑指offer.排序算法.T2_选择排序;

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
        int[] arr = {6, 4, 5, 7, 0};
        selectSort(arr);
        System.out.println();
    }

    private static int[] selectSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
