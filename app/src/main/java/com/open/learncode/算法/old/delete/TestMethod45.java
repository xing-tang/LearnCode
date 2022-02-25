package com.open.learncode.算法.old.delete;

/**
 * 题目：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如，输入数组{3,32,321}，则打印出这三个数字能排列成最小的数字为321323。
 * <p>
 * 解题思路：
 * 快排思想，两个数字"相加"对比大小，若x+y>y+x，则x大于y；若x+y<y+x，则x小于y
 * <p>
 * 复杂度分析：
 * 时间复杂度：平均时间复杂度O(nlogn)【最好O(nlogn)，最差O(n^2)】，空间复杂度：O(n)
 */
public class TestMethod45 {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 9, 5};
        method(nums);
    }

    /**
     * 使用快速排序
     *
     * @param nums
     * @return
     */
    public static String method(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        method(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    /**
     * 快速排序：修改排序判断规则
     *
     * @param strs
     * @param l
     * @param r
     */
    public static void method(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        method(strs, l, i - 1);
        method(strs, i + 1, r);
    }


}
