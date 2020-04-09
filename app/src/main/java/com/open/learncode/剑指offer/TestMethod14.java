package com.open.learncode.剑指offer;


/**
 * 题目：
 * 剪绳子：给你一根长度为n的绳子，请把绳子剪成m段（m n都是整数,m>1,n>1）
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如：当绳子的长度是8时，我们把它剪成长度分别为2 3 3三段，此时得到的最大乘积是18
 * <p>
 * 解题思路：
 * 动态规划和贪婪算法
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n^2)   空间复杂度：O(n)
 * 方法二：时间复杂度：O(1)   空间复杂度：O(1)
 */
public class TestMethod14 {

    public static void main(String[] args) {


        System.out.println(method_1(8));

        System.out.println(method_2(8));

    }

    private static int method_1(int length) {
        if (length < 2)
            return 0;
        //绳子长度为2，剪成1 1
        if (length == 2) {
            return 1;
        }
        //绳子长度为3，剪成1 2
        if (length == 3)
            return 2;

        //当绳子长度为length+1时的最大乘积
        int products[] = new int[length + 1];
        products[0] = 0;//当绳子为1，不能剪
        products[1] = 1;//当绳子为2，剪成1 1
        products[2] = 2;//当绳子为3，剪成1 2
        products[3] = 3;//当绳子为4，剪成1 3

        //最大乘积
        int max = 0;

        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 0; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;

                products[i] = max;
            }
        }

        max = products[length];

        return max;
    }

    private static int method_2(int length) {
        if (length < 2)
            return 0;
        //绳子长度为2，剪成1 1
        if (length == 2) {
            return 1;
        }
        //绳子长度为3，剪成1 2
        if (length == 3)
            return 2;

        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = length / 3;

        //当绳子最后剩下的长度为4的时候，不能再减去长度为3的绳子段
        //此时更好的方法是把绳子剪成长度为2的两段，因为2*2 > 1*3
        if (length - timesOf3 * 3 == 1)
            timesOf3 -= 1;
        System.out.println(timesOf3);

        int timesOf2 = (length - timesOf3 * 3) / 2;
        System.out.println(timesOf2);

        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
}