
package com.open.learncode.剑指offer.每日回顾.day_04;

import java.util.Stack;

/**
 * 题目：
 * 栈的压入、弹出序列：输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出序列。假设压入栈的所有数字均不相等。
 * 例如：序列{1,2,3,4,5}是某栈的压栈序列，序列{4,5,3,2,1}是该压栈序列对应
 * 的一个弹出序列，但是{4,3,5,1,2}就不可能是该压栈序列的弹出序列
 * <p>
 * 解题思路：
 * 利用辅助栈的特性，注意栈内数字不能相等
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)【栈】
 */
public class TestMethod31_1 {

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};

        System.out.println("该序列是否是该压栈序列的弹出序列：" + method(push, pop));
        System.out.println("该序列是否是该压栈序列的弹出序列：" + method(push, pop2));
    }

    /**
     * 辅助栈
     *
     * @param push 压入序列
     * @param pop  弹出序列
     * @return
     */
    private static boolean method(int[] push, int[] pop) {
        if (push == null || pop == null || push.length <= 0
                || pop.length <= 0 || push.length != pop.length)
            return false;

        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;//用于标识弹出序列位置
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            //如果栈不为空，且栈顶元素等于弹出序列中index指向的元素（该栈顶元素弹出）
            while (!stack.isEmpty() && stack.peek() == pop[index]) {
                stack.pop();
                index++;//弹出序列后移
            }
        }
        return stack.isEmpty();
    }
}

