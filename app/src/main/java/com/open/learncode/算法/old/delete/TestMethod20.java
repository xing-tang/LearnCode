package com.open.learncode.算法.old.delete;


/**
 * 题目：
 * 表示数值的字符串：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如：字符串"+100" "5e2" "-123" "3.1416" "-1E-16"都表示数值
 * 但"12e" "1a3.14" "1.2.2" ""+-5" "12e+5.4"都不是
 * <p>
 * 解题思路：
 * 数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示
 * A C为整数（可以有正负号，也可以没有） B是一个无符号整数
 * <p>
 * 复杂度分析：
 * 时间复杂度：
 * 空间复杂度：
 */
public class TestMethod20 {

    public static void main(String[] args) {

        String str = "+100";
        System.out.println(isNumeric(str.toCharArray(), 0));


    }

    private static boolean isNumeric(char[] str, int i) {
        if (str + "" == null)
            return false;

        boolean numeric = scanInteger(str, i);

        while (i < str.length) {

            if (str[i] == '.') {
                i++;
                numeric = scanUnsignedInteger(str, i) || numeric;

            }

            //接下来是数字的指数部分
            if (str[i] == 'e' || str[i] == 'E') {
                i++;
                numeric = numeric && scanInteger(str, i);
            }

        }
        return numeric && str[i] == '\0';

    }

    //扫描可能以表示正负的'+' '-'为起始的0~9数位（类似于一个可能带着正负符号的整数），用来匹配数值模式中的A C部分
    private static boolean scanInteger(char[] str, int i) {

        if ((str[i] == '+' || str[i] == '-'))
            i++;

        return scanUnsignedInteger(str, i);
    }

    //扫描字符串中0~9的数位（类似于一个无符号整数），可以用来匹配数值模式中的B部分
    private static boolean scanUnsignedInteger(char[] str, int i) {

        System.out.println("str的长度：" + str.length);

        char before = str[i];

        System.out.println("before:" + before);

        while (str[i] != '\0' && str[i] >= '0' && str[i] <= '9' && i < str.length)
            i++;

        //当str中存在若干0~9的数字时，返回true
        return true;
    }
}