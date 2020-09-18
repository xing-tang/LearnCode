package com.open.learncode.算法.test.A5_跟数组相关的算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。
 * 请实现一个函数，把A2中所有数字插入A1中，并且所有的数字都是排序的。
 * 例如：输入A1=>{1, 2, 3, 4}，A2=>{2, 4, 6}，输出A1=>{1, 2, 2, 3, 4, 4, 6}。
 * <p>
 * 解题思路：
 * 从后往前替代+双指针
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ05_2_合并两个排序数组 {

    public static void main(String[] args) {
        int[] A1 = new int[7];
        for (int i = 0; i < 4; i++)
            A1[i] = i + 1;
        int A1Size = 4;
        int[] A2 = {2, 4, 6};
        PrintUtils.getInstance().printIntArray(method(A1, A1Size, A2));
    }

    /**
     * 从后往前替代+双指针
     *
     * @param A1     输入的数组A1
     * @param A1Size A1数组的真实长度
     * @param A2     输入的数组A2
     * @return 返回合并后的数组A1
     */
    public static int[] method(int[] A1, int A1Size, int[] A2) {
        if (A1 == null || A1.length <= 0) return A2;
        if (A2 == null || A2.length <= 0) return A1;
        if (A1.length < (A1Size + A2.length)) return null;
        int a1Index = A1Size - 1;
        int a2Index = A2.length - 1;
        int len = a1Index + a2Index + 1;
        while (a1Index >= 0 && a2Index >= 0) {
            A1[len--] = A1[a1Index] > A2[a2Index] ? A1[a1Index--] : A2[a2Index--];
        }
        return A1;
    }
}

