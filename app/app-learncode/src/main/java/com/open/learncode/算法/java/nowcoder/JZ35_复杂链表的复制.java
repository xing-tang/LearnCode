package com.open.learncode.算法.java.nowcoder;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 复杂链表的复制：请实现函数复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向
 * 下一个节点，还有一个random指针指向链表中的任意节点或null
 * 例如：
 * A->B->C->D->E
 * |           ↑
 * ————————————
 * <p>
 * 解题思路：
 * 利用辅助栈的特性，注意栈内数字不能相等
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ35_复杂链表的复制 {

    public static void main(String[] args) {
        // 测试用例
        ListNode head = ListNode.createRandomListNode(new String[]{"A", "B", "C", "D", "E"});
        PrintUtils.getInstance().printListNode(head);
        ListNode newListNode = solution(head);
        PrintUtils.getInstance().printListNode(newListNode);
    }

    /**
     * 复杂链表的复制
     *
     * @param head 头结点
     * @return 返回复制后的链表头结点
     */
    private static ListNode solution(ListNode head) {
        if (head == null) return null;

        // 创建复制节点，并且链接好next值
        ListNode currNode = head;
        ListNode newNode = null;
        while (currNode != null) {
            newNode = new ListNode(currNode.val);
            newNode.next = currNode.next;
            currNode.next = newNode;
            currNode = newNode.next;
        }
        // 链接好random值
        currNode = head;
        while (currNode != null) {
            currNode.next.random = (currNode.random != null) ? currNode.random.next : null;
            currNode = currNode.next.next;
        }
        // 分离原节点和复制节点，并且链接好对应的next值
        ListNode oldListNode = head;
        ListNode newListNode = head.next;
        ListNode newHead = newListNode;
        while (oldListNode != null) {
            oldListNode.next = oldListNode.next.next;
            // 注意空指针异常
            newListNode.next = (newListNode.next != null) ? newListNode.next.next : null;
            oldListNode = oldListNode.next;
            newListNode = newListNode.next;
        }
        return newHead;
    }
}