package com.open.learncode.算法.old.wcopy.leetcode_快手;

import com.open.learncode.算法.base.PrintUtils;

public class KS8_快排 {

    public static void main(String[] args) {
        int[] num = {3, 2, 1, 7, 6, 4};
        method(num, 0, num.length - 1);

        PrintUtils.getInstance().printArray(num);
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
