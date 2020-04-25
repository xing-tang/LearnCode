package com.open.learncode.剑指offer.test;

/**
 * 题目：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。 {{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}}
 */
public class TestMethod4 {

    public static void main(String[] args) {

        int[][] arr={{1, 2, 8, 9}, {2, 3, 9, 12}, {4, 7, 10, 13}};

        System.out.println("是否含有该整数："+method_1(arr,1));
        System.out.println("是否含有该整数："+method_2(arr,1));
    }

    /**
     * 右上角
     *
     * @param arr
     * @param target
     * @return
     */
    private static boolean method_1(int[][] arr,int target){

        //鲁棒性
        if(arr==null || arr.length<=0)
            return false;

        int row=0;
        int column=arr[0].length-1;


        while (row<arr.length && column>=0){
            if(target==arr[row][column] )
               return true;
            else if(target<arr[row][column])
                column--;
            else
                row++;

        }

        return false;
    }

    /**
     * 左下角
     *
     * @param arr
     * @param target
     * @return
     */
    private static boolean method_2(int[][] arr,int target){

        //鲁棒性
        if(arr==null || arr.length<=0)
            return false;

        int row=arr.length-1;
        int column=0;


        while (column<arr[0].length && row>=0){
            if(target==arr[row][column] )
                return true;
            else if(target<arr[row][column])
                row--;
            else
                column++;

        }

        return false;
    }

}

