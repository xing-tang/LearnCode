package com.open.learncode.算法.java.剑指offer.A4_字符串;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：
 * 字符串的排列：输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如，输入字符串abc，则打印出由字符a,b,c所能排列出的所有字符串abc acb bac bca cab cba
 * <p>
 * 解题思路：
 * ①排列方案数量： 对于一个长度为 n 的字符串（假设字符互不重复），
 * 其排列共有 n* (n-1)* (n-2) …* 2* 1n×(n−1)×(n−2)…×2×1 种方案
 * ②排列方案的生成方法： 根据字符串排列的特点，考虑深度优先搜索所有排列方案。
 * 即通过字符交换，先固定第 1 位字符（ n 种情况）、再固定第 2 位字符（ n−1 种情况）、... 、最后固定第 n 位字符（ 1 种情况）
 * ③重复方案与剪枝： 当字符串存在重复字符时，排列方案中也存在重复方案。
 * 为排除重复方案，需在固定某位字符时，保证 “每种字符只在此位固定一次” ，即遇到重复字符时不交换，直接跳过。
 * 从 DFS 角度看，此操作称为 “剪枝” 。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n!)，空间复杂度：O(n^2)
 */

public class JZ38_1_字符串的排列 {

    public static void main(String[] args) {
        String str = "abc";
        String[] arr = permutation(str);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 保存所有排列结果
    private static List<String> list = new LinkedList<>();
    // 为了让递归函数添加结果方便，定义到函数之外，这样无需带到递归函数的参数列表中
    private static char[] c;

    /**
     * 获取字符串全排列数组
     *
     * @param str 待输入的是字符串
     * @return 返回字符串全排列的数组
     */
    private static String[] permutation(String str) {
        // 将String字符串转化为char数组
        c = str.toCharArray();
        // 从第一层开始递归
        dfs(0);
        // 将字符串数组ArrayList转化为String类型数组
        return list.toArray(new String[list.size()]);
    }


    /**
     * 递归
     *
     * @param x 层数
     */
    private static void dfs(int x) {
        // 递归终止条件：代表所有位已固定（最后一位只有 1 种情况），将当前组合c转化为字符串，并加入list中
        if (x == c.length - 1) {
            list.add(String.valueOf(c));
            return;
        }

        // 初始化一个 Set ，用于排除重复的字符.
        // 将第 x 位字符与 i ∈ [x, len(c)] 字符分别交换，并进入下层递归
        HashSet<Character> hashSet = new HashSet<Character>();
        for (int i = x; i < c.length; i++) {
            // 若 c[i] 在 Set​ 中，代表其是重复字符，因此“剪枝”
            if (hashSet.contains(c[i])) continue;
            // 将字符 c[i] 和 c[x] 交换，即固定 c[i] 为当前第 x 位字符
            swap(i, x);
            // 进入下一层递归：即开始固定第 x+1 个字符
            dfs(x + 1);
            // 还原交换： 将字符 c[i] 和 c[x] 交换（还原之前的交换）；
            swap(i, x);
        }
    }

    /**
     * 交换对应索引坐标的数组元素
     *
     * @param a 索引坐标a
     * @param b 索引坐标b
     */
    private static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}