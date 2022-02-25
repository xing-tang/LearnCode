package com.old.old.剑指offer.A5_跟数组相关的算法;

/**
 * 题目：
 * 股票的最大利润：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收货最大的利润为11。
 * <p>
 * 解题思路：
 * 动态规划
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)【n为prices数组的长度，动态规划需要遍历prices数组】
 * 空间复杂度：O(1)【变量max min使用常数大小的额外空间】
 */
public class JZ63_股票最大的利益 {

    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println("最大利润为：" + method(prices));
    }

    /**
     * 动态规划
     *
     * @param prices 待输入的数组
     * @return 返回最大利润值
     */
    public static int method(int[] prices) {
        //最低价格
        int minPrice = Integer.MAX_VALUE;
        //最大利润
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
