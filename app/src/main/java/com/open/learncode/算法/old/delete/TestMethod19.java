package com.open.learncode.算法.old.delete;


/**
 * 题目：
 * 正则表达式匹配：请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 解题思路：
 * 注意 . * 的匹配情况
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n) n为str或者pattern字符串的长度
 * 空间复杂度：O(1)
 */
public class TestMethod19 {

    public static void main(String[] args) {

        String str = "aaa";
        String str2 = "";
        String pattern = "ab*ac*a";
        String pattern2 = "a.a";
        String pattern3 = "";
        System.out.println(match(str.toCharArray(), pattern.toCharArray()));
        System.out.println(match(str.toCharArray(), pattern2.toCharArray()));
        System.out.println(match(str2.toCharArray(), pattern3.toCharArray()));

    }

    private static boolean match(char[] str, char[] pattern) {

        if (str + "" == null || pattern + "" == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);

    }

    private static boolean matchCore(char[] str, int i, char pattern[], int j) {

        //都匹配到了'\0'末尾处
        if (i == str.length && j == pattern.length)
            return true;

        //pattern匹配到了末尾处，而str没有
        if (i != str.length && j == pattern.length)
            return false;

        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            if (pattern[j] == str[i] || (pattern[j] == '.' && str[i] != '\0'))
                return matchCore(str, i + 1, pattern, j + 2)
                        || matchCore(str, i + 1, pattern, j)
                        || matchCore(str, i, pattern, j + 2);
            else
                return matchCore(str, i, pattern, j + 2);
        }

        if (str[i] == pattern[j] || (pattern[j] == '.' && str[i] != '\0'))
            return matchCore(str, i + 1, pattern, j + 1);

        return false;
    }

}