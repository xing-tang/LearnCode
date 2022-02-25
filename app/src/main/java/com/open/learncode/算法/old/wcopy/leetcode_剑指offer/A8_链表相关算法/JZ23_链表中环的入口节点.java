package com.open.learncode.算法.old.wcopy.leetcode_剑指offer.A8_链表相关算法;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 链表中环的入口节点：如果一个链表中包含环，如何找出环的入口节点？
 * 例如：在如图所示的链表中，环的入口节点是节点3
 * * * * ----------
 * * * * | * * *  |
 * * * * ↓ * * *  |
 * 1->2->3->4->5->6
 * <p>
 * 解题思路：
 * 1、快慢两指针，快指针一次向前移动两步，慢指针一次向前移动一步，直到它们相遇，相遇的节点就是环中的一节点
 * 2、得出环的节点总数k
 * 3、一前一后指针，一指针先向前走k步，之后，两指针以形同的速度向前移动，直到它们相遇，相遇的节点就是环的入口节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ23_链表中环的入口节点 {

    public static void main(String[] args) {
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例
        node6.next = node3;
//        node6.next = node6;
        PrintUtils.getInstance().printNode(method(node1), "该链表环的入口节点为");
    }

    /**
     * 快慢指针
     *
     * @param head 链表头结点
     * @return 返回链表环入口节点
     */
    public static ListNode<Integer> method(ListNode<Integer> head) {
        if (head == null) return null;

        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}