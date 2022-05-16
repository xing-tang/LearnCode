package com.open.learncode.算法.java.剑指offer.A10_其它算法;

/**
 * 题目：
 * 调整数组顺序使奇数位于偶数前面：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。不保证相对顺序
 * <p>
 * 解题思路：
 * 快速排序
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ21_调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        print(nums);
        method_1(nums);
//        method_2(nums);
        print(nums);
    }

    /**
     * 首尾双指针：
     * left一直往右移，直到指向的值为偶数；right一直往左移，直到指向的值为奇数
     * 交换nums[left] nums[right]，直到left==right
     *
     * @param data 待调整的数组
     */
    private static void method_1(int[] nums) {
        if (nums == null && nums.length <= 0) return;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 向后移动left，直到它指向偶数，然后停下来
            while (left < right && (nums[left] & 1) == 1)
                left++;
            // 向前移动right，直到它指向奇数，然后停下来
            while (left < right && (nums[right] & 1) == 0)
                right--;
            // left指向偶数，right指向奇数，且left<right，交换两者位置
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    /**
     * 快慢指针：
     * fast在前，low在后，fast向前搜索奇数的位置，low指向下一个奇数应当存放的位置
     * 交换nums[low] nums[fast]，low向前移动一个位置，直到fast指向数组末尾
     *
     * @param nums 待调整的数组
     */
    private static void method_2(int[] nums) {
        if (nums == null && nums.length <= 0) return;

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            // 如果nums[fast]为奇数
            if ((nums[fast] & 1) == 1) {
                // 交换fast slow位置的元素，slow右移一位
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
    }

    /**
     * 打印一维数组
     *
     * @param data 待打印的一维数组
     */
    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}