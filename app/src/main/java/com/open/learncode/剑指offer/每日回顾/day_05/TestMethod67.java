package com.open.learncode.剑指offer.每日回顾.day_05;

/**
 * 题目：
 * 写一个函数，实现把字符串转换成整数这个功能。不能使用api库函数等。
 * <p>
 * 解题思路：
 * 注意事项=>
 * (1)首部存在空格如何处理？
 * (2)符号位如何处理？
 * (3)非数字字符和数字字符如何处理？
 * (4)数字越界如何处理？
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod67 {

    public static void main(String[] args) {
        String str1 = null;
        String str2 = "  -42  hz";
        System.out.println(str1 + "=>转换输出的整数为：" + method(str1));
        System.out.println(str2 + "=>转换输出的整数为：" + method(str2));
    }

    /**
     * 有效字符串转整数
     *
     * @param str 待输入的字符
     * @return 返回转换的整数，-1代表当前的字符串无效
     */
    public static int method(String str) {
        // 鲁棒性
        if (str == null || str.trim().length() <= 0) return 0;
        // 字符转数组
        char[] chars = str.toCharArray();
        // 当前数
        int res = 0;
        // 当前的下标
        int index = 0;
        // 标识符号，约定1位正好，-1位符号，初始化默认为正好
        int flag = 1;
        // 处理前面可能存在的的空格
        while (chars[index] == ' ') index++;
        // 处理符号位
        if (chars[index] == '-') flag = -1;
        // 处理符号位后更新索引角标
        if (chars[index] == '+' || chars[index] == '-') index++;
        for (int i = index; i < chars.length; i++) {
            // 不在0至9范围内，直接break处理
            if (chars[i] < '0' || chars[i] > '9') break;
            // 处理整数越界问题
            if (res > Integer.MAX_VALUE || (res == Integer.MIN_VALUE && chars[i] > '7')) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[i] - '0');
        }
        return flag > 0 ? res : -res;
    }

}
