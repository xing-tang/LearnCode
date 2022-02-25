package com.open.learncode.算法.old.wcopy.每日回顾.day_02;


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

    public static class ListNode<E> {
        E value;
        ListNode<E> next;

        public ListNode(E value) {
            this.value = value;
        }

        ListNode(E value, ListNode<E> next) {
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

        // 删除头结点
//        print(node1);
//        print(method(node1, node1));
        // 删除节点，有且仅有一个节点
//        print(node5);
//        print(method(node5, node5));
        // 删除尾节点
        print(node1);
        print(method(node1, node5));
        // 删除中间节点
//        print(node1);
//        print(method(node1, node3));


    }


    private static ListNode<Integer> method(ListNode<Integer> head, ListNode<Integer> delete) {
        if (head == null || delete == null) return null;

        // 待删除节点不是尾节点
        if (delete.next != null) {
            ListNode<Integer> next = delete.next;
            delete.value = next.value;
            delete.next = next.next;
        } else if (head == delete) { // 待删除节点只有一个节点，此节点为头节点
            head = null;
        } else {// 待删除节点为尾节点
            ListNode cur = head;
            while (cur.next != delete) {
                cur = cur.next;
            }
            cur.next = null;
        }
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