package com.open.learncode.剑指offer.每日回顾.day_03;


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
public class TestMethod24_2 {

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

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        int m = 1, n = 5;

        System.out.print("反转前的链表：");
        print(node1);
        System.out.print("反转" + m + "~" + n + "后的链表：");
        print(method(node1, m, n));
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
        return null;
    }

    /**
     * 打印链表
     *
     * @param head 头结点
     */
    private static void print(ListNode head) {
        if (head == null) return;
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.value);
                break;
            }
            System.out.print(head.value + "->");
            head = head.next;
        }
    }
}