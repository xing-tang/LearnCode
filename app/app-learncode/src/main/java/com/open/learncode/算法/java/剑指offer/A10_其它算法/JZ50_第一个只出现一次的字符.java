package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import com.open.learncode.算法.base.PrintUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目：
 * 第一个只出现一次的字符：字符串中找到第一个只出现一次的字符，并返回它的位置，如果没有则返回-1。
 * <p>
 * 注意：
 * 从0开始计数
 * 需要区分大小写
 * 0 <= str 的长度 <= 10000，且字符串只有字母组成。
 * <p>
 * 示例：
 * 示例1：输入：str = "google"，输出：'4'。
 * 示例2：输入：str = "aa"，输出：-1。
 * 示例3：输入：str = ""，输出：-1。
 * <p>
 * 解题思路：
 * 哈希表
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(n)。
 * 力扣：https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class JZ50_第一个只出现一次的字符 {

    public static void main(String[] args) {
        // 测试用例
        String str1 = "googlez";
        String str2 = "AAAlaz";
        String str3 = "";
        PrintUtils.getInstance().print(solution(str1), "输出");
        PrintUtils.getInstance().print(solution(str2), "输出");
        PrintUtils.getInstance().print(solution(str3), "输出");
        System.out.println();
        PrintUtils.getInstance().print(solution2(str1), "输出");
        PrintUtils.getInstance().print(solution2(str2), "输出");
        PrintUtils.getInstance().print(solution2(str3), "输出");
    }

    /**
     * LinkedHashMap
     * 直接返回不重复的第一个元素的下标
     */
    private static int solution(String str) {
        if (str == null || str.length() <= 0) return -1;

        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (linkedHashMap.containsKey(key)) {
                linkedHashMap.put(key, -1);
            } else {
                linkedHashMap.put(key, i);
            }
        }
        for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
            if (entry.getValue() != -1) return entry.getValue();
        }

        return -1;
    }

    /**
     * HashMap
     * 遍历，找到不重复且最小的下标
     */
    public static int solution2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key))
                map.put(key, -1);
            else
                map.put(key, i);
        }
        int first = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int pos = entry.getValue();

            if (pos != -1 && pos < first)
                first = pos;
        }
        return first == s.length() ? -1 : first;
    }
}