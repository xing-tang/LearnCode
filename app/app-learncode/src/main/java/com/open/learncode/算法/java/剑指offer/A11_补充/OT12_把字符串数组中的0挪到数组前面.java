package com.open.learncode.算法.java.剑指offer.A11_补充;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 把字符串数组中的0挪到数组前面：把字符串数组中的'0'挪到数组前面其他字符顺序不变，给出时间空间复杂度。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class OT12_把字符串数组中的0挪到数组前面 {

    public static void main(String[] args) {
        // 测试用例
        String[] str = new String[]{"1", "a", "0", "0", "2", "0", "98"};
        PrintUtils.getInstance().printArray(solution(str));
    }

    public static String[] solution(String[] strArr) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        int j = -1;
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i].equals("0")) {
                if (j == -1) j = i;
            } else {
                if (j != -1) {
                    String temp = strArr[j];
                    strArr[j] = strArr[i];
                    strArr[i] = temp;
                    j--;
                }
            }
        }
        return strArr;
    }
}
