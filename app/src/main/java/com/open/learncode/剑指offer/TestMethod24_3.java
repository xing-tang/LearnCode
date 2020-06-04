package com.open.learncode.剑指offer;


/**
 * 题目：
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * 例如：
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * <p>
 * 解题思路：
 * 如果K是链表长度的倍数则什么都不需要操作，直接范围。
 * 注意指针移动时的边界和防止空指针异常等细节。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod24_3 {

    public static void main(String[] args) {

        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        System.out.print("旋转前的链表：");
        print(node1);
        System.out.print("旋转后的链表：");
        print(method(node1,3));
    }

    public static ListNode method(ListNode node, int k) {
        // 特判
        if (node == null) return null;
        if (node.next == null || k == 0) return node;
        // 第 1 步：先要知道链表有多少个结点
        int size = 1;
        ListNode oldTail = node;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            size++;
        }
        // 取k真正的值，并且特判，并且将尾部链接头部形成闭环
        k = k % size;
        if (k == 0) return node;
        oldTail.next = node;

        // 第 2 步：找到倒数第 k 个结点，走 n - k - 1 步，获取新尾部
        ListNode newTail = node;
        for (int i = 0; i < size - k - 1; i++) {
            newTail = newTail.next;
        }

        // 第3步：找到新头部，并且将新尾部切断链接
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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

    private static void print(ListNode pHead) {
        ListNode pNode = pHead;
        while (pNode != null) {

            if (pNode.next == null) {
                System.out.println(pNode.value);
                break;
            }
            System.out.print(pNode.value + "->");
            pNode = pNode.next;

        }
        System.out.println();
    }

}