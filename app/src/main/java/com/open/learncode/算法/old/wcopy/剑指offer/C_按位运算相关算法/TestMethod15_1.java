package com.open.learncode.算法.old.wcopy.剑指offer.C_按位运算相关算法;


/**
 * 题目：
 * 二进制中1的个数：请实现一个函数，输入一个整数，输入该数二进制表示中1的个数。
 * 例如，把9表示成二进制是1001，有2位是1。因此，如果输入9，则该函数输出2
 * <p>
 * 解题思路：
 * 位与"&"运算
 * <p>
 * 复杂度分析：
 * n为数值的二进制表示的位数
 * 方法一：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod15_1 {

    public static void main(String[] args) {
        System.out.println(method_1(3));
        System.out.println(method_2(3));
        System.out.println(method_3(3));
    }

    /**
     * 可能引起死循环的解法
     * ps:
     * 1、把整数右移一位 把整数除以2 在数学上是等价的，但是除法的效率要比移位运算要低得多
     * 2、输入一个负数：0x8000,0000，右移一位，不是0x4000,0000，而是0xC000,0000
     * 因为移位后仍然要保证是一个负数，因此移位后的最高位会设为1，若一直做右移运算，
     * 那么最终这个数字就会变成0xFFFF,FFFF而陷入死循环
     *
     * @param n 输入一个整数
     * @return 返回二进制中1的个数
     */
    private static int method_1(int n) {
        //记录二进制中1的个数
        int count = 0;
        while (n != 0) {
            //1的二进制表示：除了最右边的一位值为，所有位都为0
            if ((n & 1) == 1) count++;
            //右移一位
            n = n >> 1;
        }
        return count;
    }

    /**
     * 常规解法：1、将n与1
     *
     * @param n 输入一个整数
     * @return 返回二进制中1的个数
     */
    private static int method_2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;

            flag = flag << 1;
        }
        return count;
    }

    /**
     * 惊喜解法：把一个数减去1，再和原整数做与运算，会把该整数最右边的1变成0
     * 一个整数的二进制表示中有多少1，就可以进行多少次这样的运算
     *
     * @param n 输入一个整数
     * @return 返回二进制中1的个数
     */
    private static int method_3(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}