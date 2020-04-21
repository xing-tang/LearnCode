package com.open.learncode.剑指offer;

import java.util.ArrayDeque;
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
 * 添加：时间复杂度：O(1) 空间复杂度：O(1)
 * 删除：时间复杂度：O(n) 空间复杂度：O(1)
 */
public class TestMethod9_2 {

    public static void main(String[] args) {

        QueueToStack stack = new QueueToStack<>();
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

    static class QueueToStack<E> {

        public Queue<E> queue1 = new ArrayDeque<>();
        public Queue<E> queue2 = new ArrayDeque<>();

        //添加操作：
        public void push(E e) {

            //两个队列为空时，优先考虑queue1
            if (queue1.isEmpty() && queue2.isEmpty()) {
                queue1.add(e);
                return;
            }

            //如果queue1为空，queue2有数据，直接放入queue2
            if (queue1.isEmpty()) {
                queue2.add(e);
                return;
            }

            //如果queue2为空，queue1有数据，直接放入queue1
            if (queue2.isEmpty()) {
                queue1.add(e);
                return;
            }
        }

        //删除操作
        public E pop() {
            //两个队列为空时，直接抛出异常
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return null;
            }

            //如果queue1为空，将queue2中的元素依次加入到 queue1,留下最后一个元素 弹出
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    /**
                     * Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。
                     * 在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null 。
                     */
                    queue1.add(queue2.poll());
                }
                return queue2.remove();
            }

            //如果queue2为空，将queue1中的元素依次加入到 queue2, 留下最后一个元素 弹出
            if (queue2.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.add(queue1.poll());
                }
                return queue1.remove();
            }

            return null;
        }

    }

}

