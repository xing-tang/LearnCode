package com.open.learncode.算法.java.剑指offer.A08_位运算;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * Ip地址转换：实现一个函数将ip地址转换为整数。
 * <p>
 * 注意：
 * 取值范围在0-255。
 * <p>
 * 示例：
 * "0.0.0.0" -> 0
 * "0.0.0.1" -> 1
 * "0.0.0.255" -> 255
 * "0.0.1.0" -> 256
 * "192.168.3.1" -> ？
 * <p>
 * 解题思路：
 * 找规律、位移操作符号。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)。
 * 空间复杂度：O(1)。
 */
public class OT_Ip地址转换 {

    public static void main(String[] args) {
        // 测试用例
        PrintUtils.getInstance().print(solution("0.0.0.0"));
        PrintUtils.getInstance().print(solution("0.0.0.1"));
        PrintUtils.getInstance().print(solution("0.0.0.255"));
        PrintUtils.getInstance().print(solution("0.0.1.0"));
        PrintUtils.getInstance().print(solution("0.1.0.0"));
        PrintUtils.getInstance().print(solution("192.168.3.1"));
    }

    private static long solution(String str) {
        String[] strArray = str.split("\\.");
        long res = 0;
        if (strArray.length == 4) {
            for (int i = 0; i < strArray.length; i++) {
                int temp = Integer.parseInt(strArray[i]);
                res = (res << 8) + temp;
            }
        }
        return res;
    }
}