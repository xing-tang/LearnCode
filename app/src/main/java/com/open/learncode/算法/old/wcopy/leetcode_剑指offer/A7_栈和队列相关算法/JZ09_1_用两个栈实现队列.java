package com.open.learncode.算法.old.wcopy.leetcode_剑指offer.A7_栈和队列相关算法;

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
 * 添加：时间复杂度：O(1)，空间复杂度：O(n)
 * 删除：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ09_1_用两个栈实现队列 {

    public static void main(String[] args) {
        // 入栈a、b、c，出栈c，入栈d，出栈d，入栈e、出栈...
        // 运行结果：null、a、b、c、d、e、null
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

    private static class StackToQueue<E> {
        private Stack<E> stack1 = new Stack<>();
        private Stack<E> stack2 = new Stack<>();

        // 添加操作：直接往stack1中压入数据
        private void push(E e) {
            stack1.push(e);
        }

        // 删除操作：把stack1的数据一次弹出，再压入stack2，这时，stack1栈底的元素就跑到了stack2的栈顶
        private E pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? null : stack2.pop();
        }
    }
}

