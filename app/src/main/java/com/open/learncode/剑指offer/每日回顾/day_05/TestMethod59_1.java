package com.open.learncode.剑指offer.每日回顾.day_05;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里面的最大值。
 * 例如，如果输出数组{2,3,4,2,6,2,5,1}及滑动窗口大小3，那么一共存在6个滑动窗口，
 * 它们的最大值分别为{4,4,6,6,6,5}。
 * <p>
 * 解题思路：
 * 双端队列
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)【其中n为数组长度】，空间复杂度：O(k)【双端队列deque中最多同时存储k个元素（即窗口大小）】
 */
public class TestMethod59_1 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        int k = 3;
        int[] temp = method(nums, k);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    /**
     * 双端队列
     *
     * @param nums 待传入的数组
     * @param k    窗口大小
     * @return 返回滑动窗口的最大值数组
     */
    public static int[] method(int[] nums, int k) {
        // 鲁棒性
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<Integer>();
        // 什么最大值一维数组
        int[] res = new int[nums.length - k + 1];
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                // 删除 deque 中对应的 nums[i-1]
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                // 保持 deque 递减
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0) {
                // 记录窗口最大值
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

}
