package com.old.old.delete;


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
        int m = 1, n = 4;

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
        // 鲁棒性
        if (head == null || head.next == null || m < 0 || n < 0) return head;
        int length = 0;
        ListNode<Integer> temp = head;
        // mNode代表的是当前m位置所在的节点
        ListNode<Integer> mNode = head;
        // mPreNode代表的是当前m位置的前一个节点
        ListNode<Integer> mPreNode = null;
        while (temp != null) {
            length++;
            if (length == m - 1) {
                mPreNode = temp;
            } else if (length == m) {
                mNode = temp;
            }
            temp = temp.next;
        }
        if (m > length || n > length) return head;

        // 开始反转
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = mNode;
        ListNode<Integer> next = null;
        for (int i = m; i <= n; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 如果是从头节点开始反转，头节点就变成了反转部分的最后一个节点
        if (mPreNode == null) {
            head = pre;
        } else {// 否则，建立头部和反转部分的连接
            mPreNode.next = pre;
        }
        // 建立反转部分和尾部的连接
        mNode.next = cur;

        return head;
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