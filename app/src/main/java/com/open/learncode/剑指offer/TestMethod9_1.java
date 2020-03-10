package com.open.learncode.剑指offer;

import java.util.Stack;

/**
 * 题目：
 * 用两个栈实现队列：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
 * 和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能
 * <p>
 * 解题思路：
 * 添加操作：直接添加
 * 删除操作：栈是先进后出，队列是先进先出。要删除的节点在栈底
 * <p>
 * 复杂度分析：
 * 添加：时间复杂度：O(1) 空间复杂度：O(1)
 * 删除：时间复杂度：O(n) 空间复杂度：O(1)
 */
public class TestMethod9_1 {

    static class StackToQueue<E> {

        Stack<E> stack1 = new Stack<>();
        Stack<E> stack2 = new Stack<>();
    }


    private static StackToQueue<String> queue;
    private static Stack stack1;
    private static Stack stack2;

    public static void main(String[] args) {

        queue = new StackToQueue<>();
        stack1 = queue.stack1;
        stack2 = queue.stack2;
        appendTail("a");
        appendTail("b");
        appendTail("c");
        appendTail("d");
        appendTail("e");
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());

    }


    private static void appendTail(String e) {

        //无论stack2是否为空，总是考虑stack1
        stack1.push(e);

    }

    private static String deleteHead() {

        //当stack2为空，stack1不为空时
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());

            }
        }

        //stack2为空，（且stack1也为空）时
        if (stack2.size() == 0) {
            return "队列为空";
        }

        //satck2不为空，stack1为空时，直接pop
        String head = (String) stack2.pop();
        return head;
    }

}

