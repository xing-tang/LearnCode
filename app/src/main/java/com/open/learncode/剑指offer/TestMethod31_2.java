package com.open.learncode.剑指offer;

/**
 * 题目：
 * 回文数
 * <p>
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)【logn为数字n的位数】，空间复杂度：O(1)
 */
public class TestMethod31_2 {

    public static void main(String[] args) {
        System.out.println("是不是回文数：" + method(12321));
        System.out.println("是不是回文数：" + method(122121));
    }

    private static boolean method(int num) {
        //负数不是回文数
        if (num < 0) return false;
        //一位数都是回文数
        if (num >= 0 && num < 10) return true;

        int length = 1;
        // 判断位数
        while (num / length >= 10) {
            length *= 10;
        }

        while (num > 0) {
            int left = num / length;// 取左边第一位
            int right = num % 10; // 取最后一位
            if (left != right) return false;
            // 减去左右边上两位，剩余中间的(num%len：除去最高位 /10：除去最低位）
            num = num % length / 10;
            // len也减少两位
            length = length / 100;
        }
        return true;
    }
}

