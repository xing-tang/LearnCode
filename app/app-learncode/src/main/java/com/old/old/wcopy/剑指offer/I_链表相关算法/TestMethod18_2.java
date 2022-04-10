package com.old.old.wcopy.剑指offer.I_链表相关算法;

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
        ListNode<Integer> node5_2 = new ListNode<Integer>(5, node6);
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
        // 鲁棒性：若链表为空，或链表只有一个节点，
        if (head == null || head.next == null) return head;

        // 构建辅助头节点
        ListNode<Integer> pHead = new ListNode<Integer>(-1);
        pHead.next = head;
        // 定义前一个节点pre和当前节点cur
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        // 链表未遍历到末尾
        while (cur != null) {
            // 遇到重复节点
            ListNode temp = cur.next;
            if (temp != null && cur.val == temp.val) {
                while (temp != null && cur.val == temp.val) {
                    cur = cur.next;
                    temp = temp.next;
                }
                // 退出循环时，cur指向重复值，也需要删除，而cur.next 指向第一个不重复的值
                // 重新建立连接
                cur = cur.next;
                pre.next = cur;
            } else {// 若不是重复节点，继续遍历下去
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}