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
 * 方法一：时间复杂度：O(2的n次方)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法四：时间复杂度：O(1)，空间复杂度：O(1)
 */
public class TestMethod10_1 {

    public static void main(String[] args) {
        System.out.println(method_1(10));
        System.out.println(method_2(10));
        System.out.println(method_3(10));
        System.out.println(method_4(10));
    }

    /**
     * 递归方法
     *
     * @param n 输入参数
     * @return 返回斐波那契数列的第n项
     */
    public static long method_1(int n) {
        if (n <= 1) {
            return n;
        }
        return method_1(n - 1) + method_1(n - 2);
    }

    /**
     * 记忆化自底向上的方法
     *
     * @param n 输入参数
     * @return 返回斐波那契数列的第n项
     */
    public static int method_2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] cache = new int[n + 1];
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    /**
     * 循环，从下往上计算
     *
     * @param n 输入的参数
     * @return 返回斐波那契数列的第n项
     */
    private static long method_3(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    /**
     * 黄金分割率计算
     *
     * @param n 输入参数
     * @return 返回斐波那契数列的第n项
     */
    public static long method_4(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }

}

