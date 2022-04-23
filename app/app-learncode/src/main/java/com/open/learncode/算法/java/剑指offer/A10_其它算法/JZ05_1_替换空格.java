package com.open.learncode.算法.java.剑指offer.A10_其它算法;

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
public class JZ05_1_替换空格 {

    public static void main(String[] args) {
        String s = "we are happy.";
        StringBuffer str = new StringBuffer("we are happy.");
        System.out.println(method(str));
        System.out.println(method2(s));
    }

    /**
     * 从后往前替换空格
     *
     * @param str 输入的字符串
     * @return 输出的字符串
     */
    public static String method(StringBuffer str) {
        if (str == null || str.length() <= 0) return str.toString();

        int spaceLength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') spaceLength++;
        }

        int oldIndex = str.length() - 1;
        int newLength = str.length() + spaceLength * 2;
        int newIndex = newLength - 1;
        str.setLength(newLength);

        for (; oldIndex >= 0; oldIndex--) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    public static String method2(String str) {
        if (str == null || str.length() <= 0) return str;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == ' '){
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}

