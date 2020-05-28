package com.open.learncode.剑指offer.每日回顾.day_05;

import java.util.ArrayList;

/**
 * 题目：
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 解题思路：
 * 用链表模拟圆圈，数学归纳法
 * <p>
 * 复杂度分析：
 * 方法一：
 * 时间复杂度：O(n^2)【ArrayList#remove方法每次删除的时间复杂度为O(n),删除n个元素即为O(n^2)】
 * 空间复杂度：O(n)
 * 方法二：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod62 {

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println("最后一个数字为：" + method_1(n, m));
        System.out.println("最后一个数字为：" + method_2(n, m));
    }

    /**
     * 用链表模拟圆圈
     *
     * @param n 待输入的n个数字排成一个圆圈
     * @param m 删除这个圆圈中第m个数字
     * @return 返回圆圈最后剩下的一个数字
     */
    public static int method_1(int n, int m) {
        if (n < 1 || m < 1) return -1;

        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 数学归纳法
     *
     * @param n 待输入的n个数字排成一个圆圈
     * @param m 删除这个圆圈中第m个数字
     * @return 返回圆圈最后剩下的一个数字
     */
    public static int method_2(int n, int m) {
        if (n < 1 || m < 1) return -1;

        int last = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }


}
