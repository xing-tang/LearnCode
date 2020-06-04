package com.open.learncode.剑指offer.排序.T3_插入排序;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {6, 4, 5, 7, 0};
        insertSort(arr);
        System.out.println();
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        //假设第一个数位置时正确的；要往后移，必须要假设第一个。
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            //待插入的
            int temp = arr[i];
            //后移
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            //插入
            arr[j] = temp;
        }

    }

}
