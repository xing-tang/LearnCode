package com.open.learncode.java.leetcode;


import com.open.learncode.java.stack.Stack;

/**
 * 3.无重复字符的最长子串
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Let_3 {

    public String code;

    public static void main(String[] args) {
        Let_3 lte = new Let_3();
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        System.out.println(test1 + "=>无重复字符的最长子串=" + lte.lengthOfLongestSubstring(test1));
        System.out.println(test2 + "=>无重复字符的最长子串=" + lte.lengthOfLongestSubstring(test2));
        System.out.println(test3 + "=>无重复字符的最长子串=" + lte.lengthOfLongestSubstring(test3));
    }

    private int lengthOfLongestSubstring(String s) {
        int any = 0;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i) + "");
                any++;
            } else {
                String temp = stack.peek();
                String temp2 = s.charAt(i) + "";
                if (!temp.equals(temp2)) {
                    stack.push(s.charAt(i) + "");
                    any++;
                } else {
                    stack.clear();

                    any = 0;
                    stack.push(s.charAt(i) + "");
                    any++;
                }
            }
        }
        return any;
    }

}


