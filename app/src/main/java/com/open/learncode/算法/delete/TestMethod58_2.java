package com.open.learncode.算法.delete;

/**
 * 题目：
 * 左旋转字符：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 解题思路：
 * 三次翻转
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod58_2 {

    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        System.out.println(str);
        System.out.println(method(str, n));
    }

    /**
     * 翻转三次字符串
     *
     * @param str 待翻转的字符串
     * @param n   左旋转的位数
     * @return 返回翻转后的字符串
     */
    public static String method(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars != null) {
            if (chars.length > 0 && n > 0 && n < chars.length) {
                int start1 = 0;
                int end1 = n - 1;
                int start2 = n;
                int end2 = chars.length - 1;
                // 翻转字符串的前n个字符
                method(chars, start1, end1);
                // 翻转字符串的后面部分
                method(chars, start2, end2);
                // 将整个字符串进行翻转
                method(chars, start1, end2);
            }
        }
        return new String(chars);
    }

    /**
     * 翻转字符串
     *
     * @param chars 待翻转的字符串
     * @param start 待翻转的首角标
     * @param end   待翻转的尾角标
     */
    public static void method(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
