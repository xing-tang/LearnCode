package com.open.learncode.算法.剑指offer.E_字符串相关算法;


import com.open.learncode.算法.base.PrintUtils;

import java.util.HashSet;

public class OtherMethod2 {
    public static void main(String[] args) {
        String s1 = "magazine";
        String s2 = "validate";
        // 测试用例
//        PrintUtils.getInstance().print(intersect(s1, s2), "字符串s1和字符串s2的交集");
        PrintUtils.getInstance().print(intersect2(s1, s2), "字符串s1和字符串s2的交集");
    }

    // 时间复杂度：O(n^2)，空间复杂度：O(n)，不科学的算法
    public static String intersect(String s1, String s2) {
        if (s1 == null || s1.length() <= 0) return "";
        if (s2 == null || s2.length() <= 0) return "";
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < char1.length; i++) {
            for (int j = 0; j < char2.length; j++) {
                if (char1[i] == char2[j]) {
                    strb.append(char1[i]);
                }
            }
        }
        return strb.toString();
    }

    // 时间复杂度：O(n)，空间复杂度：O(n)，不一定最科学
    public static String intersect2(String s1, String s2) {
        if (s1 == null || s1.length() <= 0) return "";
        if (s2 == null || s2.length() <= 0) return "";
        StringBuilder strb = new StringBuilder();
        StringBuilder tempStrb = new StringBuilder();
        strb.append(s1);
        strb.append(s2);
        HashSet<Character> hashSet = new HashSet<Character>();
        for (int i = 0; i < strb.length(); i++) {
            boolean temp = hashSet.add(strb.charAt(i));
            if (!temp) {
                tempStrb.append(strb.charAt(i));
            }
        }
        return strb.toString();
    }
}
