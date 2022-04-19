package com.open.learncode.算法.java.剑指offer.A11_补充;


import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 调整数组顺序使负数位于正数前面：有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，
 * 且保证相对位置不变，要求空间复杂度为O(1)。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n^2)，最差的情况（一半负数在前，一半正数在后），每次都需要移动 n/2 个元素，则一共需要 n^2/4。
 * 空间复杂度：O(1)。
 */
public class OT01_调整数组顺序使负数位于正数前面 {

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {5, 2, -1, 0, -9, 21, -4};
        PrintUtils.getInstance().printArray(solution(nums));
    }

    private static int[] solution(int[] nums) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(1)
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] < 0) {
                // 先将 array[j] 赋值
                int temp = nums[j];
                // 将 【i, j-1】数组后移动
                for (int k = j - 1; k >= i; --k) {
                    nums[k + 1] = nums[k];
                }
                // 将array[j]插入到 i++ 的位置
                nums[i++] = temp;
            }
        }
        return nums;
    }
}
