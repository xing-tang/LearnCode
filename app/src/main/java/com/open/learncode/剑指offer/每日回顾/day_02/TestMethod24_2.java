package com.open.learncode.剑指offer.每日回顾.day_02;


/**
 * 题目：反转链表中m~n的节点
 * <p>
 * 解题思路：
 * 定义三个指针，分别为：当前遍历到的节点cur，它的前一个节点pre，它的后一个节点tempNext
 * 在改变节点h的next指向pre的同时，需要保存节点tempNext，防止链表断裂
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod24_2 {

    /**
     * 内部类：单链表节点
     */
    public static class ListNode<E> {

        E val;//节点值
        ListNode next;//指针，指向下一个节点

        ListNode(E val) {
            this.val = val;
        }

        ListNode(E val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {


        //创建带头节点的单链表
        ListNode<Integer> node5 = new ListNode(5);
        ListNode<Integer> node4 = new ListNode(4, node5);
        ListNode<Integer> node3 = new ListNode(3, node4);
        ListNode<Integer> node2 = new ListNode(2, node3);
        ListNode<Integer> node1 = new ListNode(1, node2);


        int m=5;
        int n=5;
        System.out.print("反转"+m+"~"+n+"后的链表：");

        print(method(node1, m, n, 5));

    }

    private static ListNode method(ListNode head, int m, int n, int length) {

        if (head == null || m < 0 || n < 0 || m > n || m > length || n > length)
            return null;

        if (m == n)
            return head;

        ListNode pNode = head;
        ListNode previous = null;
        for (int i = 1; i < m; i++) {
            previous = pNode;
            pNode = pNode.next;
        }


        ListNode curr = pNode;
        ListNode prev = null;
        ListNode tempNext;
        for (int i = m; i <= n; i++) {
            tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
            pNode.next = tempNext;
        }

        if (previous != null){
            previous.next = prev;
            return previous;
        }

        return prev;

    }

    private static void print(ListNode head){
        while (head != null) {

            if (head.next == null) {
                System.out.print(head.val);
                break;
            }
            System.out.print(head.val + "->");
            head = head.next;

        }
    }

}