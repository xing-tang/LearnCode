package com.old.old.剑指offer.A9_二叉树相关算法;

import java.util.Stack;

/**
 * 题目：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 例如二叉树如下：
 * * *****8
 * * *** / \
 * * ***6  10
 * * * / \ / \
 * * *5  7 9  11
 * 则对应输入的数组为：{5,7,6,9,11,10,8}。
 * 如果输入的数组是{7,4,6,5}，则由于没有哪课二叉搜索树的后续比那里结果是这个序列，
 * 因此返回false
 * <p>
 * 解题思路：
 * 递归、辅助栈
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n^2)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ33_数组是否是某二叉搜索树的后续遍历序列 {

    public static void main(String[] args) {
        int[] arr1 = {5, 7, 6, 9, 11, 10, 8};
        int[] arr2 = {7, 4, 6, 5};
//        System.out.println(method_1(arr1, 0, arr1.length - 1));
        System.out.println(method_2(arr1));
    }

    /**
     * 递归分治
     *
     * @param arr 输入的二叉搜索树数组
     * @return 返回是否是二叉搜索树的后序遍历
     */
    public static boolean method_1(int[] arr, int star, int end) {
        if (star >= end) return true;
        int right = star;
        while (arr[right] < arr[end]) right++;
        int left = right;
        while (arr[right] > arr[end]) right++;
        return right == end && method_1(arr, star, left - 1) && method_1(arr, left, end - 1);
    }

    /**
     * 辅助单调栈
     *
     * @param arr 输入的二叉搜索树数组
     * @return 返回是否是二叉搜索树的后序遍历
     */
    public static boolean method_2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > arr[i])
                root = stack.pop();
            stack.add(arr[i]);
        }
        return true;
    }
}
