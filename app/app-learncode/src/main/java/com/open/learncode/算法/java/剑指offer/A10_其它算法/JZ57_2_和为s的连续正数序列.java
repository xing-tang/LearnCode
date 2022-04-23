package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 注意：
 * 1 <= target <= 10^5
 * 0属于整数，不属于正整数
 * <p>
 * 示例：
 * 示例1：输入：target = 1 || 2，输出：[[]]
 * 示例1：输入：target = 9，输出：[[2,3,4],[4,5]]
 * 示例2：输入：target = 15，输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 解题思路：
 * 1, 2, 3, 4, 5, 6, 7, 8, 9
 * 滑动窗口，双指针，且 5 = (9 + 1) / 2，即start值最多为4，end值最多为5，
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(num)【num指传入的数字】。
 * 空间复杂度：O(1)。
 */
public class JZ57_2_和为s的连续正数序列 {

    public static void main(String[] args) {
        PrintUtils.getInstance().printArray(solution(3), "输出");
        PrintUtils.getInstance().printArray(solution(9), "输出");
        PrintUtils.getInstance().printArray(solution(15), "输出");
    }

    private static int[][] solution(int target) {
        if (target <= 2) return new int[0][0];

        List<int[]> res = new ArrayList<>();
        int start = 1, end = 2, sum = start + end;
        int middle = (target + 1) / 2;
        // while (start < middle) {
        while (start < end) {
            if (sum == target) {
                int[] temp = new int[end - start + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = i + start;
                }
                res.add(temp);
            }
            if (sum >= target) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        return res.toArray(new int[0][]);
    }
}
