package com.open.learncode.算法.old.剑指offer.A6_跟字符串相关算法;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 最长不含重复字符的子字符串：请从字符串中找到一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含'a'~'z'的字符。例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4
 * <p>
 * 解题思路：
 * 动态规划
 * 转移方程：
 * dp[j]=dp[j−1]+1，dp[j−1]<j−i
 * dp[j]=j−i      ，dp[j−1]≥j−i
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(N)，空间复杂度O(1)
 */

public class JZ48_最长不含重复字符的子字符串 {

    public static void main(String[] args) {

        String str = "arabcacfr";
//        String str = "abcabcab";

        System.out.println("最长的不含重复字符的子字符串的长度是：" + method_1(str));
        System.out.println("最长的不含重复字符的子字符串的长度是：" + method_2(str));
    }

    /**
     * 动态规划 + 哈希表
     * 时间复杂度O(N)： 其中N为字符串长度，动态规划需遍历计算 dpdp 列表。
     * 空间复杂度O(1)： 字符的ASCII码范围为0 ~ 127，哈希表dic最多使用O(128)=O(1)大小的额外空间。
     *
     * @param s
     * @return
     */
    private static int method_1(String s) {
        //map：键值对=字符：字符的索引。存储各字符最后一次出现的索引位置
        Map<Character, Integer> map = new HashMap<>();
        //count：每轮更新最大值，存储dp[j-1]；temp：存储dp[j]
        int count = 0, temp = 0;
        for (int j = 0; j < s.length(); j++) {
            //获取s的第j个字符在map中对应的值
            int i = map.containsKey(s.charAt(j)) ? map.get(s.charAt(j)) : -1;
            map.put(s.charAt(j), j); // 更新哈希表
            temp = temp < j - i ? temp + 1 : j - i; // dp[j - 1] -> dp[j]
            count = Math.max(count, temp); // max(dp[j - 1], dp[j])
        }
        return count;
    }

    /**
     * 双指针 + 哈希表
     * 时间复杂度O(N) ： 其中N为字符串长度，动态规划需遍历计算dp列表。
     * 空间复杂度O(1) ： 字符的ASCII码范围为0 ~ 127，哈希表dic最多使用O(128)=O(1)大小的额外空间。
     *
     * @param s
     * @return
     */
    private static int method_2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j))); // 更新左指针 i
            map.put(s.charAt(j), j); // 哈希表记录
            count = Math.max(count, j - i); // 更新结果
        }
        return count;

    }
}
