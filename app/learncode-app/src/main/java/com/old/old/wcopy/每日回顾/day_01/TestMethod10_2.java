package com.old.old.wcopy.每日回顾.day_01;

/**
 * 题目：
 * 青蛙🐸跳台阶问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上有个n级的台阶总共有多少种跳法
 * <p>
 * 解题思路：
 * 当n=1，只有一种跳法
 * 当n=2，有两种跳法：一次跳2级；分两次跳，一次跳一级
 * 当n>2，第一次跳有两种不同的跳法：
 * 第一次只跳1级，此时，跳法数目=剩下的n-1级台阶的跳法数目，为f(n-1)
 * 第一次跳2级，此时，跳法数目=剩下的n-2级台阶的跳法数目，为f(n-2)
 * 因此，n级台阶的不同跳法的总数f(n)=f(n-1)+f(n-2)
 * <p>
 * 实际上，这就是斐波那契数列
 * f(0)=0,f(1)=1,f(2)=2,f(3)=3,f(4)=5,f(5)=8,f(6)=13
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(2的n次方)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod10_2 {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            System.out.println("f(" + i + ")=" + method(i));
        }
    }

    private static int method(int n) {
        if (n < 0) return -1;
        if (n <= 2) return n;

        int curr = 0;
        int pre2 = 1;
        int pre1 = 2;

        for (int i = 3; i <= n; i++) {
            curr = pre1 + pre2;
            pre2 = pre1;
            pre1= curr;
        }
        return curr;
    }

}

