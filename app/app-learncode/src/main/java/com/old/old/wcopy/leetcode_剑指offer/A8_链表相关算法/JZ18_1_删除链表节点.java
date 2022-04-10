package com.old.old.wcopy.leetcode_剑指offer.A8_链表相关算法;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 在O(1)时间内删除链表节点：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * <p>
 * 解题思路：
 * 对于非尾节点，把下一个节点的内容覆盖要删除的节点，并删除下一个节点
 * 对于尾节点，先顺序查找，再删除
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ18_1_删除链表节点 {

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例：
        // 删除头结点
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method(node1, node1), "打印删除后的链表");
        // 删除节点，有且仅有一个节点
        PrintUtils.getInstance().printListNode(node5);
        PrintUtils.getInstance().printListNode(method(node5, node5), "打印删除后的链表");
        // 删除尾节点
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method(node1, node5), "打印删除后的链表");
        // 删除中间节点
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method(node1, node3), "打印删除后的链表");
    }

    /**
     * 删除指定节点
     *
     * @param head   头结点
     * @param delete 待删除的节点
     * @return 返回删除后的链表头结点
     */
    private static ListNode<Integer> method(ListNode<Integer> head, ListNode<Integer> delete) {
        if (head == null || delete == null) return null;

        // 待删除节点为头结点
        if (head == delete) {
            head = head.next;
        } else if (delete.next != null) {// 待删除的节点为中间节点
            ListNode<Integer> next = delete.next;
            delete.next = next.next;
            delete.val = next.val;
        } else {// 待删除的节点为尾节点
            ListNode<Integer> curr = head;
            while (curr.next != delete) {
                curr = curr.next;
            }
            curr.next = null;
        }
        return head;
    }
}