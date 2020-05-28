package com.open.learncode.剑指offer.每日回顾.day_04;

/**
 * 题目：
 * 把数字翻译成字符串：给定一个数字，我们按照如下规则把它翻译成字符串：0翻译成"a"，1翻译成"b"，... ，
 * 11翻译成"l"，... ，25翻译成"z"。一个数字可能有多种翻译。例如，12258有5种不同的翻译，分别是
 * "bccfi"，"bwfi"，"bczi"，"mcfi"和"mzi"。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
 * <p>
 * 解题思路：
 * 动态规划
 * <p>
 * 复杂度分析：
 * 方法一、二：时间复杂度：O(n)  空间复杂度：O(n)【字符串s占了O（n)的额外空间】
 * 方法三：时间复杂度：O(n)  空间复杂度：O(1)
 * 【用求余运算num%10和求整运算num/10，可获取数字num的各位数字（获取顺序为个位、十位、百位…）
 * 因此，可通过求余和求整运算实现"从右向左"的遍历计算。而根据上述 “对称性” ，可知从右向左的计算是正确的。
 * 自此，字符串s的空间占用也被省去，空间复杂度从O(N)降至O(1)
 *
 */

public class TestMethod46 {

    public static void main(String[] args) {

        int num = 11258;
        System.out.println(method_1(num));
        System.out.println(method_2(num));
        System.out.println(method_3(num));

    }

    /**
     * 从左至右：
     *
     * @param num
     * @return
     */
    private static int method_1(int num) {
        //将int类型的数字 转换为 String类型的字符串
        String s = String.valueOf(num);
        //初始状态："无数字"和"第一位数字"的翻译方法数量均为1
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            //temp为字符串s包含[i-2,i)的子字符串
            String sub = s.substring(i - 2, i);
            int c = sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;

    }


    /**
     * 从右至左：
     *
     * @param num
     * @return
     */
    private static int method_2(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = s.length() - 2; i > -1; i--) {
            String sub = s.substring(i, i + 2);
            int c = sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    /**
     * 数字求余：
     *
     * @param num
     * @return
     */
    private static int method_3(int num){
        //初始状态："无数字"和"最后一位数字"的翻译方法数量均为1，x不赋值，y为数字num的最后一位数字
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            //去掉最后一位数
            num /= 10;
            //取数字num的最后一位数
            x = num % 10;
            //获得数字num最后两位数字组成的数
            int sub = 10 * x + y;
            int c = (sub >= 10 && sub <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

}