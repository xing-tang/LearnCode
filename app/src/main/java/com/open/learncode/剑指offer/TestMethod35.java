package com.open.learncode.剑指offer;


import com.open.learncode.java.stack.Stack;

/**
 * 题目：
 * 复杂链表的复制：请实现函数复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向
 * 下一个节点，还有一个sibling指针指向链表中的任意节点或null
 * 例如：
 * *** —————
 * ***↓     |
 * A->B->C->D->E
 * |  |  ↑     ↑
 * **————      |
 * ***|        |
 * ****————————
 * <p>
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod35 {

    /**
     * 链表节点
     */
    public static class ListNode<E> {

        public E value;//节点值
        public ListNode next;//指向下一个节点的指针
        public ListNode sibling;//指向任意节点的指针

        public ListNode(E value) {
            this.value = value;
        }

        public void setNextAndSibling(ListNode next, ListNode sibling) {
            this.next = next;
            this.sibling = sibling;
        }


    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.setNextAndSibling(node2, node3);
        node2.setNextAndSibling(node3, null);
        node3.setNextAndSibling(node4, null);
        node4.setNextAndSibling(node5, node2);
        node5.setNextAndSibling(null, null);

        cloneNode(node1);
        connectSiblingNodes(node1);
        System.out.println(reconnctNodes(node1).value);
    }


    private static void cloneNode(ListNode<Integer> node) {

        while (node != null) {
            ListNode clone = new ListNode(node.value);
            clone.setNextAndSibling(node.next, null);

            node.next = clone;
            node = clone.next;

        }
    }

    private static void connectSiblingNodes(ListNode<Integer> node) {
        while (node != null) {
            ListNode clone = node.next;
            if (node.sibling != null)
                clone.sibling = node.sibling.next;

            node = clone.next;
        }
    }

    private static ListNode reconnctNodes(ListNode<Integer> node) {

        ListNode clonedHead = null;
        ListNode clonedNode = null;

        if (node != null) {
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        while (node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        return clonedHead;
    }
}
