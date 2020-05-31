package com.open.learncode.剑指offer.每日回顾.day_02;

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
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println("原链表为：");
        print(node1);
        System.out.println("删除重复元素后的链表为：");
        print(method((node1)));

    }


    private static ListNode method(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode pre = pHead;
        ListNode cur = pHead.next;

        while (cur != null) {

            ListNode pNext = cur.next;
            if (pNext != null && cur.val == pNext.val) {
                while (pNext != null && cur.val == pNext.val) {
                    cur = cur.next;
                    pNext = pNext.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead.next;
    }

    private static void print(ListNode pHead) {

        ListNode pNode = pHead;
        while (pNode != null) {
            if (pNode.next == null) {
                System.out.println(pNode.val);
                return;
            }
            System.out.print(pNode.val + "->");
            pNode = pNode.next;

        }
        System.out.println();
    }


}