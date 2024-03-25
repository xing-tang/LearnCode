package com.old.old.wcopy.leetcode_剑指offer.A5_跟数组相关的算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。
 * 请实现一个函数，把A2中所有数字插入A1中，并且所有的数字都是排序的。
 * 例如：输入A1=>{1, 2, 3, 4}，B=>{2, 4, 6}，输出A1=>{1, 2, 2, 3, 4, 4, 6}。
 * <p>
 * 解题思路：
 * 从后往前替代+双指针
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ05_2_合并两个排序数组 {

    public static void main(String[] args) {
        int[] A = new int[7];
        for (int i = 0; i < 4; i++)
            A[i] = i + 1;
        int m = 4;
        int[] B = {2, 4, 6};
        PrintUtils.getInstance().printArray(method(A, m, B, 3));
    }

    /**
     * 从后往前替代+双指针
     *
     * @param A     输入的数组A
     * @param m     A数组的真实长度
     * @param B     输入的数组B
     * @return 返回合并后的数组A
     */
    public static int[] method(int[] A, int m, int[] B, int n) {
        if (A == null || A.length <= 0) return B;
        if (B == null || B.length <= 0) return A;
        if (A.length < (m + n)) return null;
        int aIndex = m - 1;
        int bIndex = B.length - 1;
        int len = aIndex + bIndex + 1;
        while (aIndex >= 0 && bIndex >= 0) {
            A[len--] = A[aIndex] > B[bIndex] ? A[aIndex--] : B[bIndex--];
        }
        return A;
    }
}

