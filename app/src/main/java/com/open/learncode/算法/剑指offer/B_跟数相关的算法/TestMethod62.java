package com.open.learncode.算法.剑指offer.B_跟数相关的算法;

import java.util.ArrayList;

/**
 * 题目：
 * 圆圈中最后剩下的数字：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字，
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 解题思路：
 * 用链表模拟圆圈，数学归纳法
 * <p>
 * 复杂度分析：
 * 方法一：
 * 时间复杂度：O(n^2)【ArrayList#remove方法每次删除的时间复杂度为O(n)【后续元素需要向前移位】，删除n-1个元素即为O(n^2)】
 * 空间复杂度：O(n)
 * 方法二：
 * 时间复杂度：O(n)【反推需要的时间，本题中有5个数字，需反推4次】
 * 空间复杂度：O(1)【变量last使用O(1)大小的额外空间。】
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

        //鲁棒性
        if (n < 1 || m < 1)
            return -1;

        //基于ArrayList的模拟链表
        ArrayList<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++)
            list.add(i);


        //当前删除的位置
        int idx = 0;
        while (n > 1) {
            //下一个删除的数字的位置
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

        //鲁棒性
        if (n < 1 || m < 1)
            return -1;

        //最后剩下的那个数字的下标为2
        int last = 0;

        //最后一轮剩余数字的个数为1，上一轮剩余数字的个数为2
        for (int i = 2; i <= n; i++) {
            //反推：（当前index+m)%上一轮剩余数字的个数
            last = (last + m) % i;
        }

        //找到最后剩下的那个数字在原先数组中的下标【数组的下标==该下标对应的值】
        return last;
    }


}
