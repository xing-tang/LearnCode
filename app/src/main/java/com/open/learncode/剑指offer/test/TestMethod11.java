package com.open.learncode.剑指offer.test;

/**
 * 题目：
 * 旋转数组的最小数字：把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class TestMethod11 {

    public static void main(String[] args) {

        int[] arr={2,3,0,1,1};
        System.out.println("旋转数组的最小值为："+method(arr));
    }

    private static int method(int[] arr){

        if(arr==null || arr.length<=0)
            return -1;

        int left=0,right=arr.length-1;

        if(arr[left]<arr[right])
            return arr[left];

        while (left<right){

            if(arr[left]<arr[right])
                return arr[left];

            int mid=(left+right)>>1;

            //mid处于B中
            if(arr[mid]<arr[right])
                right=mid;
            //mid处于A中
            else if(arr[mid]>arr[right])
                left=mid+1;
            else
                left=left+1;

        }

        return arr[left];

    }

}

