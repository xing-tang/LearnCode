package com.open.learncode.java.let;


/**
 * 136.只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Lte_136 {

    public static void main(String[] args) {
        Lte_136 lte = new Lte_136();
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        System.out.println("singleNumber="+lte.singleNumber(nums2));
    }

    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
