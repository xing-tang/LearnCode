package com.open.learncode.算法.排序算法.T1_冒泡排序;

/**
 * 题目：
 * 冒泡排序
 * <p>
 * 解题思路:
 * 依次比较两个相邻的元素，如果顺序（如从小到大、从大到小、首字母从A到Z），不对就把他们两两交换过来
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(n^2)，空间复杂度：都为O(1)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 7, 0};
        print(arr);
        bubbleSort(arr);
        print(arr);
    }

    /**
     * 冒泡排序
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
