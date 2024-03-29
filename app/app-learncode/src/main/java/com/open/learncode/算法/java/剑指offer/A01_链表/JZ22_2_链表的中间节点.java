package com.open.learncode.算法.java.剑指offer.A01_链表;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 求链表的中间节点。如果链表中的节点总数为奇数，则返回中间节点，
 * 如果节点总数为偶数，则返回中间两个节点的任意一个。
 * <p>
 * 注意：
 * <p>
 * 示例：
 * 示例1：给定一个链表: 1->2->3->4->5，返回 3。
 * 示例2：给定一个链表: 1->2->3->4->5，返回 4。
 * <p>
 * 解题思路：
 * 快慢两个指针，一个指针一次走一步走，另一个指针一次走两步。
 * 当快指针走到末尾时，慢指针刚好走到中间节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ22_2_链表的中间节点 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> headNode1 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        PrintUtils.getInstance().printListNode(headNode1);
        PrintUtils.getInstance().printNode(method(headNode1), "链表的中间节点为");
        ListNode<Integer> headNode2 = ListNode.createListNode(new int[]{1, 2, 3, 4, 5, 6});
        PrintUtils.getInstance().printListNode(headNode2);
        PrintUtils.getInstance().printNode(method(headNode2), "链表的中间节点为");
    }

    private static ListNode<Integer> method(ListNode<Integer> head) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null || head.next == null) return head;

        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}