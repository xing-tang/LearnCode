package com.old.old.wcopy.排序算法.T4_快速排序;

/**
 * 题目：
 * 快速排序
 * <p>
 * 解题思路：
 * 快速排序
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(nlogn)，空间复杂度：O(nlogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        print(arr);
        method(arr, 0, arr.length - 1);
        print(arr);
    }

    /**
     * 快速排序数组
     *
     * @param arr   待输入的数组
     * @param left  左边索引
     * @param right 右边索引
     */
    public static void method(int[] arr, int left, int right) {
        if (left > right) return;
        // 左边哨兵的索引
        int i = left;
        // 右边哨兵的索引
        int j = right;
        // base就是基准位,以最左边为基准位
        int base = arr[left];
        while (i < j) {
            // 先看右边，依次往左递减
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                // 左右哨兵 交换数据（互相持有对方的数据）
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = base;
        // 递归调用左半数组
        method(arr, left, j - 1);
        // 递归调用右半数组
        method(arr, j + 1, right);
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

    /**
     * 打印数组
     *
     * @param arr 待输入的数组
     */
    private static void print(int[] arr) {
        if (arr == null || arr.length <= 0) return;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("{" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                System.out.println(arr[i] + "}");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}
