package com.open.learncode.算法.每日回顾.day_03;


/**
 * 题目：
 * 合并两个排序的链表：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 例如：
 * 链表1：1->3->5->7
 * 链表2：2->4->6->8
 * 合并的链表3：1->2->3->4->5->6->7->8
 * <p>
 * 解题思路：
 * 用递归完成：得到链表1 2中值较小的头节点，并链接到已经合并的链表3之后
 * 两个链表剩余的节点仍然是排序的，因此合并的步骤和之前的步骤一样
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod25 {

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
        // 链表1
        ListNode<Integer> node7 = new ListNode<Integer>(7);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node7);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node5);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node3);
        // 链表2
        ListNode<Integer> node8 = new ListNode<Integer>(8);
        ListNode<Integer> node6 = new ListNode<Integer>(6, node8);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node6);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node4);

        // 合并后：
        System.out.print("递增链表1：");
        print(node1);
        System.out.print("递增链表2：");
        print(node2);
        System.out.print("合并后的升序链表3：");
        print(method(node1, node2));
    }

    /**
     * 迭代
     *
     * @param head1 链表1的头节点
     * @param head2 链表2的头节点
     * @return 返回合并后的链表头节点
     */
    public static ListNode method(ListNode<Integer> head1, ListNode<Integer> head2) {

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