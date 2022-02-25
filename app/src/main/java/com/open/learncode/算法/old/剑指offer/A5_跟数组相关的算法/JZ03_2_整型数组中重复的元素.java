package com.open.learncode.算法.old.剑指offer.A5_跟数组相关的算法;

import java.util.PriorityQueue;

/**
 * 题目：
 * 在一个长度为n的数组里的所有数字都在1到n-1的范围内。所以数组中至少有一个数字是重复。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如：如果输入长度为7的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 * <p>
 * 解题思路:
 * 二分法查找法
 * 龟兔赛跑算法
 * <p>
 * 复杂度分析:
 * 方法一的时间复杂度：O(nlog(n))，空间复杂度：都为O(1)
 * 方法二的时间复杂度：O(n)，空间复杂度：都为O(1)
 */
public class JZ03_2_整型数组中重复的元素 {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int[] arr = {2, 3, 5, 4, 3, 6, 6, 7};
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(queue.poll());
        }


        System.out.println("二分法打印重复的数字=>" + method1(arr));
        System.out.println("龟兔赛跑算法打印重复的数字=>" + method2(arr));
    }

    /**
     * 二分法
     *
     * @param arr 待查找是否存在重复的数组
     * @return 返回数组中重复的数字，如果不存在重复返回-1
     */
    public static int method1(int[] arr) {
        // robust
        if (arr == null || arr.length <= 0)
            return -1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 1 || arr[i] > arr.length - 1)
                return -1;

        int start = 1;
        int end = arr.length - 1;
        while (start <= end) {
            // (start + end) / 2可能会溢出，因为两个很大的int相加的话超出 Integer.MAX_VALUE 了
            // int mid = (start + end) / 2;
            // int mid = (start + end) >> 1;
            int mid = ((end - start) >> 1) + start;
            // 对范围内的元素个数进行计数
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= start && arr[i] <= mid)
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

    /**
     * 龟兔赛跑算法
     *
     * @param arr 待查找是否存在重复的数组
     * @return 返回数组中重复的数字，如果不存在重复返回-1
     */
    public static int method2(int[] arr) {
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

        a2 = arr[0];
        while (a2 != a1) {
            a2 = arr[a2];
            a1 = arr[a1];
        }
        return a2;
    }
}

