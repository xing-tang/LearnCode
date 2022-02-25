package com.open.learncode.算法.old.wcopy.leetcode_剑指offer.A8_链表相关算法;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：反转链表中m~n的节点。说明：1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 解题思路：
 * 整个链表分为三部分
 * 1、头部。头部可能为null，即反转从头节点开始，这时，头节点发生改变
 * 2、反转部分。
 * 3、尾部。尾部可能为null，即反转到链表末尾。
 * 反转结束后，需重新建立头部和反转部分，反转部分和尾部的连接
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ24_2_反转链表m至n节点 {

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例
        int m = 2, n = 4;
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method(node1, m, n), "反转" + m + "~" + n + "后的链表为");
    }

    /**
     * 三指针
     *
     * @param head 头结点
     * @param m    反转开始的位置
     * @param n    反转结束的位置
     * @return 返回反转后的头结点
     */
    private static ListNode<Integer> method(ListNode<Integer> head, int m, int n) {
        if (head == null || head.next == null || m <= 0 || n <= 0 || m >= n) return head;

        int length = 1;
        ListNode<Integer> temp = head;
        ListNode<Integer> mPreHead = null;
        ListNode<Integer> mHead = null;
        while (temp != null) {
            if (length == m - 1) {
                mPreHead = temp;
            } else if (length == m) {
                mHead = temp;
            }
            length++;
            temp = temp.next;
        }
        if (m > length || n > length) return head;

        ListNode<Integer> curr = mHead;
        ListNode<Integer> pre = null;
        ListNode<Integer> next = null;
        for (int i = m; i <= n; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        if (mPreHead == null) {
            head = pre;
        } else {
            mPreHead.next = pre;
        }
        mHead.next = curr;

        return head;
    }
}