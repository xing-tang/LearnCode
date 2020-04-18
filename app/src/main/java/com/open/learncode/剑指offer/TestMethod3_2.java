package com.open.learncode.剑指offer;

/**
 * 题目：
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内。所以数组中至少有一个数字是重复。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如：如果输入长度为7的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 * <p>
 * 解题思路:
 * 二分法查找法
 * 龟兔赛跑算法
 * <p>
 * 复杂度分析:
 * 方法一的时间复杂度：O(n)，空间复杂度：都为O(1)
 * 方法二的时间复杂度：O(nlongn)，空间复杂度：都为O(1)
 */
public class TestMethod3_2 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 2, 5, 3};
        System.out.println("龟兔赛跑算法打印重复的数字=>" + method1(arr));
        System.out.println("二分法打印重复的数字=>" + method2(arr));
    }

    /**
     * 龟兔赛跑算法
     *
     * @param arr 待查找是否存在重复的数组
     * @return 返回数组中重复的数字，如果不存在重复返回-1
     */
    public static int method1(int[] arr) {
        if (arr == null || arr.length <= 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > arr.length - 1) return -1;
        }

        int a1 = arr[0];
        int a2 = arr[0];

        while (true) {
            a1 = arr[a1];
            a2 = arr[arr[a2]];
            if (a1 == a2) break;
        }

        int p1 = arr[0];
        while (p1 != a1) {
            p1 = arr[p1];
            a1 = arr[a1];
        }
        return p1;
    }

    /**
     * 二分法
     *
     * @param arr 待查找是否存在重复的数组
     * @return 返回数组中重复的数字，如果不存在重复返回-1
     */
    public static int method2(int[] arr) {

        // robust
        if (arr == null || arr.length <= 0)
            return -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 1 || arr[i] > arr.length - 1)
                return -1;

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // int mid = (start + end) / 2;
            int mid = ((end - start) >> 1) + start;

            // 对范围内的元素个数进行计数
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= mid && arr[i] >= start)
                    count++;
            }

            if (start == end) {
                if (count > 1)
                    return start;
                else
                    break;
            }

            // 根据检测情况调整会出现重复的整数范围
            if (count > mid - start + 1)
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }
}

