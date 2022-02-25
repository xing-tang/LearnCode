package com.open.learncode.算法.old.剑指offer.A1_排序查找算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 快速排序
 * <p>
 * 解题思路：
 * 快速排序
 * <p>
 * 复杂度分析：
 * 时间复杂度：最好O(nlogn)，最差O(n^2)，空间复杂度：O(nlogn)
 */
public class ST04_快速排序 {

    public static void main(String[] args) {
//        int[] arr = {};
//        int[] arr = null;
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        method(arr, 0, arr.length - 1);
        PrintUtils.getInstance().printArray(arr);
    }

    private static void method(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 0 || left > right) return;
        int i = left;
        int j = right;
        int base = arr[left];
        while (i < j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        method(arr, left, j - 1);
        method(arr, j + 1, right);
    }
}
