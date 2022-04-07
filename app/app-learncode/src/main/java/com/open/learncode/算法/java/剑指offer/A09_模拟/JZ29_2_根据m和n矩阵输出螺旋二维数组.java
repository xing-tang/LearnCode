package com.open.learncode.算法.java.剑指offer.A09_模拟;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 根据m和n矩阵输出螺旋二维数组：输入 m 和 n，螺旋输出一个二维数组。
 * <p>
 * 注意：
 * 0 <= 链表长度 <= 10000。
 * <p>
 * 示例：
 * 示例：输出 m = 4，n = 3，输出矩阵
 * 1  2   3   4
 * 5  6   7   8
 * 9  10  11  12
 * <p>
 * 解题思路：
 * 四个指针
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(m*n)，m n分别为矩阵的行和列数。
 * 空间复杂度：O(m*n)，m n分别为矩阵的行和列数。
 */
public class JZ29_2_根据m和n矩阵输出螺旋二维数组 {

    public static void main(String[] args) {
        int[][] arr = solution(4, 3);
        PrintUtils.getInstance().printArray(arr);
    }

    private static int[][] solution(int m, int n) {
        if (m <= 0 || n <= 0) return null;
        int[][] arr = new int[n][m];
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        int index = 1;
        int maxLength = m * n;
        while (index <= maxLength) {
            // left to right.
            for (int i = left; i <= right; i++) {
                arr[top][i] = index++;
            }
            if (++top > bottom) break;
            // top to bottom.
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = index++;
            }
            if (left > --right) break;
            // right to left.
            for (int i = right; i >= left; i--) {
                arr[bottom][i] = index++;
            }
            if (top > --bottom) break;
            // bottom to top.
            for (int i = bottom; i >= top; i--) {
                arr[i][left] = index++;
            }
            if (++left > right) break;
        }
        return arr;
    }
}

