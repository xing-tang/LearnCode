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
 * 时间复杂度：O（n）。
 * 空间复杂度：O（n）。
 */
public class OT_链表表示的两数相加 {

    public static void main(String[] args) {
        ListNode<Integer> listNode3 = new ListNode(3);
        ListNode<Integer> listNode4 = new ListNode(4, listNode3);
        ListNode<Integer> listNode2 = new ListNode(2, listNode4);
        ListNode<Integer> listNode7 = new ListNode(7);
        ListNode<Integer> listNode9 = new ListNode(9, listNode7);
        ListNode<Integer> listNode8 = new ListNode(8, listNode9);

        PrintUtils.getInstance().printListNode(solution(listNode2, listNode8));
    }

    private static ListNode<Integer> solution(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) return head1;
        if (head2 == null) return head2;

        ListNode<Integer> newHead = new ListNode(-1);
        ListNode<Integer> cur = newHead;
        int carry = 0;
        // 为什么是 || 而非 &&：都可以
        // ||：while 结束可以直接得到链表尾结点，链接进位 carry
        // &&: 需要找到未遍历结束的链表，然后遍历到尾结点，链接进位 carry
        while (head1 != null || head2 != null) {
            int x = head1 == null ? 0 : head1.val;
            int y = head2 == null ? 0 : head2.val;
            int sum = x + y + carry;
            // 获取十位数
            carry = sum / 10;
            // 获取个位数
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return newHead.next;
    }
}

