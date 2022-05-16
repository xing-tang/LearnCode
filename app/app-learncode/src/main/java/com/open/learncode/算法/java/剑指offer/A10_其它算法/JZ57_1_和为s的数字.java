package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 和为s的两个数：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 例如，输入数组{1,2,4,7,11,15}和数字15，由于4+11=15，因此输出4和11。
 * <p>
 * 示例：
 * 示例1：输入：numbers = [1,2,4,6,10], target = 8，输出：[1,3]
 * <p>
 * 解题思路：
 * 双指针方法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，其中 n 是数组的长度。两个指针移动的总次数最多为 n 次。
 * 空间复杂度：O(1)。
 * 力扣：https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
 */
public class JZ57_1_和为s的数字 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().printArray(solution(new int[]{1, 2, 4, 6, 10}, 8), "输出");
    }

    private static int[] solution(int[] nums, int target) {
        if (nums == null || nums.length < 2) return nums;

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) j--;
            else if (sum < target) i++;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
}
