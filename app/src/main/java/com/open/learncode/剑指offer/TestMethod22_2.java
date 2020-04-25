package com.open.learncode.剑指offer;


import java.util.ArrayList;

/**
 * 题目：
 * 求链表的中间节点。如果链表中的节点总数为奇数，则返回中间节点，
 * 如果节点总数为偶数，则返回中间两个节点的任意一个。
 * <p>
 * 解题思路：
 * 两个指针，一个指针一次走一步走，另一个指针一次走两步。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod22_2 {

    public static void main(String[] args) {
        //创建带头节点的单链表
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        if (node1.value>node2.value)

        System.out.println("链表的中间节点为：" + method(node1).value);
        System.out.println("链表的中间节点为：" + method(node2).value);
    }

    /**
     * 快慢指针方法
     *
     * @param head 链表头结点
     * @return 返回链表的中间节点
     */
    private static ListNode method(ListNode head) {
        if (head == null) return null;

        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
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