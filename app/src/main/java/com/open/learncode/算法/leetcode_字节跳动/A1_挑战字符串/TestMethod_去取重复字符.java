package com.open.learncode.算法.leetcode_字节跳动.A1_挑战字符串;

import com.open.learncode.算法.base.PrintUtils;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

public class TestMethod_去取重复字符 {

    public static void main(String[] args) {
        String str = "abcbcw家具sx dalo家ioli";
        PrintUtils.getInstance().print(str);
        PrintUtils.getInstance().print(method3(str));

    }

    private static String method(String str) {
        if (str == null || str.length() <= 1) return str;

        StringBuilder res = new StringBuilder();
        StringBuilder strb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (!res.toString().contains(strb.charAt(i) + "")) {
                res.append(strb.charAt(i));
            }
        }
        return res.toString();
    }

    private static String method2(String str) {
        if (str == null || str.length() <= 1) return str;

        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            hashSet.add(str.charAt(i));
        }
        StringBuilder strb = new StringBuilder();
        for (Character c : hashSet) {
            strb.append(c);
        }
        return hashSet.toString();

    }


    public static String method3(String str) {
//        StringBuilder sb = new StringBuilder(str);
//        sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
//        sb = new StringBuilder(rs);
//        return sb.reverse().toString();

        str = str.replaceAll("(.)(?=.*\\1)", "");

        return str;
    }


    public static String method4(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder strb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                strb.append(chars[i - 1]);
            }
        }
        return strb.toString();
    }


}
