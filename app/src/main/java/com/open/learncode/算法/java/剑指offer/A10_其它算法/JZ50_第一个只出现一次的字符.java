package com.open.learncode.算法.java.剑指offer.A10_其它算法;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目：
 * 第一个只出现一次的字符：在字符串中找到第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'
 * <p>
 * 注意：
 * 0 <= s 的长度 <= 50000，考虑中文等特殊情况。
 * <p>
 * 示例：
 * 示例1：输入：s = "abaccdeff"，输出：'b'。
 * 示例2：输入：s = ""，输出：' '。
 * <p>
 * 解题思路：
 * 哈希表
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */

public class JZ50_第一个只出现一次的字符 {

    public static void main(String[] args) {
        // 测试用例
        String str = "abaccdeff";
//        String str = "adabcceff";
//        String str = "";
        System.out.println(str + "中第一个只出现一次的字符为：" + method_1(str));
        System.out.println(str + "中第一个只出现一次的字符为：" + method_2(str));
    }

    /**
     * 哈希表：
     * 【map存入和取出数据顺序不一致，这叫无序
     * 存入和取出数据顺序一致，这叫有序】
     * <p>
     * 时间复杂度：O(n)【n为字符串s的长度；需要遍历s两轮，使用O(2n)；HashMap查找操作的复杂度为O(1)】
     * 空间复杂度：O(n)【将字符串转换为数组，需要O(n)的额外空间；HashMap需存储个字符的键值对，使用O(n)大小的额外空间。】
     *
     * @param s
     * @return
     */
    private static char method_1(String s) {

        //鲁棒性
        if (s == null || s.length() <= 0)
            return ' ';

        HashMap<Character, Boolean> map = new HashMap<>();

        //把字符串转换为char数组
        char[] str = s.toCharArray();

        //遍历char数组，往map里存入键值对 char字符：true/false，
        // 若map中第一次存入该键，其值为true；若重复存入该键，修改其值为false
        for (char c : str)
            map.put(c, !map.containsKey(c));

        //顺序遍历char数组【满足第一个】，当map中其存入的值为true【满足第一次】，返回
        for (char c : str)
            if (map.get(c)) return c;


        //否则，返回空
        return ' ';
    }

    /**
     * 有序哈希表：
     * 【map存入和取出数据顺序不一致，这叫无序
     * 存入和取出数据顺序一致，这叫有序】
     * <p>
     * 时间复杂度：O(n)【n为字符串s的长度；需要遍历s两轮，使用O(n)；HashMap查找操作的复杂度为O(1)】
     * 空间复杂度：O(n)【将字符串转换为数组，需要O(n)的额外空间；HashMap需存储个字符的键值对，使用O(n)大小的额外空间。】
     * 在哈希表的基础上，有序哈希表中的键值对是"按照插入顺序排序"的。基于此，可通过遍历有序哈希表，实现搜索首个“数量为1的字符”。
     * 哈希表是"去重"的，即哈希表中键值对数量 ≤ 字符串s的长度。
     * 因此，相比于方法一，方法二减少了第二轮遍历的循环次数。当字符串很长（重复字符很多）时，方法二则效率更高。
     *
     * @param s
     * @return
     */
    private static char method_2(String s) {
        //鲁棒性
        if (s == null || s.length() <= 0) return ' ';

        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] str = s.toCharArray();
        for (char c : str) map.put(c, !map.containsKey(c));
        for (Map.Entry<Character, Boolean> d : map.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }
}