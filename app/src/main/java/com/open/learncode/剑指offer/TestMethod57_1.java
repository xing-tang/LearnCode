package com.open.learncode.剑指offer;

/**
 * 题目：
 * 和为s的两个数：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 例如，输入数组{1,2,4,7,11,15}和数字15，由于4+11=15，因此输出4和11。
 * <p>
 * 解题思路：
 * 双指针方法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod57_1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 11, 15};
        int sum = 15;
        int[] temp = method(nums, sum);
        System.out.println(temp[0] + " " + temp[1]);
    }

    /**
     * 双指针方法
     *
     * @param nums   待输入的数组
     * @param target 待输入的两数之和
     * @return 返回对应两个数的数组
     */
    public static int[] method(int[] nums, int target) {
        if (nums == null || nums.length < 2) return nums;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp > target) {
                right--;
            } else if (temp < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }

}
