package com.open.learncode.算法.old.剑指offer.A5_跟数组相关的算法;


/**
 * 题目：
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵中的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3x4的矩阵中包含一条字符串"bfce"的路径。但矩阵中不包含"abfb"的路径，
 * 因为字符串的第一个字符b占据了矩阵的第一行第二个格子后，路径不能再次进入这个格子。
 * a    b   t   g
 * c    f   c   s
 * j    d   e   h
 * <p>
 * 解题思路：
 * 回溯法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n^2)   空间复杂度：O(n^2)
 */
public class JZ12_矩阵是否包含某字符路径 {

    public static void main(String[] args) {
        char matrix[][] = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
//        String str = "bfce";
        String str="h";
        System.out.println(hasPath(matrix, matrix.length, matrix[0].length, str));
    }

    /**
     * 回溯法
     *
     * @param matrix    矩阵二维数组
     * @param rows    矩阵行数
     * @param columns 矩阵列数
     * @param str     字符串
     * @return 返回matrix矩阵中是否存在一条包含str所有字符的路径
     */
    private static boolean hasPath(char matrix[][], int rows, int columns, String str) {
        //验证输入数据的合法性
        if (matrix == null || rows < 0 || columns < 0 || str.length() <= 0)
            return false;
        //标识该格子是否已经被访问
        boolean visited[][] = new boolean[rows][columns];
        //字符串的下标
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {



                if (hasPathCore(matrix, rows, columns, row, column, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        //清空visited数组
//        visited = null;
        return false;
    }

    /**
     * hasPath的具体实现
     *
     * @param matrix       矩阵二维数组
     * @param rows       矩阵行数
     * @param columns    矩阵列数
     * @param row        当前行号
     * @param column     当前列号
     * @param str        字符串
     * @param pathLength 字符串当前所在下标
     * @param visited    标识格子访问情况的二维数组
     * @return 返回matrix矩阵是否能定位到str字符串中下标为pathLength之后的所有字符
     */
    private static boolean hasPathCore(char[][] matrix, int rows, int columns, int row, int column, String str, int pathLength, boolean[][] visited) {
        //终止条件：路径字符串str上的所有字符都在矩阵二维数组matrix中找到合适的位置
        if(pathLength==str.length())
            return true;

        //将hasPath初始化为false
        boolean hasPath = false;

        //验证条件：①当前格子（row，column）是否与路径字符串中下标为pathLength的字符一样
        //         ②当前格子是否未被访问
        if (row >= 0 && row < rows && column >= 0 && column < columns
                && !visited[row][column] && matrix[row][column] == str.charAt(pathLength)) {
            //满足条件，定位正确，继续走下去
            pathLength++;
            //修改访问情况
            visited[row][column] = true;
            //从当前格子（row，column）的4个相邻格子（row，column-1） （row，column-1）
            //（row-1，column） （row+1，column）中去定位路径字符串中下标为pathLength+1的字符
            hasPath = hasPathCore(matrix, rows, columns, row, column - 1, str, pathLength, visited)
                    ||
                    hasPathCore(matrix, rows, columns, row, column + 1, str, pathLength, visited)
                    ||
                    hasPathCore(matrix, rows, columns, row - 1, column, str, pathLength, visited)
                    ||
                    hasPathCore(matrix, rows, columns, row + 1, column, str, pathLength, visited);

            //如果4个相邻格子都没有匹配到字符串中下标为pathLength+1的字符，
            // 则表明字符串中下标为pathLength的字符定位失败，回溯到前一个字符pathLength-1，重写定位
            if (!hasPath) {
                pathLength--;
                //定位失败，修改当前格子的访问情况
                visited[row][column] = false;
            }
        }
        return hasPath;
    }

}