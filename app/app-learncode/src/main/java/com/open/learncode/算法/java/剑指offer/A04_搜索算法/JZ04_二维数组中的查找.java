package com.open.learncode.算法.java.剑指offer.A04_搜索算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 注意：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * <p>
 * 示例：
 * 示例1：输入：{{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}}，给定 target = 5，返回 true。
 * 示例1：输入：{{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}}，给定 target = 0，返回 false。
 * 解题思路：
 * 二维数组在内存空间占用连续的空间，且从左至右从上至下按递增排序。
 * 二维数组的右上角、二维数组的左下角。
 * <p>
 * 方法一复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 * <p>
 * 方法二复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ04_二维数组中的查找 {

    public static void main(String[] args) {
        // 测试用例
        int[][] nums = {{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}};
        PrintUtils.getInstance().print(solution1(nums, 13), "输出");
        PrintUtils.getInstance().print(solution1(nums, 0), "输出");
    }

    private static boolean solution1(int[][] nums, int target) {
        if (nums == null || nums.length <= 0) return false;
        if (nums[0] == null || nums[0].length <= 0) return false;

        int x = 0;
        int y = nums[0].length - 1;
        while (x < nums.length && y >= 0) {
            if (target > nums[x][y]) {
                x++;
            } else if (target < nums[x][y]) {
                y--;
            } else {
                return true;
            }
        }
        return false;
    }
}