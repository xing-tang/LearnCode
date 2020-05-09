package com.open.learncode.剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目：
 * 连续子数组的最大和：输入一个整型数组，数组里有正数也有负数。数组中的一个或连续
 * 多个挣数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如，输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，
 * 因此输出为该子数组的和18
 * <p>
 * 解题思路：
 *
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)【for循环】 空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)【for循环】 空间复杂度：O(1)
 */

public class TestMethod42 {

    public static void main(String[] args) {

        int[] arr1 = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] arr2 = {0};
        System.out.println("是否为无效输入：" + invalidInput);
        System.out.println("method_1=> 所有子数组的最大和：" + method_1(arr1));

        System.out.println("method_2=> 所有子数组的最大和：" + method_2(arr1));

    }


    //是否为无效输入的一个标记
    static boolean invalidInput = false;

    /**
     * 分析数组的规律
     * 时间复杂度：O(n)【for循环】 空间复杂度：O(1)
     *
     * @param arr
     * @return
     */
    private static int method_1(int[] arr) {

        if (arr == null || arr.length <= 0) {
            //返回0，如何区分子数组的和的最大值是0，和，无效输入 这两种不同的情况?
            //定义了一个全局变量invalidInput来标记是否输入无效
            invalidInput = true;
            return 0;
        }

        //当前子数组的和
        int curSum = 0;

        //子数组的最大和
        int maxSum = 0x80000000;

        for (int i = 0; i < arr.length; i++) {

            //当前子数组和小于等于0时，重新累加
            if (curSum <= 0)
                curSum = arr[i];
            else
                curSum += arr[i];

            if (curSum > maxSum)
                maxSum = curSum;

        }
        return maxSum;
    }

    /**
     * 动态规划：修改了数组
     * 时间复杂度：O(n)【for循环】 空间复杂度：O(1)
     *
     * @param arr
     * @return
     */
    private static int method_2(int[] arr) {

        if (arr == null || arr.length <= 0)
            return 0;

        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            //如果arr[i-1]大于0，arr[i]+=arr[i-1]；如果arr[i-1]小于0，则arr[i]=arr[i]+0
            arr[i] += Math.max(arr[i - 1], 0);
            //更新最大和的值
            maxSum = Math.max(maxSum, arr[i]);
        }
        return maxSum;

    }
}