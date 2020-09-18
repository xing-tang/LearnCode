package com.open.learncode.算法.test.A6_跟字符串相关算法;

import com.open.learncode.算法.base.PrintUtils;

import java.util.LinkedHashSet;

/**
 * 题目：
 * 字符串，去重（去掉后面重复的），保持原本输入顺序？第二问是：如果时间复杂度不是O(n)，想做到O(n)，怎么做？
 * <p>
 * 解题思路：
 * 分析10进制如何进位的然后模仿
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class OT_字符串去重 {

    public static void main(String[] args) {
        String str = "abbcaddrff";
        PrintUtils.getInstance().print(str);
        PrintUtils.getInstance().print(method1(str));
        PrintUtils.getInstance().print(method2(str));
    }

    /**
     * 字符串去重
     *
     * @param str 待输入的字符串
     * @return 返回去重后的字符串
     */
    private static String method1(String str) {
        if (str == null || str.length() <= 1) return str;

        StringBuilder strb = new StringBuilder();
        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            boolean isAddSuccess = hashSet.add(str.charAt(i));
            if (isAddSuccess) strb.append(str.charAt(i));
        }
        return strb.toString();
    }

    /**
     * 字符串去重
     *
     * @param str 待输入的字符串
     * @return 返回去重后的字符串
     */
    public static String method2(String str) {
        StringBuilder sb = new StringBuilder(str);
       return sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
//        return sb.reverse().toString();
    }
}
