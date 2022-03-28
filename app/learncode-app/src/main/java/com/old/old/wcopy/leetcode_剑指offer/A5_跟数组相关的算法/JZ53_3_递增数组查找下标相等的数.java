package com.old.old.wcopy.leetcode_剑指offer.A5_跟数组相关的算法;

/**
 * 题目：
 * 假设一个单调递增的数组里面的每个元素都是整数并且唯一。请编程实现一个函数，
 * 找出数组中任意一个数值等于其下标的元素。例如，在数组{-3,-1,1,3,5}中，
 * 数字3和它的下标相等。
 * <p>
 * 解题思路：
 * 二分法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)，空间复杂度：O(1)
 */
public class JZ53_3_递增数组查找下标相等的数 {

    public static void main(String[] args) {
        int[] nums = {-3, -1, 1, 3, 5};
        System.out.println(method(nums));
    }

    /**
     * 二分法
     *
     * @param nums 待传入的数组
     * @return 返回数值和下标相等的元素，如若不存在返回-1
     */
    public static int method(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == middle) {
                return middle;
            } else if (nums[middle] > middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
