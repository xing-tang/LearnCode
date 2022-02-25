package com.old.old.wcopy.每日回顾.day_01;


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
 * f(0)=0,f(1)=1,f(2)=1,f(3)=2,f(4)=3,f(5)=5,f(6)=8
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(2的n次方)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法四：时间复杂度：O(1)，空间复杂度：O(1)
 */
public class TestMethod10_1 {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println("f(" + i + ")=" + method(i));
        }
    }

    private static int method(int n) {
        if (n < 0) return -1;
        if (n <= 1) return n;

        int curr = 0;
        int pre2 = 0;
        int pre1 = 1;
        for (int i = 2; i <= n; i++) {
            curr = pre2 + pre1;
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }

}

