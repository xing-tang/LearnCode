package com.open.learncode.剑指offer;


/**
 * 题目：
 * 链表中环的入口节点：如果一个链表中包含环，如何找出环的入口节点？
 * 例如：在如图所示的链表中，环的入口节点是节点3
 *       ----------
 *       |        |
 *       ↓        |
 * 1->2->3->4->5->6
 * <p>
 * 解题思路：
 * 1、一快一慢指针，快指针一次向前移动两步，慢指针一次向前移动一步，直到它们相遇，相遇的节点就是环中的一节点
 * 2、得出环的节点总数k
 * 3、一前一后指针，一指针先向前走k步，之后，两指针以形同的速度向前移动，直到它们相遇，相遇的节点就是环的入口节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod23 {

    public static void main(String[] args) {
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        node6.next = node3;
        if (method(node1) != null) {
            System.out.println("该链表环的入口节点：" + method(node1).value);
        } else {
            System.out.println("该链表没有入口节点");
        }
    }

    public static ListNode method(ListNode head) {
        // 鲁棒性判断，并且如果链表只有一个节点，不存在环，返回null
        if (head == null || head.next == null) return null;

        ListNode p1 = head, p2 = head;
        while (true) {
            //判断当前链表是否有环
            if (p1 == null || p1.next == null) return null;
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) break;
        }
        p1 = head;
        while (p2 != p1) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    public static class ListNode<E> {

        public E value;
        public ListNode<E> next;

        public ListNode(E value) {
            this.value = value;
        }

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}