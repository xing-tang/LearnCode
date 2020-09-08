package com.open.learncode.算法.test.A8_链表相关算法;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 删除链表中重复的节点：在一个排序的链表中，如何删除重复的节点？
 * 例如：1->2->3->3->5 删除重复的节点后变成 1->2->5
 * <p>
 * 解题思路：
 * 构建辅助头节点，遇到重复元素跳过，重新建立前一个节点与第一个不重复节点的连接
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod18_2 {

    public static void main(String[] args) {
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5_3 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node5_2 = new ListNode<Integer>(5, node5_3);
        ListNode<Integer> node5_1 = new ListNode<Integer>(5, node5_2);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5_1);
        ListNode<Integer> node3_2 = new ListNode<Integer>(3, node4);
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

        ListNode<Integer> curr = head;
        while (curr != null) {
            while (curr.next != null && curr.value == curr.next.value) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}