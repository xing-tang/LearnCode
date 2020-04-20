package com.open.learncode.剑指offer;

import java.util.Stack;

/**
 * 题目：
 * 用两个栈实现队列：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数push
 * 和pop，分别完成在队列尾部插入节点和在队列头部删除节点的功能
 * <p>
 * 解题思路：
 * 添加操作：直接添加
 * 删除操作：栈是先进后出，队列是先进先出。要删除的节点在栈底
 * <p>
 * 复杂度分析：
 * 添加：时间复杂度：O(1)，空间复杂度：O(1)
 * 删除：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod9_1 {

    public static void main(String[] args) {
        StackToQueue<String> queue = new StackToQueue<String>();
        System.out.println(queue.pop());
        queue.push("a");
        queue.push("b");
        queue.push("c");
        System.out.println(queue.pop());
        queue.push("d");
        System.out.println(queue.pop());
        queue.push("e");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    static class StackToQueue<E> {

        public Stack<E> stack1 = new Stack<>();
        public Stack<E> stack2 = new Stack<>();

        public void push(E e) {
            stack1.push(e);
        }

        public E pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? null : stack2.pop();
        }

    }


}

