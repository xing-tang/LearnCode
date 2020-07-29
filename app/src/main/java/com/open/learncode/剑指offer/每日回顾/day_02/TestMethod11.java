package com.open.learncode.剑指offer.每日回顾.day_02;

/**
 * 题目：
 * 旋转数组的最小数字：把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * <p>
 * 解题思路：
 * 注意数组中可能存在重复的元素，二分查找法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)，空间复杂度：O(1)
 * 最差时间复杂度：即为顺序查找时，需遍历数据下标i-j的元素，时间复杂度为O(n)
 */
public class TestMethod11 {

    public static void main(String[] args) {
//        int nums[] = {1, 1, 1, 0, 1};
//        int nums[] = {1,0,1,1,1};
//        int nums[]={3,4,5,1,2};
//        int nums[] = {1, 2, 3, 4, 5};
//        int nums[]={3,4,5,1,2,3};
        int nums[] = {1, 1, 0, 1, 1, 1, 1, 1};
//        int nums[]={1};
//        int nums[] = {};

        System.out.println("最小元素为：" + method(nums));
    }

    private static int method(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[left];
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            int mid = left + ((right - left) >> 1);
            if (nums[mid]>nums[right]){
                left = mid+1;
            }else if (nums[mid]<nums[right]){
                right = mid;
            }else{
                left = left+1;
            }
        }
        return nums[left];
    }

}

