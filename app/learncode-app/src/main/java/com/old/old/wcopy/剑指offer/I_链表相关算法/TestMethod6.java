package com.old.old.wcopy.剑指offer.I_链表相关算法;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

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
 * 方法一：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod6 {

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例：
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method_1(node1));
//        method_2(node1);
//        System.out.println();
//        method_3(node1);
    }

    /**
     * 反转单链表
     *
     * @param head 单链表的头节点
     */
    private static ListNode<Integer> method_1(ListNode<Integer> head) {
        ListNode<Integer> curr = head;
        ListNode<Integer> pre = null;
        ListNode<Integer> next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 递归
     * <p>
     * 先递归输出节点后面的节点，再输出该节点自身 （实质：调用系统的栈空间）
     *
     * @param head 单链表的头节点
     */
    private static void method_2(ListNode<Integer> head) {
        if (head != null) {
            if (head.next != null) {
                method_2(head.next);
            }
            System.out.print(head.value + " ");
        }
    }

    /**
     * 利用栈"先进后出"的特性，遍历整个单链表，将值放入到栈中，再从栈顶逐个输出
     *
     * @param head 单链表的头节点
     */
    private static void method_3(ListNode<Integer> head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.empty()) {
            System.out.print(stack.pop().value + " ");
        }
    }
}

