package com.open.learncode.算法.delete;

/**
 * 题目：
 * 求1+2+...+n：求1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 * <p>
 * 解题思路：
 * 递归+通过逻辑运算的短路操作来进行，&&当前者不成立时后者区域不会执行。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod64 {

    public static void main(String[] args) {
        method(5);
        System.out.println(sum);
    }

    public static int sum = 0;

    /**
     * 递归+通过逻辑运算的短路操作来进行，&&当前者不成立时后者区域不会执行。
     *
     * @param n 待输入的n
     * @return 返回1到n的和
     */
    public static int method(int n) {
        //当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        boolean x = n > 1 && method(n - 1) > 0;
        sum += n;
        return sum;
    }

}
