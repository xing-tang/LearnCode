package com.open.learncode.剑指offer.test;

/**
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class TestMethod3_1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("数组中的重复数字是："+method(arr));

    }

    private static int method(int[] arr){

        //鲁棒性
        if(arr==null || arr.length<=0)
            return -1;

        //数组中数字的范围
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<0 || arr[i]>=arr.length)
                return -1;
        }

        for (int i = 0; i < arr.length; i++) {

            if(i!=arr[i]){

                if(arr[i]==arr[arr[i]]){
                    return arr[i];
                }
                swap(arr,i,arr[i]);
            }


        }

        return -1;
    }

    private static void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}

