package com.old.old.wcopy.每日回顾.day_01;

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
public class TestMethod3_2 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
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
        if (arr == null || arr.length <= 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] >= arr.length) {
                return -1;
            }
        }

        int start = 1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= start && arr[i] <= mid) {
                    count++;
                }
            }
            if (start == end) {
                if (count > 0) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
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
            if (arr[i] < 1 || arr[i] >= arr.length) {
                return -1;
            }
        }

        int a = arr[0];
        int b = arr[0];
        while (true) {
            a = arr[arr[a]];
            b = arr[b];
            if (a == b) break;
        }
        a = arr[0];
        while (a != b) {
            a = arr[a];
            b = arr[b];
        }
        return a;
    }
}

