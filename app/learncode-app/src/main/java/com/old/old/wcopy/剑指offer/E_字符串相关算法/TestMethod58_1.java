package com.old.old.wcopy.剑指offer.E_字符串相关算法;

/**
 * 题目：
 * 翻转单词顺序：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。例如输入字符串"I am a student."，
 * 则输出"student. a am I"。
 * <p>
 * 解题思路：
 * 双指针+两次翻转，分割+拼接
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod58_1 {

    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.println(str);
        System.out.println(method_1(str));
        System.out.println(method_2(str));
    }

    /**
     * 双指针+两次翻转
     *
     * @param str 待传入的字符串
     * @return 返回翻转后的字符串
     */
    public static String method_1(String str) {
        // 去掉首尾的空格
        str = str.trim();
        // 鲁棒性
        if (str.length() < 2) return str;

        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        while (end <= chars.length) {
            if (end == chars.length || chars[end] == ' ') {
                method_1(chars, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        method_1(chars, 0, chars.length - 1);
        return new String(chars);
    }

    /**
     * 翻转字符串
     *
     * @param chars 带翻转的字符串
     * @param start 待翻转的首角标
     * @param end   待翻转的尾角标
     */
    public static void method_1(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 分割+拼接
     *
     * @param str 待传入的字符串
     * @return 返回翻转后的字符串
     */
    public static String method_2(String str) {
        // 去掉首尾的空格
        str = str.trim();
        // 鲁棒性
        if (str.length() < 2) return str;

        int end = str.length() - 1;
        int tempIndex = end;
        StringBuilder res = new StringBuilder();
        while (end >= 0) {
            while (end >= 0 && str.charAt(end) != ' ') end--; // 搜索首个空格
            res.append(str.substring(end + 1, tempIndex + 1) + " "); // 添加单词
            while (end >= 0 && str.charAt(end) == ' ') end--; // 跳过单词间空格
            tempIndex = end; // tempIndex 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

}
