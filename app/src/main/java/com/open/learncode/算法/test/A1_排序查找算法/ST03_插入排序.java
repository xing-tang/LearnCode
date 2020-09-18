package com.open.learncode.算法.test.A1_排序查找算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 插入排序
 * <p>
 * 解题思路：
 * 插入排序
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n^2)，空间复杂度：O(1)
 */
public class ST03_插入排序 {

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 7, 0};
        PrintUtils.getInstance().printIntArray(arr);
        insertSort(arr);
        PrintUtils.getInstance().printIntArray(arr);
    }

    /**
     * 插入排序数组
     *
     * @param arr 待输入的数组
     */
    private static int[] insertSort(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        // 假设第一个数位置时正确的；要往后移，必须要假设第一个。
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            // 待插入的
            int temp = arr[i];
            // 后移
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 插入
            arr[j] = temp;
        }
        return arr;
    }
}
