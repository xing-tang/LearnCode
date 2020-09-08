package com.open.learncode.算法.test.A5_跟数组相关的算法;


/**
 * 题目：
 * 数组中出现次数超过一半的数字：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如，输入长度为9的数组[1,2,3,2,2,2,5,4,2]，数字2在数组中出现5次，超过数组的长度的一半，因此输出2.
 * <p>
 * 解题思路：
 * 摩尔投票法：
 * ①票数和： 由于众数出现的次数超过数组长度的一半；若记众数的票数为 +1 ，非众数 的票数为 −1 ，则一定有所有数字的票数和 >0 。
 * ②票数正负抵消： 设数组 nums 中的众数为 x ，数组长度为 n 。若 nums 的前 a 个数字的 票数和 =0 ，
 * 则数组后 (n−a) 个数字的 票数和一定仍 >0 （即后 (n−a) 个数字的 众数仍为 x ）。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */

public class TestMethod39 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println("出现次数超过数组长度一半的数字为：" + method(nums));
    }

    /**
     * 输出出现次数超过数组长度一半的数字
     *
     * @param nums 待输入的数组
     * @return 返回出现次数超过数组长度一半的数字
     */
    private static int method(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;

        // x：众数 votes：统计票数
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        int count = 0;
        // 验证 x 是否为众数
        for (int num : nums) if (num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }
}
