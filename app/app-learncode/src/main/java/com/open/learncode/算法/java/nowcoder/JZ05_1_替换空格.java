package com.open.learncode.算法.java.nowcoder;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 替换空格：请实现一个函数，把字符串中的每个空格替换成"%20"。请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为"We Are Happy"，则经过替换之后的字符串为"We%20Are%20Happy"。
 * <p>
 * 数据范围：
 * 给定的字符串长度不超过100。保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
 * <p>
 * 复杂度分析：
 * 时间复杂度O(1)，空间复杂度O(n)
 */
public class JZ05_1_替换空格 {

    public static void main(String[] args) {
        // 测试用例
        String str = "We Are Happy";
        PrintUtils.getInstance().print(str);
        PrintUtils.getInstance().print(solution(str));
    }

    public static String solution(String str) {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == ' ') {
                strb.append("%20");
            } else {
                strb.append(temp);
            }
        }
        return strb.toString();
    }
}

