package com.old.old.wcopy.查找算法.T2_折半查找_二分查找;

/**
 * 题目：
 * 折半/二分查找指定元素，前提条件：有序或其它类似条件。
 * <p>
 * 解题思路:
 * 折半/二分查找，效率高
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(log N)，空间复杂度：都为O(1)
 */
public class SearchMethod {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 3;
        System.out.println("查找结果：" + method(nums, target));
    }

    /**
     * 折半/二分查找指定元素
     *
     * @param nums   待输入的一位数组
     * @param target 待查找的元素
     * @return 返回对应的索引坐标位置，如果不存在则返回-1
     */
    private static int method(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // (start + end) / 2可能会溢出，因为两个很大的int相加的话超出 Integer.MAX_VALUE 了
            // int mid = (start + end) / 2;
            // int mid = (start + end) >> 1;
            int mid = ((end - start) >> 1) + start;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
