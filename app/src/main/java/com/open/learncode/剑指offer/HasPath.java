package com.open.learncode.剑指offer;

/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
 *
 * 思路：回溯法：首先任意一个点都有可能成为起点，所以要获得任意一点的坐标(位于第几行，第几列)
 * 其次要有一个数组记录这个点是否被访问过，同时要有一个指针来记录字符串中字符的位置。
 * 当某个点成为合法的起点时，即这个点与字符串中第一个字符相等，则可以继续朝上下左右搜索下一个点；
 * 如果这个点不能成为合法的起点，则恢复现场(这个点没有被访问过且字符串指针后退)
 */

public class HasPath {
    public boolean hasPath(char[][] matrix, int rows, int cols, String str) {
        if (matrix.length <= 0 || rows < 0 || cols < 0 || str.length() <= 0) {
            return false;
        }

        boolean visited[][] = new boolean[rows ][ cols];
        int[] index = {0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPath(matrix, rows, cols, i, j, str, visited, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPath(char[][] matrix, int rows, int cols, int row, int col, String str, boolean visited[][], int[] index) {
        if (index[0] == str.length()) {
            return true;
        }

        boolean flag = false;
        //当前点折算到原数组的位置是：row * cols + col
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row ][ col] && matrix[row][col] == str.charAt(index[0])) {
            index[0]++;    //指针右移
            visited[row ][ col] = true;

            //第一个点是合法的起点之后开始回溯:上下左右进行搜索
            flag = isPath(matrix, rows, cols, row - 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row + 1, col, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col - 1, str, visited, index) ||
                    isPath(matrix, rows, cols, row, col + 1, str, visited, index);
            if (!flag) {        //恢复现场
                index[0]--;
                visited[row ][col] = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
//        String str = "abtgcfcsjdeh";
//        char[] matrix = str.toCharArray();
//        String str2 = "bfce";
//        char[] c = str2.toCharArray();
        char matrix[][] = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        String str = "bfce";
        char[] c = str.toCharArray();
        System.out.println(c.length);
        System.out.println(new HasPath().hasPath(matrix, matrix.length, matrix[0].length, str));
    }

}