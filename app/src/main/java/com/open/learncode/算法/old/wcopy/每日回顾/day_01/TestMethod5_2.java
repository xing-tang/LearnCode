package com.open.learncode.算法.old.wcopy.每日回顾.day_01;

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
public class TestMethod5_2 {

    public static void main(String[] args) {
        int[] A1 = new int[7];
        A1[0] = 1;
        A1[1] = 2;
        A1[2] = 3;
        A1[3] = 4;
        int A1Length = 4;
        int[] A2 = {2, 4, 6};

        int[] temp = method(A1, A2, A1Length);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    private static int[] method(int[] A1, int[] A2, int size) {
        if (A1 == null || A1.length <= 0) return A2;
        if (A2 == null || A2.length <= 0) return A1;
        if (A1.length < (A2.length + size)) return null;

        int a1Index = size - 1;
        int a2Index = A2.length - 1;
        int a1NewIndex = a1Index + a2Index + 1;
        while (a1Index >= 0 && a2Index >= 0) {
            if (A1[a1Index] >= A2[a2Index]) {
                A1[a1NewIndex--] = A1[a1Index--];
            } else {
                A1[a1NewIndex--] = A2[a2Index--];
            }
        }
        return A1;
    }

}

