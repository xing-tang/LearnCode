package com.open.learncode.算法.java.剑指offer.A03_栈和队列;

/**
 * 题目：
 * 输出一个正整数，判断是否为回文数。
 * <p>
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(logn)【logn为数字n的位数】，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ31_2_是否是回文数 {

    public static void main(String[] args) {
        System.out.println("是不是回文数：" + method_1(12321));
        System.out.println("是不是回文数：" + method_2(122121));
    }

    /**
     * 判断是否为回文数
     *
     * @param num 待输入的正整数
     * @return 返回ture代表是回文数，false代表不是回文数
     */
    public static boolean method_1(int num) {
        // 特殊情况：
        // 如上所述，当 num < 0 时，num 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (num < 0 || (num % 10 == 0 && num != 0)) return false;

        int tempNum = 0;
        while (num > tempNum) {
            tempNum = tempNum * 10 + num % 10;
            num /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 tempNum/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，tempNum = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return num == tempNum || num == tempNum / 10;
    }

    /**
     * 判断是否为回文数
     *
     * @param num 待输入的正整数
     * @return 返回ture代表是回文数，false代表不是回文数
     */
    private static boolean method_2(int num) {
        // 负数不是回文数
        if (num < 0) return false;
        // 一位数都是回文数
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

