package com.open.learncode.剑指offer.每日回顾.day_01;

/**
 * 题目：
 * 替换空格：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如：输入"We are happy."，则输出"We%20are%20happy."
 * <p>
 * 解题思路：
 * 替换空格，让%20替换空格
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod5_1 {

    public static void main(String[] args) {
        String str = "we are happy.";
        System.out.println(method(str));
    }

    private static String method(String str) {
        if (str == null || str.length() <= 0) return str;

        StringBuilder strb = new StringBuilder(str);
        int spaceNum = 0;
        for (int i = 0; i < strb.length(); i++) {
            if (strb.charAt(i) == ' ') spaceNum++;
        }
        int oldLength = str.length();
        int oldIndex = oldLength - 1;
        int newLength = oldLength + spaceNum * 2;
        int newIndex = newLength - 1;
        strb.setLength(newLength);
        while (oldIndex >= 0) {
            if (strb.charAt(oldIndex) == ' ') {
                strb.setCharAt(newIndex--, '0');
                strb.setCharAt(newIndex--, '2');
                strb.setCharAt(newIndex--, '%');
            } else {
                strb.setCharAt(newIndex--, strb.charAt(oldIndex));
            }
            oldIndex--;
        }
        return strb.toString();
    }
}

