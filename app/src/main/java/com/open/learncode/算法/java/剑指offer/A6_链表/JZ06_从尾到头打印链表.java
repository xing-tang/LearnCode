package com.open.learncode.算法.java.剑指offer.A6_链表;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 从尾到头打印链表：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 * <p>
 * 注意：
 * 0 <= 链表长度 <= 10000。
 * <p>
 * 示例：
 * 示例：输入1->2->3->4->5，输出5->4->3->2->1。
 * <p>
 * 解题思路：
 * 反转链表（改变链表）。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ06_从尾到头打印链表 {

    public static void main(String[] args) {
        // 测试用例
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        PrintUtils.getInstance().printListNode(solution(head), "输出");
    }

    private static ListNode<Integer> solution(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

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
}

