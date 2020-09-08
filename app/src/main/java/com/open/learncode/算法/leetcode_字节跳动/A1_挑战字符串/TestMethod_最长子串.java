package com.open.learncode.算法.leetcode_字节跳动.A1_挑战字符串;


import com.open.learncode.算法.base.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 解题思路：
 * 双指针+哈希表
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(N)，空间复杂度O(1)
 */
public class TestMethod_最长子串 {

    public static void main(String[] args) {
        // 测试用例：
//        String str = " ";
//        String str = null;
//        String str = "bbbbb";
//        String str = "pwwkew";
        String str = "abcabcab";

        PrintUtils.getInstance().print(str, "原字符串：");
        PrintUtils.getInstance().print(method(str), "最长的不含重复字符的子字符串的长度是：");
    }

    public static int method(String str) {
        if (str == null || str.length() <= 0) return 0;
        if (str.length() == 1) return 1;

        Map<Character, Integer> hashMap = new HashMap<>();
        int i = -1, maxLength = 0;
        for (int j = 0; j < str.length(); j++) {
            if (hashMap.containsKey(str.charAt(j))) {
                i = Math.max(i, hashMap.get(str.charAt(j)));
            }
            hashMap.put(str.charAt(j), j);
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }
}
