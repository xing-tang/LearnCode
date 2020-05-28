package com.open.learncode.剑指offer.每日回顾.day_02;


/**
 * 题目：
 * 链表中倒数第K个节点：输入一个链表，输出该链表中倒数第K个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点。
 * 例如：一个链表有6个节点，从头节点开始，他们的值依次是1 2 3 4 5 6
 * 这个链表的倒数第3个节点是值为4的节点。
 * 链表节点定义如下：
 * class ListNode{
 * int value;
 * ListNode next;
 * }
 * <p>
 * 解题思路：
 * 两个指针，一前一后，相隔k，当前一个走到链表的尾节点，后一个走到了链表的n-k个节点，正好是倒数第k个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod22_1 {

    public static void main(String[] args) {
        //创建带头节点的单链表
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        System.out.println("倒数第K个节点的值为：" + method(node1, 2).value);
    }

    private static ListNode method(ListNode head, int k) {
        //增强鲁棒性：避免"pHead为空指针"， 避免"输入的K参数为0"
        // 若K=0，在for循环中k-1得到的不是-1，而是无符号的OxFFFF,FFFF（4294967295），循环次数超出预期，程序崩溃
        if (head == null || k == 0)
            return null;

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1.next != null)//增强鲁棒性：避免"链表的节点总数少于K"的情况
                p1 = p1.next;
            else
                return null;
        }

        while (p1.next != null) {
            p1 = p1.next;
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