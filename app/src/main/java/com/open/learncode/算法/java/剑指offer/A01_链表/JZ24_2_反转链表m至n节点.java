package com.open.learncode.算法.java.剑指offer.A01_链表;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：反转链表中m~n的节点。说明：1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 注意：
 * 0 <= 节点个数 <= 5000。
 * <p>
 * 示例：
 * 示例1：输入：1->2->3->4->5，m = 3，n = 4，输出：1->2->4->3->5。
 * <p>
 * 解题思路：
 * 三指针，整个链表分为三部分
 * （1）头部。头部可能为null，即反转从头节点开始，这时，头节点发生改变
 * （2）反转部分。
 * （3）尾部。尾部可能为null，即反转到链表末尾。
 * 反转结束后，需重新建立头部和反转部分，反转部分和尾部的连接
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ24_2_反转链表m至n节点 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> headNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        int m = 2, n = 4;
        PrintUtils.getInstance().printListNode(headNode);
        PrintUtils.getInstance().printListNode(method(headNode, m, n), "反转" + m + "~" + n + "后的链表为");
    }

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