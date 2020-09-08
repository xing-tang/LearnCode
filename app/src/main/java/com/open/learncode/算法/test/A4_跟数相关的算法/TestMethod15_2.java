package com.open.learncode.算法.test.A4_跟数相关的算法;


/**
 * 题目：
 * 判断一个整数是不是2的整数次方。
 * <p>
 * 解题思路：
 * 利用按位与"&"运算
 * <p>
 * 复杂度分析：
 * n为数值的二进制表示的位数
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod15_2 {

    public static void main(String[] args) {
        for (int i = -8; i <= 8; i += 2) {
            System.out.println(i + "是不是2的整数次方=>" + method(i));
        }
    }

    /**
     * 判断输入的整数是不是2的整数次方
     *
     * @param n 输入的整数
     * @return 返回结果，true代表是，false代表不是
     */
    private static boolean method(int n) {
        if (n < 0) n = -n;
        return (n & (n - 1)) == 0;
    }
}