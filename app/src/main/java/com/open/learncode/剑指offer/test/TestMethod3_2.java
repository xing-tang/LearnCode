package com.open.learncode.剑指offer.test;

/**
 * 题目：
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内。所以数组中至少有一个数字是重复。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如：如果输入长度为7的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 */
public class TestMethod3_2 {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};

        System.out.println("龟兔赛跑=>"+ method_1(arr));
        System.out.println("二分查找法=>"+ method_2(arr));

    }

    /**
     * 龟兔赛跑
     *
     * @param arr
     */
    private static int method_1(int[] arr) {

        //鲁棒性
        if (arr == null || arr.length <= 0)
            return -1;

        //数组中数字的范围
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > arr.length - 1)
                return -1;
        }

        //快慢指针
        int a1=arr[0];
        int a2=arr[0];

        //找到快慢指针第一次相遇的点
        while (true){
            a1=arr[a1];
            a2=arr[arr[a2]];

            if(a1==a2)
                break;
        }

        //找到的这个点一定是闭环内的点，却不一定是闭环的起点
        //要想找到闭环的起点
        int p1=arr[0];
        if(p1!=a2){
            p1=arr[p1];
            a2=arr[a2];
        }

        return p1;
    }

    /**
     * 二分查找法
     *
     * @param arr
     */
    private static int method_2(int[] arr) {

        //鲁棒性
        if (arr == null || arr.length <= 0)
            return -1;

        //数组中数字的范围
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > arr.length - 1)
                return -1;
        }

        int start = 1, end = arr.length - 1;

        while (start<=end){

            int mid=(end+start)>>1;

            //计算[]内满足条件的数字个数
            int count=0;
            for (int i = 0; i <arr.length ; i++) {
                if(arr[i]>=start&&arr[i]<=mid)
                    count++;
            }

            //终止条件
            if(start==end){
                if(count>1)
                    return start;
                else
                    break;
            }

            //缩小范围
            if (count>mid-start+1)
                end=mid;
            else
                start=mid+1;
        }

        return -1;
    }

}

