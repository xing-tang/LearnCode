package com.open.learncode.剑指offer.排序算法.T4_快速排序;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        method(arr, 0, arr.length - 1,4);
        System.out.println();
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) return;
        // 左边哨兵的索引
        int i = left;
        // 右边哨兵的索引
        int j = right;
        // temp就是基准位,以最左边为基准位
        int base = arr[left];
        while (i < j) {
            // 先看右边，依次往左递减
            while (base <= arr[j] && i < j) {
                j--;
            }
            while (base >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                // 左右哨兵 交换数据（互相持有对方的数据）
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = base;
        //递归调用左半数组
        quickSort(arr, left, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, right);
    }

    public static void method(int[] arr, int left, int right,int k) {
        if (left > right) return;
        // 左边哨兵的索引
        int i = left;
        // 右边哨兵的索引
        int j = right;
        // temp就是基准位,以最左边为基准位
        int base = arr[left];
        while (i < j) {
            // 先看右边，依次往左递减
            while (base <= arr[j] && i < j) {
                j--;
            }
            while (base >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                // 左右哨兵 交换数据（互相持有对方的数据）
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = base;
        if (k == j) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < j) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            //递归调用左半数组
            method(arr, left, j - 1,k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            //递归调用右半数组
            method(arr, j + 1, right,k);
        }
    }
    int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};

}
