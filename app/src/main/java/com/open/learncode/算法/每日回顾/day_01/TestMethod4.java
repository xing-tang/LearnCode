package com.open.learncode.算法.每日回顾.day_01;

/**
 * 题目：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。 {{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}}
 * <p>
 * 解题思路：
 * 二维数组在内存空间占用连续的空间，且从左至右从上至下按递增排序。
 * <p>
 * 复杂度分析：
 * 方法一、二：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class TestMethod4 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}};
        System.out.println(method(array, 1));
    }

    private static boolean method(int[][] arr, int target) {
        if (arr == null || arr.length <= 0 || arr[0].length <= 0) return false;

        int row = 0;
        int column = arr.length - 1;
        while (row <= arr.length - 1 && column >= 0) {
            if (target > arr[row][column]) {
                row++;
            } else if (target < arr[row][column]) {
                column--;
            } else {
                return true;
            }
        }


        return false;
    }

}

