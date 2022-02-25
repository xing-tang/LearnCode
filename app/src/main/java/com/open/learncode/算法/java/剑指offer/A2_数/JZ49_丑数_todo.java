package com.open.learncode.算法.java.剑指offer.A2_数;

/**
 * 题目：
 * 丑数：我们把只包含因子2 3 5的数称作丑数。求从小到大的顺序的第1500个丑数。
 * 例如，6 8都是丑数，但14不是，因为它包含因子7。习惯上，我们把1当作第一个丑数。
 * <p>
 * 解题思路：
 * 动态规划
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)【其中N=n，动态规划需遍历计算dp列表】，空间复杂度：O(n)【长度为N的dp列表使用O(N)的额外空间】
 */

public class JZ49_丑数_todo {

    public static void main(String[] args) {
//        int n=0;
        int n = 1500;
        System.out.println("第" + n + "个丑数为：" + method(n));
    }

    /**
     * @param num
     * @return
     */
    private static int method(int num) {
        //鲁棒性
        if (num <= 0) return -1;

        //指针a b c指向首个丑数（即1）【且是分别通过x2 x3 x5得到的丑数】，循环根据递推公式得到下个丑数，并每轮将对应指针执行 +1 即可。
        int a = 0, b = 0, c = 0;
        //设动态规划列表dp，dp[i]代表第i+1个丑数。
        int[] dp = new int[num];
        //dp[0]=1，即第一个丑数为1
        dp[0] = 1;

        //for循环
        for (int i = 1; i < num; i++) {
            //丑数 = 某较小丑数 × 某因子
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            //dp[i]：n2 n3 n5的最小值
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        //返回第n个丑数。
        return dp[num - 1];
    }
}