package com.open.learncode.算法.java.剑指offer.A6_回溯;


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
public class JZ13_机器人运动范围 {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        System.out.println(movingCount(18, m, n));
    }

    /**
     * 返回矩阵中机器人可以到达的格子数
     *
     * @param threshold 阈值
     * @param rows      矩阵行数
     * @param columns   矩阵列数
     * @return
     */
    private static int movingCount(int threshold, int rows, int columns) {
        if (threshold < 0 || rows <= 0 || columns <= 0) return 0;
        boolean visited[][] = new boolean[rows][columns];
        int count = movingCountCore(threshold, rows, columns, 0, 0, visited);
        return count;
    }

    /**
     * 返回当前格子所能延展的可以到达的格子数
     *
     * @param threshold 阈值
     * @param rows 矩阵的行号
     * @param columns 矩阵的列号
     * @param row 矩阵的当前行号
     * @param column 矩阵的当前列号
     * @param visited 标记格子的访问情况
     * @return
     */
    private static int movingCountCore(int threshold, int rows, int columns, int row, int column, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, columns, row, column, visited)) {
            visited[row][column] = true;
            count = 1 + movingCountCore(threshold, rows, columns, row - 1, column, visited)
                    + movingCountCore(threshold, rows, columns, row + 1, column, visited)
                    + movingCountCore(threshold, rows, columns, row, column - 1, visited)
                    + movingCountCore(threshold, rows, columns, row, column + 1, visited);
        }
        return count;
    }

    /**
     * 判断机器人能否进入坐标为（row，column）的方格
     *
     * @param threshold 阈值
     * @param rows 矩阵的行号
     * @param columns 矩阵的列号
     * @param row 矩阵的当前行号
     * @param column 矩阵的当前列号
     * @param visited 标记格子的访问情况
     * @return
     */
    private static boolean check(int threshold, int rows, int columns, int row, int column, boolean[][] visited) {
        if (row >= 0 && row < rows && column >= 0 && column < columns
                && getDigitSum(row) + getDigitSum(column) <= threshold && !visited[row][column]) {
            System.out.println("check:" + "行号：" + row + "\t列号：" + column);
            return true;
        }
        return false;
    }

    /**
     * @param number 输入具体的数字
     * @return 返回数字num的位数之和
     */
    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;//余数
            number /= 10;//除数
        }
        return sum;
    }

}