package com.old.old.wcopy.leetcode_剑指offer.A8_链表相关算法;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 求链表的中间节点。如果链表中的节点总数为奇数，则返回中间节点，
 * 如果节点总数为偶数，则返回中间两个节点的任意一个。
 * <p>
 * 解题思路：
 * 快慢两个指针，一个指针一次走一步走，另一个指针一次走两步。
 * 当快指针走到末尾时，慢指针刚好走到中间节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ22_2_链表的中间节点 {

    public static void main(String[] args) {
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例：
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printNode(method(node1), "链表的中间节点为");
        PrintUtils.getInstance().printListNode(node4);
        PrintUtils.getInstance().printNode(method(node4), "链表的中间节点为");
        PrintUtils.getInstance().printListNode(node6);
        PrintUtils.getInstance().printNode(method(node6), "链表的中间节点为");
    }

    /**
     * 快慢指针方法
     *
     * @param head 单链表的头节点
     * @return 返回链表的中间节点
     */
    private static ListNode<Integer> method(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}