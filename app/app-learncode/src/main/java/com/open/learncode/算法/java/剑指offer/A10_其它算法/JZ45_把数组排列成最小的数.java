package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 注意：
 * 0 < nums.length <= 100。
 * <p>
 * 示例：
 * 示例1：输入: [10,2]，输出: "102"。
 * 示例2：输入: [3,30,34,5,9]，输出: "3033459"。
 * <p>
 * 解题思路：
 * 快排思想，两个数字"相加"对比大小，若x+y>y+x，则x大于y；若x+y<y+x，则x小于y
 * <p>
 * 复杂度分析：
 * 时间复杂度：平均O(nlogn)，最好O(nlogn)，最差O(n^2)。
 * 空间复杂度：O(n)。
 */
public class JZ45_把数组排列成最小的数 {

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {3, 30, 34, 5, 9};
        PrintUtils.getInstance().print(solution(nums));
    }

    

    private static String solution(int[] nums) {
        if (nums == null || nums.length <= 0) return "";
        if (nums.length == 1) String.valueOf(nums[0]);

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        solution(strs, 0, strs.length - 1);
        StringBuilder strb = new StringBuilder();
        for (String str : strs) strb.append(str);
        return strb.toString();
    }

    private static void solution(String[] strs, int left, int right) {
        if (left >= right) return;

        int start = left, end = right;
        String temp = strs[left];
        while (start < end) {
            while (start < end && (strs[end] + strs[left]).compareTo(strs[left] + strs[end]) >= 0)
                end--;
            while (start < end && (strs[start] + strs[left]).compareTo(strs[left] + strs[start]) <= 0)
                start++;
            temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;
        }
        strs[start] = strs[left];
        strs[left] = temp;
        solution(strs, left, end - 1);
        solution(strs, end + 1, right);
    }
}
