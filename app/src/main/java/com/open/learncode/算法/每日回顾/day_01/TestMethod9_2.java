package com.open.learncode.算法.每日回顾.day_01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 用两个队列实现栈：用两个队列实现一个栈。
 * <p>
 * 解题思路：
 * 添加操作：分情况添加
 * 删除操作：栈是先进后出，队列是先进先出，队头删除节点，队尾添加节点。要删除的元素在队尾
 * <p>
 * 复杂度分析：
 * 添加：时间复杂度：O(1) 空间复杂度：O(n)
 * 删除：时间复杂度：O(n) 空间复杂度：O(n)
 */
public class TestMethod9_2 {

    public static void main(String[] args) {
        // 入队A、B、C、D，出队A、B，入队E、F，出队...
        // 运行结果：null、D、C、F、E、B、A
        QueueToStack<String> stack = new QueueToStack<>();
        System.out.println(stack.pop());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("E");
        stack.push("F");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static class QueueToStack<E> {
        private Queue<E> queue1 = new LinkedList<E>();
        private Queue<E> queue2 = new LinkedList<E>();

        private void push(E value) {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                queue1.offer(value);
            } else if (!queue1.isEmpty()) {
                queue1.offer(value);
            } else {
                queue2.offer(value);
            }
        }

        private E pop() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return null;
            }
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            }
            if (queue2.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            }
            return null;
        }
    }
}

