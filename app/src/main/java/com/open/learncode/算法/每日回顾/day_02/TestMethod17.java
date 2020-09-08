package com.open.learncode.算法.每日回顾.day_02;


/**
 * 题目：
 * 打印从1到最大的n位数：输入数字n，按顺序打印出从1到最大的n位十进制。
 * 比如：输入3，则打印出1 2 3一直到最大的三位数999
 * <p>
 * 解题思路：
 *
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(exponent)   空间复杂度：O(n)
 * 方法二：时间复杂度：O(exponent)   空间复杂度：O(1)
 * 方法三：时间复杂度：O(log(exponent))   空间复杂度：O(1)
 */
public class TestMethod17 {

    public static void main(String[] args) {


        method_1(3);
        method_1(0);
        method_1(-1);
        method_2(3);


    }


    /**
     * 跳入陷阱：先求出最大的n位数，然后利用一个循环从1开始逐个打印
     * 陷阱：当输入的n很大的时候，求最大的n位数用int或者long都会溢出，即我们需要考虑大数问题
     *
     * @param n
     * @return
     */
    private static void method_1(int n) {

        if (n <= 0) return;
        int num=1;
        for (int i = 0; i <n ; i++) {
            num*=10;
        }
        System.out.println("num="+num);

        for (int i = 1; i < num; i++) {
            System.out.print(i+" ");
        }
    }

    /**
     * 用字符串表示大数
     *
     * @param n
     */
    private static void method_2(int n) {


    }

}