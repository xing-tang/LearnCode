package com.old.old.wcopy.leetcode_剑指offer.A5_跟数组相关的算法;

/**
 * 题目：
 * 替换空格：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如：输入"We are happy."，则输出"We%20are%20happy."
 * <p>
 * 解题思路：
 * 直接遍历字符串，遇到空格就替换成 %20
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ05_1_替换空格 {

    public static void main(String[] args) {
        String str = "we are happy.";
        String str1 = "";
        String str2 = " ";
        System.out.println(method(str));
        System.out.println(method(str1));
        System.out.println(method(str2));
    }

    /**
     * 遍历替换
     * @param str
     * @return
     */
    public static String method(String str) {
        if (str == null || str.length() <= 0) return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

