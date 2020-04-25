package com.open.learncode.剑指offer.test;

import com.open.learncode.java.stack.Stack;

/**
 * 题目：
 * 用两个栈实现队列：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数push
 * 和pop，分别完成在队列尾部插入节点和在队列头部删除节点的功能
 */
public class TestMethod9_1 {

    public static void main(String[] args) {

        StackToQueue<Integer> queue = new StackToQueue();

        System.out.println(queue.pop());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }

    private static class StackToQueue<E> {

        Stack<E> stack1 = new Stack<>();
        Stack<E> stack2 = new Stack<>();

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

