package com.open.learncode.剑指offer;

import java.util.Arrays;

/**
 * 题目：
 * 最小的K个数：输入n个整数，找出其中最小的K个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
 * <p>
 * 解题思路：
 *
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */

public class TestMethod40 {

    public static void main(String[] args) {

        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};


        int k = 3;
        int[] res = method_1(nums, k);
        System.out.print("最小的" + k + "个数字为：");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();


    }

    /**
     * 快速排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] method_1(int[] nums, int k) {

        //鲁棒性
        if (nums == null || nums.length <= 0 || k <= 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(nums, 0, nums.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回 j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }


}