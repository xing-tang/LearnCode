package com.open.learncode.剑指offer.test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：
 * 用两个队列实现栈：用两个队列实现一个栈。
 */
public class TestMethod9_2 {

    public static void main(String[] args) {

        QueueToStack<Integer> stack = new QueueToStack<>();

        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        System.out.println(stack.pop());

    }

    private static class QueueToStack<E> {
        Queue<E> queue1 = new ArrayDeque<>();
        Queue<E> queue2 = new ArrayDeque<>();

        public void push(E e) {

            //两个队列都为空，优先queue1
            if (queue1.isEmpty() && queue2.isEmpty()) {
                queue1.add(e);
                return;
            }

            if (queue1.isEmpty()) {
                queue1.add(e);
                return;
            }

            if (queue2.isEmpty()) {
                queue2.add(e);
                return;
            }

        }

        public E pop() {

            if (queue1.isEmpty() && queue2.isEmpty())
                return null;

            if (queue2.isEmpty()) {

                while (queue1.size() > 1)
                    queue2.add(queue1.poll());

                return queue1.remove();
            }

            if (queue1.isEmpty()) {
                while (queue2.size() > 1)
                    queue1.add(queue2.poll());

                return queue2.remove();
            }

            return null;
        }
    }

    private static void print(QueueToStack stack) {
        while (stack != null) {
            System.out.print(stack.pop() + " ");
        }
    }

}

