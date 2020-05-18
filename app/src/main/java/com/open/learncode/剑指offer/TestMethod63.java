package com.open.learncode.剑指offer;

/**
 * 题目：
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能收货最大的利润为11。
 * <p>
 * 解题思路：
 * 动态规划
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod63 {

    public static void main(String[] args) {
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println("最大利润为：" + method(nums));
    }

    /**
     * 动态规划
     *
     * @param nums 待输入的数组
     * @return 返回最大利润值
     */
    public static int method(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num - min);
        }
        return max;
    }
}
