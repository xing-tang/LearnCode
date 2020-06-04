package com.open.learncode.剑指offer.每日回顾.day_01;

/**
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是重复的数字2或者3。
 * <p>
 * 解题思路:
 * 一维数组在内存空间占用连续的空间，因此可以根据下标定位对应的元素，然后两两交换。
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class TestMethod3_1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("打印重复的数字=>" + method(arr));
    }

    private static int method(int[] arr) {

        if (arr == null || arr.length <= 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) return arr[i];
                swap(arr, i, arr[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

