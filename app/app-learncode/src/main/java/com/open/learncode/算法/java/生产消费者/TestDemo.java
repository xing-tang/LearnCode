package com.open.learncode.算法.java.生产消费者;

import com.open.learncode.算法.base.PrintUtils;

/**
 * TestDemo
 *
 * @Description: xxx
 * @Author: xing.tang
 */
public class TestDemo {

    public static void main(String[] args) {
        int[][] arr = solution(4, -3);
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
            for (int i = left; i <= right; i++) {
                arr[top][i] = index++;
            }
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = index++;
            }
            if (left > --right) break;
            for (int i = right; i >= left; i--) {
                arr[bottom][i] = index++;
            }
            if (top > --bottom) break;
            for (int i = bottom; i >= top; i--) {
                arr[i][left] = index++;
            }
            if (++left > right) break;
        }
        return arr;
    }
}
