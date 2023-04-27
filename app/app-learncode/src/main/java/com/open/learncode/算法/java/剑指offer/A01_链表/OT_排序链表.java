package com.open.learncode.算法.java.剑指offer.A01_链表;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 例如：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 解题思路：
 *
 * <p>
 * 复杂度分析：
 * 时间复杂度：O（nlogn），空间复杂度：O（1）
 */
public class OT_排序链表 {

    public static void main(String[] args) {
        ListNode<Integer> listNode3 = new ListNode(3);
        ListNode<Integer> listNode1 = new ListNode(1, listNode3);
        ListNode<Integer> listNode2 = new ListNode(2, listNode1);
        ListNode<Integer> listNode4 = new ListNode(4, listNode2);

        PrintUtils.getInstance().printListNode(sortList(listNode4));
//        PrintUtils.getInstance().printListNode(solution(listNode4));
    }

    private static ListNode<Integer> solution(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

        ListNode<Integer> fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode<Integer> tmp = slow.next;
        slow.next = null;
        ListNode<Integer> left = solution(head);
        ListNode<Integer> right = solution(tmp);
        ListNode<Integer> h = new ListNode(0);
        ListNode<Integer> res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public static ListNode<Integer> sortList(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead, slow = newHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return mergeList(sortList(head), sortList(fast));
    }

    public static ListNode mergeList(ListNode<Integer> head1, ListNode<Integer> head2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = (head1 != null) ? head1 : head2;
        return newHead.next;
    }

}
