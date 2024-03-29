package com.old.old.delete;

import java.util.Stack;

/**
 * 题目：
 * 从尾到头打印链表：输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 * 例如：输入1->2->3->4->5，输出5->4->3->2->1。
 * <p>
 * 解题思路：
 * 利用栈（先进后出），递归，反转链表（改变链表）
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod6 {

    public static class ListNode<E> {
        public E value;
        public ListNode next;
        public ListNode(E value) {
            this.value = value;
        }
        public ListNode(E value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

//        method_1(node1);
//        System.out.println();
//        method_2(node1);
//        System.out.println();
        method_3(node1);
    }

    /**
     * 利用栈"先进后出"的特性，遍历整个单链表，将值放入到栈中，再从栈顶逐个输出
     *
     * @param head 单链表的头节点
     */
    private static void method_1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * 递归
     * <p>
     * 先递归输出节点后面的节点，再输出该节点自身 （实质：调用系统的栈空间）
     *
     * @param head 单链表的头节点
     */
    private static void method_2(ListNode head) {
        if (head != null) {
            if (head.next != null) {
                method_2(head.next);
            }
            System.out.print(head.value + " ");
        }
    }

    /**
     * 反转单链表
     *
     * @param head 单链表的头节点
     */
    private static void method_3(ListNode head) {
        ListNode<Integer> curr = head;
        ListNode<Integer> pre = null;
        ListNode<Integer> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        while (pre != null) {
            System.out.print(pre.value + " ");
            pre = pre.next;
        }
    }
}

