package com.open.learncode.算法.java.剑指offer.A11_补充;

import com.open.learncode.算法.base.PrintUtils;

/**
 * OT_04_二分查找算法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)。
 * 空间复杂度：O(1)。
 */
public class OT04_二分查找算法 {

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {1, 3, 5, 7, 9};
        int target = 3;
        PrintUtils.getInstance().print(method(nums, target), "查找结果：");
    }

    private static int method(int[] nums, int target) {
        // 时间复杂度：O(logn)
        // 空间复杂度：O(1)
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
