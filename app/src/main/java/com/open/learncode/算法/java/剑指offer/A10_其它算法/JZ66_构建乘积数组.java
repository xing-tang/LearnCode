package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 构建乘积数组：给定一个数组A[0,1,…,n-1]，请构建一个数组B[0,1,…,n-1]，
 * 其中B中的元素B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-i]。不能使用除法。
 * <p>
 * 解题思路：
 * 对称遍历
 * 通过B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]，
 * 我们发现B[i]就是A[i]左边所有元素的积 乘以 A[i]右边所有元素的积。
 * 假设n=5，则A{1,2,3,4,5}，输出B{120,60,40,30,24}
 * B[0] = A[1]xA[2]xA[3]xA[4] = 2x3x4x5 = 1x120 =  120
 * B[1] = A[0]xA[2]xA[3]xA[4] = 1x3x4x5 = 1x60 = 60
 * B[2] = A[0]xA[1]xA[3]xA[4] = 1x2x4x5 = 2x20 = 40
 * B[3] = A[0]xA[1]xA[2]xA[4] = 1x2x3x5 = 6x5 = 30
 * B[4] = A[0]xA[1]xA[2]xA[3] = 1x2x3x4 = 24x1 = 24
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ66_构建乘积数组 {

    public static void main(String[] args) {
//        int[] nums1 = {0, 1, 2, 3, 4};
//        PrintUtils.getInstance().printIntArray(nums1);
//        PrintUtils.getInstance().printIntArray( method(nums1));
        int[] nums2 = {1, 2, 3, 4, 5};
        PrintUtils.getInstance().printArray(nums2);
        PrintUtils.getInstance().printArray( method(nums2));
    }

    /**
     * 对称遍历
     *
     * @param nums 待输入的数组
     * @return 返回构建的数组
     */
    public static int[] method(int[] nums) {

        //鲁棒性
        if(nums==null || nums.length==0)
            return new int[0];

        int[] numsB = new int[nums.length];

        //下三角
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            numsB[i] = left;
            left  *= nums[i];
        }

        //上三角
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            numsB[i] *= right;
            right *= nums[i];
        }
        return numsB;

    }
}
