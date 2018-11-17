package com.open.learncode.java.let;

/**
 * 删除单链表中指定的节点
 * 示例:
 * 单链表head为1->2->3->4->null，node=3,
 * 删除后为：1->2->4->null
 * 注意：node是随机了，有可能为头结点也有可能为尾节点
 */
public class Lte_237 {

    public static void main(String[] args) {


    }

    /**
     * 单链表
     */
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：
     *
     * @param head 单链表
     * @param node 待删除的节点
     */
    public static void deleteListNode(ListNode head, ListNode node) {
        //删除的节点是尾节点，采用顺序查找找到尾节点的前一个节点
        if (node.next == null) {
            while (head.next != node) {
                head = head.next;
            }
            head.next = null;
        }
        //删除的节点是头节点
        else if (head == node) {
            head = null;
        }
        //删除的节点是中间普通节点
        else {
            ListNode q = node.next;
            node.val = q.val;
            node.next = q.next;
        }
    }

}
