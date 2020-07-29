package com.open.learncode.剑指offer;


/**
 * 题目：
 * 打印从1到最大的n位数：输入数字n，按顺序打印出从1到最大的n位十进制。
 * 比如：输入3，则打印出1 2 3一直到最大的三位数999
 * <p>
 * 解题思路：
 *
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(exponent)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(exponent)，空间复杂度：O(1)
 * 方法三：时间复杂度：O(log(exponent))，空间复杂度：O(1)
 */
public class TestMethod17 {

    public static void main(String[] args) {
        method_1(3);
        method_1(0);
        method_1(-1);
        method_2(3);
    }

    /**
     * 先求出最大的n位数，然后利用一个循环从1开始逐个打印
     *
     * 陷阱：当输入的n很大的时候，求最大的n位数用int或者long都会溢出，即我们需要考虑大数问题
     *
     * @param n
     * @return
     */
    private static void method_1(int n) {

        if (n <= 0) return;

        //找到最小的n+1位数
        int num = 1;
        int i = 0;
        while (i++ < n)
            num *= 10;
        System.out.println("num=" + num);

        for (int j = 1; j < num; j++) {
            System.out.println(j);
        }
    }

    /**
     * 用字符串表示大数
     *
     * @param n
     */
    private static void method_2(int n) {

        if (n <= 0)
            return;

        //数字最大是n位的，因此需要一个长度为n+1的字符串（字符串最后一位是结束符号'\0'）
        char num[] = new char[n + 1];

        memse(num,'0',n);
        num[n]='\0';

        while (!Increment(num)){
            for (int x:num) {
                System.out.print(x+" ");
            }
        }

    }

    private static void memse(char[] num, char c, int n) {
    }

    private static boolean Increment(char number[]) {
        boolean isOverflow = false;
        int takeOver = 0;
        int length = number.length;
        for (int i = length - 1; i >= 0; i--) {
            int sum = number[i] - '0' + takeOver;
            if (i == length - 1)
                sum++;
            if (sum >= 10) {
                if (i == 0)
                    isOverflow = true;
                else {
                    sum -= 10;
                    takeOver = 1;
                    number[i] = (char) ('0' + sum);
                }
            } else {
                number[i] = (char) ('0' + sum);
            }
        }
        return isOverflow;
    }


}