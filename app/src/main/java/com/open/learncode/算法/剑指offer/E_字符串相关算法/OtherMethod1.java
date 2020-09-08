package com.open.learncode.算法.剑指offer.E_字符串相关算法;

import com.open.learncode.算法.base.PrintUtils;

import java.util.Arrays;

/**
 * 题目：
 * 在一个字符串中，删除重复的字符。
 * <p>
 * 解题思路：
 * 先排序后删除
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(nlogn)，空间复杂度：O(nlogn)
 */
public class OtherMethod1 {

    public static void main(String[] args) {
        String str = "abbcddeff";
        // 测试用例
        PrintUtils.getInstance().print(str,"打印原字符串");
//        PrintUtils.getInstance().print(method(str));
    }

//    /**
//     * 删除字符串中重复的字符
//     *
//     * @param str 待输入的字符串
//     * @return 返回去重后的字符串
//     */
//    private static String method(String str) {
//        if (str == null || str.length() <= 1) return str;
//
//        char[] chars = str.toCharArray();
//        // 先快速排序
//        Arrays.sort(chars);
//        int tempLength = 1;
//        for (int i = 1; i < chars.length; i++) {
//            // 注意这里不能用equals去比较，因为会导致空指针异常
//            // 用==去比较，基本数据类型比较的是值
//            if (chars[i - 1] == chars[i]) {
//                chars[i] = null;
//            } else {
//                tempLength++;
//            }
//        }
//        String[] tempStrArray = new String[tempLength];
//        for (int i = 0, j = 0; i < chars.length; i++) {
//            if (chars[i] != null) {
//                tempStrArray[j] = strArray[i];
//                j++;
//            }
//        }
//        return tempStrArray;
//    }
}
