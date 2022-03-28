package com.open.learncode.算法.java.leetcode.A1_栈与队列;

import com.open.learncode.算法.base.PrintUtils;

import java.util.Stack;

/**
 * 题目：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，
 * 并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)。
 * <p>
 * 复杂度分析：
 * 时间复杂度O(1)，空间复杂度O(n)
 */
public class JZ30_包含min函数的栈 {

    public static void main(String[] args) {
        // 测试示例
        Solution solution = new Solution();
        // 测试数据 3,5,2,6
        solution.push(3);
        PrintUtils.getInstance().print(solution.min(), "最小元素");
        solution.push(5);
        PrintUtils.getInstance().print(solution.min(), "最小元素");
        solution.push(2);
        PrintUtils.getInstance().print(solution.min(), "最小元素");
        solution.push(6);
        PrintUtils.getInstance().print(solution.min(), "最小元素");
        PrintUtils.getInstance().print(solution.top(), "出栈");
        solution.pop();
        PrintUtils.getInstance().print(solution.min(), "最小元素");
        PrintUtils.getInstance().print(solution.top(), "出栈");
        solution.pop();
        PrintUtils.getInstance().print(solution.min(), "最小元素");
        PrintUtils.getInstance().print(solution.top(), "出栈");
        solution.pop();
        PrintUtils.getInstance().print(solution.min(), "最小元素");
        PrintUtils.getInstance().print(solution.top(), "出栈");
        solution.pop();
        PrintUtils.getInstance().print(solution.min(), "最小元素");
    }

    public static class Solution {

        private Stack<Integer> defStack = null;
        private Stack<Integer> minStack = null;

        public Solution() {
            defStack = new Stack();
            minStack = new Stack();
        }

        public void push(int node) {
            defStack.push(node);
            if (minStack.isEmpty() || minStack.peek() >= node) {
                minStack.push(node);
            }
        }

        public void pop() {
            if (!defStack.isEmpty()) {
                if (!minStack.isEmpty() && defStack.pop() == minStack.peek()) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            return defStack.isEmpty() ? -1 : defStack.peek();
        }

        public int min() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }
}

