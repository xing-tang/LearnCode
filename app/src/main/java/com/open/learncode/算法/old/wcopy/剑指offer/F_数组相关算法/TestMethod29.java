package com.open.learncode.算法.old.wcopy.剑指offer.F_数组相关算法;

/**
 * 题目：
 * 顺时针打印矩阵：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 例如：如果输入矩阵
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 * 则依次打印出数字：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(m*n)【m n分别为矩阵的行和列数，需遍历到矩阵中的每一个元素】，空间复杂度：O(m*n)
 */
public class TestMethod29 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] temp = method(matrix);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    /**
     * 顺时针打印矩阵
     *
     * @param matrix 输入的二维数组
     * @return 返回输出的一维数组
     */
    public static int[] method(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        int index = 0;
        // 存储打印结果的一维数组
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            // left to right.
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) break;
            // top to bottom.
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (left > --right) break;
            // right to left.
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (top > --bottom) break;
            // bottom to top.
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return res;
    }
}

