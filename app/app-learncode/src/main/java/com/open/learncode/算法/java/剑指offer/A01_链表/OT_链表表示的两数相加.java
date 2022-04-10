package com.open.learncode.算法.java.剑指offer.A01_链表;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * k给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 例如：
 * 输入：(2 -> 4 -> 3) + (8 -> 9 -> 7)
 * 输出：0 -> 4 -> 1 -> 1
 * 原因：342 + 798 = 1140
 * <p>
 * 解题思路：
 * 利用加法运算规则，并且考虑进位操作
 * <p>
 * 复杂度分析：
 * 时间复杂度：O（n），空间复杂度：O（n）
 */
public class OT_链表表示的两数相加 {

    public static void main(String[] args) {
        ListNode<Integer> listNode3 = new ListNode<>(3);
        ListNode<Integer> listNode4 = new ListNode<>(4, listNode3);
        ListNode<Integer> listNode2 = new ListNode<>(2, listNode4);
        ListNode<Integer> listNode7 = new ListNode<>(7);
        ListNode<Integer> listNode9 = new ListNode<>(9, listNode7);
        ListNode<Integer> listNode8 = new ListNode<>(8, listNode9);

        PrintUtils.getInstance().printListNode(method(listNode2, listNode8));
    }

    private static ListNode<Integer> method(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) return l1;
        if (l2 == null) return l2;

        ListNode<Integer> pre = new ListNode<Integer>(0);
        ListNode<Integer> cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode<Integer>(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode<Integer>(carry);
        }
        return pre.next;
    }
}

