package com.open.learncode.剑指offer;


/**
 * 题目：
 * 在O(1)时间内删除链表节点：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)
 * 时间内删除该节点。
 * <p>
 * 解题思路：
 * 对于非尾节点，把下一个节点的内容覆盖要删除的节点，并删除下一个节点
 * 对于尾节点，先顺序查找，再删除
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)   空间复杂度：O(1)
 */
public class TestMethod18_1 {

    /**
     * 内部类：单链表节点
     */
    public static class ListNode {

        int val;//节点值
        ListNode next;//指针，指向下一个节点

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {

        //创建单链表
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        print(node1);

        method_1(node1, node1);
        print(node1);

        method_1(node1, node5);
        print(node1);

        method_1(node1, node3);
        print(node1);


    }


    private static void method_1(ListNode head, ListNode p) {

        if (head == null || p == null)
            return;

        //删除的节点是头节点和中间节点
        if (p.next != null) {
            //将下一个节点覆盖要删除的节点
            ListNode pNext = p.next;
            p.val = pNext.val;
            p.next = pNext.next;
            //删除下一个节点
            pNext = null;
        }
        //删除的节点是尾节点
        else {

            //找到尾节点的前一个节点
            ListNode node = head;
            while (node.next != p)
                node = node.next;

            node.next = null;
            //删除尾节点
            p = null;
        }
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


}