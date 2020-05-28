package com.open.learncode.剑指offer.每日回顾.day_01;

/**
 * 题目：
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内。所以数组中至少有一个数字是重复。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如：如果输入长度为7的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 * <p>
 * 解题思路:
 * 二分法查找法
 * 龟兔赛跑算法
 * <p>
 * 复杂度分析:
 * 方法一的时间复杂度：O(n)，空间复杂度：都为O(1)
 * 方法二的时间复杂度：O(nlongn)，空间复杂度：都为O(1)
 */
public class TestMethod3_2 {

    public static void main(String[] args) {
        int[] arr = {2,3,5,4,3,2,6,7};
        System.out.println("龟兔赛跑算法打印重复的数字=>" );
        System.out.println("二分法打印重复的数字=>");
    }


}

