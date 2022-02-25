package com.old.old.剑指offer.A5_跟数组相关的算法;

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
 * 时间复杂度：O(logn)，空间复杂度：O(1)，最差时间复杂度：即为顺序查找时，需遍历数据下标i-j的元素，时间复杂度为O(n)
 */
public class JZ11_旋转数组的最小数字 {

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

    public static int method(int[] nums) {
        // 鲁棒性
        if (nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
//        // 针对的是把数组最开始的0个元素搬到数组的末尾这种特殊情况，此时数组不变，最小元素就是数组的第一个元素
//        if (nums[left] < nums[right]) return nums[left];
        // 一般情况：数组是无序的，旋转数组分成两部分A B，都是递增的，数组的最小元素就是B中的第一个元素
        while (left < right) {
            // left右移，right左移，当left一直处于A中时，left指向的值一直大于或等于right指向的值，
            // 若left指向的值小于了right指向的值，则代表left已经到了B中，且指向的一定是B中的第一个元素，即最小元素
            // 原因：
            // left右移只有两种：
            // 1、nums[mid]=nums[right] left=left+1]; left右移一个，此时，若满足条件，一定是B中第一个元素
            // 2、nums[mid]>nums[right] left=mid+1; mid还处于A中，left=mid+1满足条件，一定是B中第一个元素
            if (nums[left] < nums[right])
                return nums[left];
            // 二分查找，不断缩小left right指针的范围
            int mid = (left + right) >> 1;
            // 若mid指向的值大于right指向的值，意昧着：mid仍然处于A中
            if (nums[mid] > nums[right])
                left = mid + 1;
                // 若mid指向的值小于right指向的值，意昧着：mid已经处于B中，但不确定是否指向的是B中的第一个元素
            else if (nums[mid] < nums[right])
                right = mid;
                // 若mid指向的值等于right指向的值，right往左移一下或者left往右移一下，意义相同，都是为了：在二分没办法实现的情况下进一步缩小范围
//            else right = right - 1;
            else left = left + 1;
        }
        // 当left=right时，while循环结束，且left right指向的都是B中的第一个元素
        return nums[left];
    }
}

