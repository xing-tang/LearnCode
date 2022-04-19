package com.open.learncode.算法.java.剑指offer.A11_补充;


/**
 * 题目：
 * OT_返回前n个字符：输入一个字符串，中文占两个字符，返回前14个字符，但不能返回半个中文。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(n)。
 */
public class OT05_返回前n个字符 {

    public static void main(String[] args) {
        // 测试用例
        System.out.println(getSubString("hhgj含含糊糊3哈哈哈哈啊啊啊啊哈哈哈", 14));
    }

    public static String getSubString(String str, int length) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int count = 0;
        int offset;
        char[] chars = str.toCharArray();
        int size = chars.length;
        if (size >= length) {
            for (int i = 0; i < chars.length; i++) {
                // 中文字符取值大于255
                if (chars[i] > 255) {
                    offset = 2;
                    count += 2;
                } else {
                    offset = 1;
                    count++;
                }
                if (count == length) {
                    return str.substring(0, i + 1);
                }
                if ((count == length + 1 && offset == 2)) {
                    return str.substring(0, i);
                }
            }
        } else {
            return str;
        }
        return "";
    }
}