package com.old.old.wcopy.剑指offer.I_链表相关算法;


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
public class TestMethod18_1 {

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

        // 待删除节点不是尾节点，为中间节点
        if (delete.next != null) {
            ListNode<Integer> next = delete.next;
            delete.value = next.value;
            delete.next = next.next;
        } else if (head == delete) { // 待删除节点只有一个节点，此节点为头节点
            head = null;
        } else {// 待删除节点为尾节点
            ListNode<Integer> cur = head;
            while (cur.next != delete) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }
}