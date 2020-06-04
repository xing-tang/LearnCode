package com.open.learncode.剑指offer.每日回顾.day_01;

import android.support.annotation.NonNull;

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
 * 方法一、二、三：时间复杂度：O(n)
 * 方法一、二：空间复杂度：O(n) 方法三：O(1)
 */
public class TestMethod6 {

    /**
     * 内部类：链表节点
     */
    public static class ListNode<E> {

        public E value;//节点值
        public ListNode next;//指针，指向下一个节点

        public ListNode(E value) {
            this.value = value;
        }

        public ListNode(E value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        @NonNull
        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        //创建带头节点的单链表
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        method_1(node1);
        System.out.println();
        method_2(node1);
        System.out.println();
        method_3(node1);
    }

    private static void method_1(ListNode<Integer> root) {
        if (root != null) {
            method_1(root.next);
            System.out.print(root.value + " ");
        }
    }

    private static void method_2(ListNode<Integer> root) {
        if (root == null) return;

        Stack<ListNode<Integer>> stack = new Stack<>();
        ListNode<Integer> temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void method_3(ListNode<Integer> root) {
        if (root == null) return;

        ListNode<Integer> pre = null;
        ListNode<Integer> cur = root;
        ListNode<Integer> next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre != null) {
            System.out.print(pre.value + " ");
            pre = pre.next;
        }

    }


}

