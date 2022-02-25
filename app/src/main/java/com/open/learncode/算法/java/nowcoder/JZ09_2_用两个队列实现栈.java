package com.open.learncode.算法.java.nowcoder;

import java.util.ArrayDeque;
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
public class JZ09_2_用两个队列实现栈 {

    public static void main(String[] args) {
        // 测试用例
        // 入队A、B、C、D，出队A、B，入队E、F，出队...
        // 运行结果：null、D、C、F、E、B、A
        Solution<String> stack = new Solution<String>();
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

    private static class Solution<E> {
        private Queue<E> queue1 = new ArrayDeque<>();
        private Queue<E> queue2 = new ArrayDeque<>();

        // 添加操作：
        private void push(E e) {
            // 两个队列为空时，优先考虑queue1
            if (queue1.isEmpty() && queue2.isEmpty()) {
                queue1.offer(e);
            } else if (queue1.isEmpty()) {// 如果queue1为空，queue2有数据，直接放入queue2
                queue2.offer(e);
            } else if (queue2.isEmpty()) {//如果queue2为空，queue1有数据，直接放入queue1
                queue1.offer(e);
            }
        }

        // 删除操作
        private E pop() {
            // 两个队列为空时，直接抛出异常
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return null;
            }
            // 如果queue1为空，将queue2中的元素依次加入到 queue1,留下最后一个元素 弹出
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    /**
                     * Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。
                     * 在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null 。
                     */
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            }
            // 如果queue2为空，将queue1中的元素依次加入到 queue2, 留下最后一个元素 弹出
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