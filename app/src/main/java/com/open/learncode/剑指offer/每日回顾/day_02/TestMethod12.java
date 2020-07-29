package com.open.learncode.剑指offer.每日回顾.day_02;


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
public class TestMethod12 {

    public static void main(String[] args) {
        char matrix[][] = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
//        String str = "bfce";
        String str = "";
        System.out.println();
    }

    private static boolean method(int[][] arr, int target) {
        if (arr == null || arr.length <= 0 || arr[0].length <= 0) return false;

        return false;
    }

}