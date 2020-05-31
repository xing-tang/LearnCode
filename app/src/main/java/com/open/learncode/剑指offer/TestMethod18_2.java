package com.open.learncode.剑指offer;

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

        //鲁棒性：若链表为空，或链表只有一个节点，
        if (head == null || head.next == null)
            return head;

        //构建辅助头节点
        ListNode pHead = new ListNode(-1);
        pHead.next = head;

        //定义前一个节点pre和当前节点cur
        ListNode pre = pHead;
        ListNode cur = pHead.next;

        //链表未遍历到末尾
        while (cur != null) {

            //遇到重复节点
            ListNode pNext = cur.next;
            if (pNext != null && cur.val == pNext.val) {
                while (pNext != null && cur.val == pNext.val) {
                    cur = cur.next;
                    pNext = pNext.next;
                }
                //退出循环时，cur指向重复值，也需要删除，而cur.next 指向第一个不重复的值
                //重新建立连接
                cur = cur.next;
                pre.next = cur;
            }
            //若不是重复节点，继续遍历下去
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead.next;
    }

    private static void print(ListNode head) {

        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) {
                System.out.println(cur.val);
                return;
            }
            System.out.print(cur.val + "->");
            cur = cur.next;

        }
        System.out.println();
    }

}