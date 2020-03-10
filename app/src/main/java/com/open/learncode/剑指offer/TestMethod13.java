package com.open.learncode.剑指offer;


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




    }

    private static int movingCount(int matrix, int rows, int columns) {

        if (matrix < 0 || rows <= 0 || columns <= 0)
            return 0;

        boolean visited[][] = new boolean[rows][columns];

        System.out.println(visited[0][0]);

        int count = movingCountCore(matrix, rows, columns, 0, 0, visited);


        return count;
    }

    private static int movingCountCore(int matrix, int rows, int columns, int row, int column, boolean[][] visited) {

        int count = 0;
        if (check(matrix, rows, columns, row, column, visited)) {

            visited[row][column]=true;
            count=1+movingCountCore(matrix,rows,columns,row-1,column,visited)
                    +movingCountCore(matrix,rows,columns,row+1,column,visited)
                    +movingCountCore(matrix,rows,columns,row,column-1,visited)
                    +movingCountCore(matrix,rows,columns,row,column+1,visited);

        }
        return count;


    }

    /**
     * 判断机器人能否进入坐标为（row，column）的方格
     *
     * @param matrix
     * @param rows
     * @param columns
     * @param row
     * @param column
     * @param visited
     * @return
     */
    private static boolean check(int matrix, int rows, int columns, int row, int column, boolean[][] visited) {

        if (row >= 0 && row < rows && column >= 0 && column < columns
                && getDigitSum(row) + getDigitSum(column) <= matrix && !visited[row][column]) {
            return true;
        }
        return false;

    }

    /**
     *
     * @param number 输入具体的数字
     * @return 返回数字num的位数之和
     */
    private static int getDigitSum(int number) {

        int sum=0;
        while (number>0){
            sum+=number%10;//余数
            number/=10;//除数
        }
        return sum;
    }

}