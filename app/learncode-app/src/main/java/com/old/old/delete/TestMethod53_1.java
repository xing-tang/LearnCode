package com.old.old.delete;

/**
 * 题目：
 * 数字在排序数组中出现的次数：统计一个数字在排序数组中出现的次数。
 * 例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3，3在数组中出现了4次，因此输出4
 * <p>
 * 解题思路：
 * 二分法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn) 空间复杂度：O(1)
 */

public class TestMethod53_1 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 3, 3, 3, 4, 5};
        int target = 3;
        System.out.println("数字" + target + "在排序数组中出现的次数为：" + method_1(nums, target));
        System.out.println("数字" + target + "在排序数组中出现的次数为：" + method_2(nums, target));
    }

    private static int method_1(int[] nums, int target) {

        // 搜索右边界right：
        //初始化：
        int i = 0, j = nums.length - 1;
        //循环二分：
        while (i <= j) {
            int m = (i + j) / 2;
            //nums[m] <= target：代表右边界在[m+1,right]中
            if (nums[m] <= target) i = m + 1;
            else j = m - 1; //nums[m] > target：代表右边界在[i,m-1]中
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索左边界left：
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            //nums[m] < target：代表左边界在[m+1,right]中
            if (nums[m] < target) i = m + 1;
            else j = m - 1;//nums[m] >= target：代表右边界在[i,m-1]中
        }
        int left = j;

        return right - left - 1;
    }

    /**
     * 以上代码显得比较臃肿（两轮二分查找代码冗余）
     * 为简化代码，可将二分查找右边界 right 的代码 封装至函数 helper() 。
     *
     * @param nums
     * @param target
     * @return
     */
    private static int method_2(int[] nums, int target) {
        //helper(nums, target)：找到的是target的右边界
        //helper(nums, target - 1)：找到的是target-1的右边界，即第一个大于target-1的数（target）
        return helper(nums, target) - helper(nums, target - 1);
    }

    /**
     * helper() 函数旨在查找数字 target 在数组 nums 中的插入点，
     * 且若数组中存在值相同的元素，则插入到这些元素的右边。
     *
     * @param nums
     * @param tar
     * @return
     */
    private static int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}