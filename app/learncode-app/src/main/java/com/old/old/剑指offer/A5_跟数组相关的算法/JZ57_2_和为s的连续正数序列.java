package com.old.old.剑指offer.A5_跟数组相关的算法;

/**
 * 题目：
 * 和为s的连续正数序列：输入一个正整数s，打印出所有和为s的连续正数序列（至少含两个数）。
 * 例如，输入15，由于1+2+3+4=4+5+6=7+8=15，所以打印出三个连续序列1~5、
 * 4~6和7~8。
 * <p>
 * 解题思路：
 * 双指针
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(num)【num指传入的数字】，空间复杂度O(1)
 */
public class JZ57_2_和为s的连续正数序列 {

    public static void main(String[] args) {
        int num = 15;
        method(num);
    }

    /**
     * 双指针法
     *
     * @param num 待传入的数字
     */
    public static void method(int num) {
        if (num < 2) return;
        int start = 1;
        int end = 2;
        int middle = (num + 1) / 2;
        int curSum = start + end;
        while (start < middle) {
            if (curSum == num) print(start, end);
            while (curSum > num && start < middle) {
                curSum -= start;
                start++;
                if (curSum == num) print(start, end);
            }
            end++;
            curSum += end;
        }
    }

    /**
     * 打印输出star到end的值
     *
     * @param star 开始要打印的值
     * @param end  最终要打印的值
     */
    public static void print(int star, int end) {
        for (int i = star; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
