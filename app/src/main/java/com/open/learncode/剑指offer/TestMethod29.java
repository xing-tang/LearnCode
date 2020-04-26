package com.open.learncode.剑指offer;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod29 {

    public static void main(String[] args) {

        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("顺时针打印矩阵：");
        printMatrixInCircle(matrix, matrix.length, matrix[0].length, 0);
    }


    private static void printMatrixInCircle(int[][] matrix, int rows, int columns, int start) {

        if (matrix == null || rows <= 0 || columns <= 0)
            return;

        while (columns > start * 2 && rows > start * 2) {
            //列
            int endX = columns - 1 - start;
            //行
            int endY = rows - 1 - start;

            //从左到右打印一行
            for (int i = start; i <= endX; i++) {
                int num = matrix[start][i];
                System.out.print(num + " ");

            }

            //从上到下打印一列
            if (start < endY) {
                for (int i = start + 1; i <= endY; i++) {
                    int num = matrix[i][endX];
                    System.out.print(num + " ");

                }
            }

            //从右往左打印一行
            if (start < endX && start < endY) {
                for (int i = endX - 1; i >= start; i--) {
                    int num = matrix[endY][i];
                    System.out.print(num + " ");

                }
            }

            //从下到上打印一列
            if (start < endX && start < endY - 1) {
                for (int i = endY - 1; i >= start + 1; i--) {
                    int num = matrix[i][start];
                    System.out.print(num + " ");
                }
            }

           start++;
        }
    }


}

