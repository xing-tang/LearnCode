package com.old.old.wcopy.leetcode_剑指offer.A5_跟数组相关的算法;

/**
 * 题目：
 * 0~n-1中缺失的数字：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1中。
 * 范围0~n-1内的n个数中有且只有一个数字不在该数组内，请找出这个数字
 * <p>
 * 解题思路：
 * 二分法：
 * 根据题意，数组可以按照以下规则划分为两部分。
 * 左子数组： nums[i] = i
 * 右子数组： nums[i] 不等于 i
 * 缺失的数字等于 “右子数组的首位元素” 对应的索引
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn) 空间复杂度：O(1)
 */

public class JZ53_2_0到n减1中缺失的数字 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println("0~n-1中缺失的数字为：" + method(nums));
    }

    /**
     * 二分法
     *
     * @param nums 待输入的数组
     * @return 返回缺少的数
     */
    public static int method(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            // nums[m] == m：“右子数组的首位元素” 一定在闭区间[m+1,j]
            if (nums[m] == m) {
                i = m + 1;
            } else {
                // nums[m] != m：“左子数组的末位元素” 一定在闭区间[i,m−1] 中
                j = m - 1;
            }
        }
        return i;

    }
}
