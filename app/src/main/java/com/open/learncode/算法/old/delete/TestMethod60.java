package com.open.learncode.算法.old.delete;

/**
 * 题目：
 * n个骰子的点数：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 解题思路：
 * 递归、动态规划，使用二维数组存储
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(6^n)【指数级别的复杂度，会很容易导致超时】，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n*6*n*6)即O(n^2)，空间复杂度：O(n^2)
 */
public class TestMethod60 {

    public static void main(String[] args) {
        int n = 2;
        double[] temp = twoSum(n);
        double[] temp2 = method_2(n);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < temp2.length; i++) {
            System.out.print(temp2[i] + " ");
        }
    }

    /**
     * 递归
     *
     * @param n 待输入的骰子数量
     * @return 输出所有和的概率一维数组
     */
    public static double[] twoSum(int n) {
        //思路一：遍历5*n+1种不重复结果，计算每一种不重复结果的组合个数
        double[] res = new double[5 * n + 1];
        int curSum = n;
        for (int i = 0; i < res.length; ++i) {
            res[i] = countSum(n, curSum) / Math.pow(6, n);
            ++curSum;
        }
        return res;
    }

    /**
     * 递归
     *
     * @param n      待输入骰子数量
     * @param curSum 当前n个骰子的和
     * @return 输出n个骰子和为curSum的个数
     */
    public static int countSum(int n, int curSum) {

        //鲁棒性
        if (n < 0 || curSum < 0)
            return 0;

        if (n == 0 && curSum == 0) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i < 7; ++i) {
            //固定一个骰子的点数
            sum += countSum(n - 1, curSum - i);
        }
        return sum;
    }

    /**
     * 动态规划，使用二维数组存储
     *
     * @param n 待输入的骰子数量
     * @return 输出所有和的概率一维数组
     */
    public static double[] method_2(int n) {
        // 初始化二维数组
        int[][] dp = new int[n][6 * n];
        // 初始化1颗骰子的所有可能性数量
        for (int j = 0; j < 6; ++j) dp[0][j] = 1;

        for (int i = 1; i < n; ++i) { //处理行
            for (int j = i; j < (i + 1) * 6; ++j) {
                for (int dice = 1; dice < 7; ++dice) {
                    if (j - dice < 0) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - dice];
                }
            }
        }
        // Math.pow(x, y)用来计算以x为底的y次方值
        double[] res = new double[5 * n + 1];
        for (int i = n; i < res.length; ++i) {
            res[i - n] = dp[n - 1][i] / Math.pow(6, n);
        }
        return res;
    }

}
