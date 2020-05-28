package com.open.learncode.剑指offer.每日回顾.day_01;


/**
 * 题目：
 * 机器人的运动范围：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，
 * 他每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的位数之和大于k的格子。
 * 例如，当k=18时，机器人能进入方格（35，37），因为3+5+3+7=18。
 * 但他不能进入方格（35，38），因为3+5+3+8=19.请问该机器人能够达到多少格子
 * <p>
 * 解题思路：
 * 与12题类似。回溯法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n^2)   空间复杂度：O(n^2)
 */
public class TestMethod13 {

    public static void main(String[] args) {

        int m = 4;
        int n = 3;
        int threshold[][] = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                threshold[i][j] = k++;
            }
        }
        System.out.println();

    }


}