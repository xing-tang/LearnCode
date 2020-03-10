package com.open.learncode.剑指offer;

/**
 * 题目：
 * 替换空格：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如：输入"We are happy."，则输出"We%20are%20happy."
 * <p>
 * 解题思路：
 * 替换空格，让%20替换空格
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n^2) 方法二：时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class TestMethod5 {

    public static void main(String[] args) {

        String str = "we are happy.";

        method_1(str);
        method_2(str);
    }




    /**
     * 从前往后替换空格
     *
     * 每次遇到空格时，把空格后面的所有字符都后移2字节.
     * @param str 输入的字符串
     */
    private static void method_1(String str) {

        if (str == null || str.length() <= 0) {
            return;
        }

        System.out.println("method_1 ： \n未替换空格时的字符串：" + str);
        StringBuffer outputBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                outputBuffer.append("%");
                outputBuffer.append("2");
                outputBuffer.append("0");
            } else {
                outputBuffer.append(str.charAt(i));
            }
        }
        System.out.println("替换后的字符串为：" + outputBuffer+"\n");


    }


    /**
     * 从后往前替换空格
     *
     * @param str 输入的字符串
     */
    public static void method_2(String str) {

        if (str == null || str.length() <= 0) {
            return;
        }

        // 字符串的初始长度
        int length = str.length();
        // 字符串替换后的长度
        int newLength = str.length() + getBlankNum(str) * 2;

        char[] tempArr = new char[newLength];
        // 将str复制到新的 tempArr 数组中
        System.arraycopy(str.toCharArray(), 0, tempArr, 0, str.toCharArray().length);
        int indexOfOriginal = length - 1;
        int indexOfNew = newLength - 1;
        System.out.print("method_1 ： \n未替换空格时的字符串:");
        printArray(str.toCharArray());

        while (indexOfOriginal >= 0 && indexOfOriginal != indexOfNew) {
            if (tempArr[indexOfOriginal] == ' ') {
                tempArr[indexOfNew--] = '0';
                tempArr[indexOfNew--] = '2';
                tempArr[indexOfNew--] = '%';
            } else {
                tempArr[indexOfNew--] = tempArr[indexOfOriginal];
            }
            indexOfOriginal--;  // 从后先前遍历
        }

        System.out.print("替换后的字符串为：");
        printArray(tempArr);
    }

    /**
     * 获取空格数
     * @param str 输入的字符串
     * @return 返回字符串的空格个数
     */
    private static int getBlankNum(String str) {
        int count = 0;   // 空格数
        for (int i = 0; i < str.length(); i++) {
            // 获取str中下标为i的元素，判断它是否为空格
            String tempStr = String.valueOf(str.charAt(i));
            if (tempStr.equals(" ")) {
                count++;
            }
        }
        return count;
    }

    /**
     * 打印数组
     * @param arr 输入的数组
     */
    public static void printArray(char[] arr) {
        for (char i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }


}

