package com.old.old.剑指offer.A8_链表相关算法;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 删除链表中重复的节点：在一个排序的链表中，如何删除重复的节点？
 * 例如：1->2->3->3->4->4->5 删除重复的节点后变成 1->2->5
 * <p>
 * 解题思路：
 * 构建辅助头节点，遇到重复元素跳过，重新建立前一个节点与第一个不重复节点的连接
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ18_2_删除链表重复节点 {

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4_2 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node4_1 = new ListNode<Integer>(4, node4_2);
        ListNode<Integer> node3_2 = new ListNode<Integer>(3, node4_1);
        ListNode<Integer> node3_1 = new ListNode<Integer>(3, node3_2);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3_1);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例：
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method((node1)), "删除重复元素后的链表");
    }

    /**
     * 删除重复的节点
     *
     * @param head 头结点
     * @return 返回链表
     */
    private static ListNode<Integer> method(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode pre = pHead;
        ListNode curr = pHead.next;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return pHead.next;
    }
}