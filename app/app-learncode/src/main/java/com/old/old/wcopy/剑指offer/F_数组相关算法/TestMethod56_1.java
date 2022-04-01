package com.old.old.wcopy.剑指offer.F_数组相关算法;

/**
 * 题目：
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 例如，输出数组{2,4,3,6,3,2,5,5}，因为4和6在该数组中只出现过一次，因此输出
 * 4和6。
 * <p>
 * 解题思路：
 * 两个相同的数进行异或其结果为0，通过&进行分组
 * <p>
 * 复杂度分析：
 * 时间复杂度 O(n)，空间复杂度 O(1)
 */
public class TestMethod56_1 {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        method(nums);
    }

    /**
     * 利用异或+与
     *
     * @param nums 待输入的数组
     * @return 返回只出现一次的两个数字
     */
    public static int[] method(int[] nums) {
        int ret = 0;
        for (int n : nums)
            ret ^= n;
        int div = 1;
        while ((div & ret) == 0)
            div <<= 1;
        int a = 0, b = 0;
        for (int n : nums)
            if ((div & n) == 0)
                a ^= n;
            else
                b ^= n;

        return new int[]{a, b};
    }

}
