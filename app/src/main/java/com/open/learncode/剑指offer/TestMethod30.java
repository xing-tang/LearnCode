package com.open.learncode.剑指offer;


import java.util.Stack;

/**
 * 题目：
 * 包含min函数的栈：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数
 * 在该栈中，调用min push 及 pop的时间复杂度都为O(1)
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod30 {

    public static void main(String[] args) {
        Stack_1 stack1 = new Stack_1();
        Stack_2 stack2 = new Stack_2();
        Stack_3 stack3 = new Stack_3();
        // 测试数据 3,5,2,6
        stack1.pop();
        stack2.pop();
        stack3.pop();
    }

    /**
     * 利用两个栈实现
     */
    public static class Stack_1 {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public Stack_1() {
            stack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int value) {
            stack.push(value);
            if (!minStack.isEmpty()) {
                int top = minStack.peek();
                //小于的时候才入栈
                if (value <= top) {
                    minStack.push(value);
                }
            } else {
                minStack.push(value);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            int pop = stack.pop();
            int top = minStack.peek();
            if (pop == top) minStack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    /**
     * 利用栈最小值实现
     */
    public static class Stack_2 {

        private Stack<Integer> stack;
        private int minValue = Integer.MAX_VALUE;

        public Stack_2() {
            stack = new Stack<Integer>();
        }

        public void push(int value) {
            //当前值更小
            if (value <= minValue) {
                //将之前的最小值保存
                stack.push(minValue);
                //更新最小值
                minValue = value;
            }
            stack.push(value);
        }

        public void pop() {
            if (stack.isEmpty()) return;

            int pop = stack.pop();
            //如果弹出的值是最小值，那么将下一个元素更新为最小值
            if (pop == minValue) {
                minValue = stack.pop();
            }
        }

        public int peek() {
            return stack.peek();
        }


        public int min() {
            return minValue;
        }
    }

    /**
     * 利用栈差值实现
     */
    public static class Stack_3 {

        private Stack<Integer> stack;
        private int minValue;

        public Stack_3() {
            stack = new Stack<Integer>();
        }

        public void push(int value) {
            if (stack.isEmpty()) {
                minValue = value;
                stack.push(value - minValue);
            } else {
                stack.push(value - minValue);
                if (value < minValue) minValue = value;
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            int pop = stack.pop();
            //弹出的是负值，要更新 min
            if (pop < 0) {
                minValue = minValue - pop;
            }
        }

        public int peek() {
            long top = stack.peek();
            if (top < 0) { //负数的话，出栈的值保存在 min 中
                return (int) (minValue);
            } else { //出栈元素加上最小值即可
                return (int) (top + minValue);
            }
        }


        public int min() {
            return minValue;
        }
    }
}

