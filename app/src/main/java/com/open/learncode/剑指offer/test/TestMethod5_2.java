package com.open.learncode.剑指offer.test;

import android.os.AsyncTask;

/**
 * 题目：
 * 有两个排序的数组a1和a2，内存在a1的末尾有足够多的空余空间容纳a2。
 * 请实现一个函数，把a2中所有数字插入a1中，并且所有的数字都是排序的。
 * 例如：输入a1=>{1, 2, 3, 4}，a2=>{2, 4, 6}，输出a1=>{1, 2, 2, 3, 4, 4, 6}。
 */
public class TestMethod5_2 {

    public static void main(String[] args) {
        int[] a1 = new int[7];
        a1[0] = 1;
        a1[1] = 2;
        a1[2] = 3;
        a1[3] = 4;

        int[] a2 = {2, 4, 6};


        print(method(a1, 4, a2));
    }

    //从后往前
    private static int[] method(int[] a1, int length, int[] a2) {

        //鲁棒性
        if(a1==null || a1.length<=0 )
            return a2;

        if(a2==null || a2.length<=0)
            return a1;

        if(a1.length<length+a2.length)
            return null;

        int i=length-1;
        int j=a2.length-1;
        int len=i+j+1;

        while (i>=0&&j>=0)
            a1[len--]=a1[i]>a2[j]?a1[i--]:a2[j--];

        return a1;
    }

    private static void print(int[] arr){
        if(arr==null)
            return;

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if(i!=arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.print(arr[i]+"]");
        }
        System.out.println();
    }

}

