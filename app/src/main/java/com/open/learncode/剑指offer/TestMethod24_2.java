package com.open.learncode.剑指offer;


/**
 * 题目：反转链表中m~n的节点
 * <p>
 * 解题思路：
 * 整个链表分为三部分
 * 1、头部。头部可能为null，即反转从头节点开始，这时，头节点发生改变
 * 2、反转部分。
 * 3、尾部。尾部可能为null，即反转到链表末尾。
 * 反转结束后，需重新建立头部和反转部分，反转部分和尾部的连接
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

        //创建单链表
        ListNode<Integer> node5 = new ListNode(5);
        ListNode<Integer> node4 = new ListNode(4, node5);
        ListNode<Integer> node3 = new ListNode(3, node4);
        ListNode<Integer> node2 = new ListNode(2, node3);
        ListNode<Integer> node1 = new ListNode(1, node2);

        System.out.print("反转前的链表：");
        print(node1);
        int m = 2;
        int n = 5;
        System.out.print("反转" + m + "~" + n + "后的链表：");
        print(method(node1, m, n, 5));
//        print(method(node5, m, n, 5));

    }

    private static ListNode method(ListNode head, int m, int n, int length) {

        //鲁棒性
        if (head == null || m < 0 || n < 0 || m > n || m > length || n > length)
            return null;

        if (m == n || head.next == null)
            return head;

        //找到开始反转的节点p，并保存该节点的前一个节点previous，防止链表断裂
        ListNode p = head;
        ListNode previous = null;
        for (int i = 1; i < m; i++) {
            previous = p;
            p = p.next;
        }

        //开始反转：
        ListNode cur = p;
        ListNode pre = null;
        ListNode next;
        for (int i = m; i <= n; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //如果是从头节点开始反转，头节点就变成了反转部分的最后一个节点
        if (previous == null)
            head = pre;
        else//否则，建立头部和反转部分的连接
            previous.next = pre;

        //建立反转部分和尾部的连接
        if (cur != null)
            p.next = cur;

        return head;

    }

    private static void print(ListNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
                break;
            }
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}