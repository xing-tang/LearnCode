package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 字符转换：请实现一个函数，将"··Toady·is··a··VERY·good····day·"转换为"Toady·Is·A·Very·Good·Day········"，
 * 且要求时间复杂度为O(n)，空间复杂度为O(1)，无前导空格，单词中间仅有一个空格，每个单词首字母大写，其它字母小写。
 * <p>
 * 注意：
 * 空格在该平台是显示"小点"，数组是普通的非可变数组，转换前后数组长度保持不变。
 * <p>
 * 示例：
 * =======================================
 * 示例1：
 * 输入：{'.', '.', 'T', 'o', 'd', 'a', 'y', '.', 'i', 's', '.', '.', 'a', '.', '.', 'V', 'E', 'R', 'Y', '.', 'g', 'o', 'o', 'd', '.', '.', '.', '.', 'd', 'a', 'y', '.'}
 * 输出：{'T', 'o', 'd', 'a', 'y', '.', 'I', 's', '.', 'A', '.', 'V', 'e', 'r', 'y', '.', 'G', 'o', 'o', 'd', '.', 'D', 'a', 'y', '.', '.', '.', '.', '.', '.', '.', '.'}
 * =======================================
 * <p>
 * 解题思路：
 * 清楚字符含义，A=65，Z=90，a=97，z=122
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class OT_字符转换 {

    public static void main(String[] args) {
        // 测试用例
        char[] arr = {'.', '.', 'T', 'o', 'd', 'a', 'y', '.', 'i', 's', '.', '.', 'a', '.', '.'
                , 'V', 'E', 'R', 'Y', '.', 'g', 'o', 'o', 'd', '.', '.', '.', '.', 'd', 'a', 'y', '.'};
        PrintUtils.getInstance().printArray(solution(arr), "输出");
    }

    private static char[] solution(char[] arr) {
        if (arr == null || arr.length == 0) return arr;

        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 'A' && arr[i] <= 'Z')
                    || (arr[i] >= 'a' && arr[i] <= 'z')) {
                length++;
            }
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            if (temp != '.') {
                if (i == 0 || arr[i - 1] == '.') {
                    if (temp >= 'a' && temp <= 'z') {
                        temp = (char) (temp - ('a' - 'A'));
                    }
                    length++;
                } else {
                    if (temp >= 'A' && temp <= 'Z') {
                        temp = (char) (temp + ('a' - 'A'));
                    }
                }
                arr[index] = temp;
                index++;
            } else {
                if (i != 0 && arr[i - 1] != '.') {
                    arr[index] = temp;
                    index++;
                }
            }
        }
        for (int i = length - 1; i < arr.length; i++) {
            arr[i] = '.';
        }
        return arr;
    }
}

