package com.old.old.wcopy.剑指offer.F_数组相关算法;

/**
 * 题目：
 * 礼物的最大价值：在一个mxn的棋盘的每一格都放有一个礼物，每一个礼物都有一定的价值（价值大于0）。
 * 你可以在棋盘的左上角开始拿格子里的礼物，并每次向左或向下移动一格，直到到达棋盘的右下角。
 * 给定一个棋盘及上面的礼物，请计算你最多能拿到多少价值的礼物？
 * 例如，在下面的棋盘上
 * 1    10  3   8
 * 12   2   9   6
 * 5    7   4   11
 * 3    7   16  5
 * 沿着1 12 5 7 7 16 5，我们能拿到最大价值为53的礼物
 * <p>
 * 解题思路：
 * 动态规划
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(mxn)【M,N分别为矩阵行高、列宽】，空间复杂度：O(1)【原地修改使用常数大小的额外空间】
 */

public class TestMethod47 {

    public static void main(String[] args) {

        //grid：网格
        int grid[][] = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
//        System.out.println(method_1(grid));
        System.out.println(method_2(grid));

    }

    /**
     * 动态规划：
     * 转移方程：f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
     * @param grid
     * @return
     */
    private static int method_1(int[][] grid) {
        //m n为棋盘的行和列
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    continue;
                if(i == 0)
                    grid[i][j] += grid[i][j - 1] ;
                else if(j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        //返回grad矩阵右下角元素
        return grid[m - 1][n - 1];
    }

    /**
     * 当 gridgrid 矩阵很大时，i=0 或 j=0 的情况仅占极少数，相当循环每轮都冗余了一次判断。
     * 因此，可先初始化矩阵第一行和第一列，再开始遍历递推
     * @param grid
     * @return
     */
    private static int method_2(int[][] grid){
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];

    }
}