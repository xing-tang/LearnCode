package com.open.learncode.算法.java.剑指offer.A9_模拟;

/**
 * 题目：
 * 把字符串转换成整数：写一个函数，实现把字符串转换成整数这个功能。不能使用api库函数等。
 * <p>
 * 解题思路：
 * 注意事项=>
 * (1)首部存在空格如何处理？
 * (2)符号位如何处理？
 * (3)非数字字符和数字字符如何处理？
 * (4)数字越界如何处理？
 * <p>
 * 1、首部空格： 删除之即可
 * 2、符号位： 三种情况，即 '+' , '−' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可
 * 3、非数字字符： 遇到首个非数字的字符时，应立即返回
 * 数字字符：
 * ①字符转数字： “此数字的ASCII码” 与 “0的ASCII码” 相减即可；
 * ②字符拼接： 若从左向右遍历数字，设当前位字符为c ，当前位数字为x ，数字结果为res ，则数字拼接公式为：
 * res = 10*res + x   ，  x = ASCII(c) - ASCII('0'）
 * 4、数字越界处理：返回的数值范围应在 [-2^31，2^31-1]
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)【其中n为字符串长度，需线性遍历字符串】
 * 空间复杂度：O(n)【删除首尾空格后需建立新字符串，最差情况下占用O(n)额外空间】
 */
public class JZ67_把字符串转换成整数 {

    public static void main(String[] args) {
        String str1 = null;
        String str2 = "  -42  hz";
        System.out.println(str1 + "=>转换输出的整数为：" + method(str1));
        System.out.println(str2 + "=>转换输出的整数为：" + method(str2));

        String str = " -42hi";
//        String str = "      ";
//        String str =null;
        System.out.println("字符串转换成的整数位：" + method(str));
        System.out.println("是否为有效输入：" + valid);
    }

    //是否为有效输入的标记，借助此辨别返回的0是，非法输入时【str为null 或者 长度为0 或者 全部为空格】的返回，还是输入"0"时的返回
    private static boolean valid = false;

    /**
     * 有效字符串转整数
     *
     * @param str 待输入的字符
     * @return 返回转换的整数，-1代表当前的字符串无效
     */
    public static int method(String str) {
        // 鲁棒性
        if (str == null || str.length() <= 0)
            return 0;

        valid = true;

        // 字符转数组
        char[] chars = str.toCharArray();
        // 当前数
        int res = 0;
        // 当前的下标
        int index = 0;
        // 标识符号，约定1为正符号位，-1为负符号为，初始化默认为正
        int flag = 1;

        // 处理前面可能存在的的空格
        while (chars[index] == ' ')
            index++;

        if(index==chars.length-1){
            valid=false;
            return 0;
        }

        // 处理符号位
        if (chars[index] == '-')
            flag = -1;

        // 处理符号位后更新索引角标
        if (chars[index] == '+' || chars[index] == '-')
            index++;

        for (int i = index; i < chars.length; i++) {

            // 不在0至9范围内，直接break处理
            if (chars[i] < '0' || chars[i] > '9')
                break;

            // 处理整数越界问题
            //拼接结果越界的两种情况：
            //①res已经越界，这时，10*res一定超最大值
            //②res==边界，但是后面一位数字c[j]>7，则res*10+c[j]一定超最大值
            if (res > Integer.MAX_VALUE || (res == Integer.MIN_VALUE && chars[i] > '7')) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (chars[i] - '0');
        }
        return flag > 0 ? res : -res;

    }

}
