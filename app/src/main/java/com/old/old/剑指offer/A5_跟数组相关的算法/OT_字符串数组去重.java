package com.old.old.剑指offer.A5_跟数组相关的算法;

import com.open.learncode.算法.base.PrintUtils;

import java.util.Arrays;

/**
 * 题目：
 * 在一维字符串数组中，删除重复的字符串。
 * <p>
 * 解题思路：
 * 先排序后删除
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(nlogn)，空间复杂度：O(nlogn)
 */
public class OT_字符串数组去重 {

    public static void main(String[] args) {
        String[] strArray = {"aaa", "bbb", "bbb", "ccc", "ddd", "ddd", "eee"};
        // 测试用例
        PrintUtils.getInstance().printArray(strArray);
        PrintUtils.getInstance().printArray(method(strArray));
    }

    /**
     * 删除数组中重复的字符串
     *
     * @param strArray 待输入的字符串数组
     * @return 返回去重后的字符串数组
     */
    private static String[] method(String[] strArray) {
        if (strArray == null || strArray.length <= 1) return strArray;

        // 先快速排序
        Arrays.sort(strArray);
        int tempLength = 1;
        for (int i = 1; i < strArray.length; i++) {
            // 注意这里不能用equals去比较，因为会导致空指针异常
            // 用==去比较，基本数据类型比较的是值
            if (strArray[i - 1] == strArray[i]) {
                strArray[i] = null;
            } else {
                tempLength++;
            }
        }
        String[] tempStrArray = new String[tempLength];
        for (int i = 0, j = 0; i < strArray.length; i++) {
            if (strArray[i] != null) {
                tempStrArray[j] = strArray[i];
                j++;
            }
        }
        return tempStrArray;
    }
}
