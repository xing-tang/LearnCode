package com.open.learncode.算法.java.nowcoder;

import com.open.learncode.算法.base.PrintUtils;

import java.util.Stack;

/**
 * 题目:
 * 用两个栈来实现一个队列，完成n次在队列尾部插入整数(push)和在队列头部删除整数(pop)的功能。
 * 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 * <p>
 * 数据范围：
 * n <= 1000
 * <p>
 * 复杂度分析：
 * 时间复杂度O(1)，空间复杂度O(n)
 */
public class JZ09_1_用两个栈实现队列 {

    public static void main(String[] args) {
        // 测试示例
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        PrintUtils.getInstance().print(solution.pop());
        PrintUtils.getInstance().print(solution.pop());
    }

    private static class Solution {
        private Stack<Integer> inStack = null;
        private Stack<Integer> outStack = null;

        public Solution() {
            inStack = new Stack<Integer>();
            outStack = new Stack<Integer>();
        }

        public void push(int node) {
            inStack.push(node);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.isEmpty() ? -1 : outStack.pop();
        }
    }
}

