package com.open.learncode.算法.test.A8_链表相关算法;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 反转链表：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 例如：1->2->3->4->5，反转后变成：5->4->3->2->1
 * <p>
 * 解题思路：
 * 迭代：定义三个指针，分别为：当前遍历到的节点cur，它的前一个节点pre，它的后一个节点tempNext
 * 在改变节点h的next指向pre的同时，需要保存节点tempNext，防止链表断裂
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ24_1_反转链表 {

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method_1(node1), "三指针反转后的链表为");
    }

    /**
     * 三个指针
     *
     * @param head 链表头结点
     * @return 返回反转后的链表头结点
     */
    public static ListNode<Integer> method_1(ListNode<Integer> head) {
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