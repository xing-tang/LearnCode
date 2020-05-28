package com.open.learncode.剑指offer.每日回顾.day_03;

/**
 * 题目：
 * 回文数
 * <p>
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)  空间复杂度：O(1)
 */
public class testMethod31_2 {

    public static void main(String[] args) {

        System.out.println("是不是回文数：" + method(12321));
        System.out.println("是不是回文数：" + method(122121));

    }

    private static boolean method(int num) {

        //负数不是回文数
        if (num < 0)
            return false;

        //一位数都是回文数
        if (num >= 0 && num < 10)
            return true;

        int len = 1;
        //判断位数
        while (num / len >= 10) {
            len *= 10;
        }

        while (num > 0) {
            int left = num / len; //取左边第一位
            int right = num % 10; //取最后一位

            if (left != right) {
                return false;
            }

            //减去左右边上两位，剩余中间的(num%len：除去最高位 /10：除去最低位）
            num = num % len / 10;

            //len也减少两位
            len = len / 100;
        }

        return true;
    }
}

