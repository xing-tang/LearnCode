package com.open.learncode.剑指offer;


/**
 * 题目：
 * 求斐波那契数列的第n项：写入一个函数，输入n，求斐波那契数列的第n项。斐波那契数列的定义如下：
 * f(n)=0               n=0
 * f(n)=1               n=1
 * f(n)=f(n-1)+f(n-2)   n>1
 * <p>
 * 解题思路：
 * 递归：需要重复计算的节点数太多
 * 循环：从下往上计算，避免重复计算
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n) 空间复杂度：O(1)
 */
public class TestMethod10_1 {

    public static void main(String[] args) {

        System.out.println(method(10));

    }

    /**
     * 循环，从下往上计算
     *
     * @param n 输入的参数
     * @return 返回斐波那契数列的第n项
     */
    private static long method(int n) {
        int result[] = {0, 1};
        if (n < 2) {
            return result[n];
        }

        long pre1 = 0;
        long pre2 = 1;
        long sum = 0;

        for (int i = 2; i <= n; i++) {
            sum=pre1+pre2;

            pre1=pre2;
            pre2=sum;
        }
        return sum;
    }
}

