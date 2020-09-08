package com.open.learncode.算法.每日回顾.day_02;

/**
 * 题目：
 * 删除链表中重复的节点：在一个排序的链表中，如何删除重复的节点？
 * 例如：1->2->3->3->5 删除重复的节点后变成 1->2->5
 * <p>
 * 解题思路：
 * 构建辅助头节点，遇到重复元素跳过，重新建立前一个节点与第一个不重复节点的连接
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod18_2 {

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
        ListNode<Integer> node4 = new ListNode<Integer>(3, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        System.out.println("原链表为：");
        print(node1);
        System.out.println("删除重复元素后的链表为：");
        print(method((node1)));
    }

    /**
     * 删除重复的节点
     *
     * @param head 头结点
     * @return 返回链表
     */
    private static ListNode<Integer> method(ListNode<Integer> head) {
        // 鲁棒性：若链表为空，或链表只有一个节点，
        if (head == null || head.next == null) return head;

        // 构建辅助头节点
        ListNode<Integer> pHead = new ListNode<Integer>(-1);
        pHead.next = head;
        // 定义前一个节点pre和当前节点cur
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        // 链表未遍历到末尾
        while (cur != null) {
            // 遇到重复节点
            ListNode pNext = cur.next;
            if (pNext != null && cur.value == pNext.value) {
                while (pNext != null && cur.value == pNext.value) {
                    cur = cur.next;
                    pNext = pNext.next;
                }
                // 退出循环时，cur指向重复值，也需要删除，而cur.next 指向第一个不重复的值
                // 重新建立连接
                cur = cur.next;
                pre.next = cur;
            } else {// 若不是重复节点，继续遍历下去
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead.next;
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