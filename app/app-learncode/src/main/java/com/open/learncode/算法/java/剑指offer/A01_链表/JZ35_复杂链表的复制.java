package com.open.learncode.算法.java.剑指offer.A01_链表;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 复杂链表的复制：请实现函数复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向
 * 下一个节点，还有一个random指针指向链表中的任意节点或null。
 * <p>
 * 注意：
 * -10000 <= Node.val <= 10000。
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * 示例：
 * 示例1：
 * =======================
 * *** —————
 * ***↓     |
 * A->B->C->D->E
 * |  |  ↑     ↑
 * **————      |
 * ***|        |
 * ****————————
 * =======================
 * <p>
 * 解题思路：
 * 利用辅助栈的特性，注意栈内数字不能相等。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ35_复杂链表的复制 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<String> nodeA = new ListNode("A");
        ListNode<String> nodeB = new ListNode("B");
        ListNode<String> nodeC = new ListNode("C");
        ListNode<String> nodeD = new ListNode("D");
        ListNode<String> nodeE = new ListNode("E");
        nodeA.setNextAndRandom(nodeB, nodeC);
        nodeB.setNextAndRandom(nodeC, nodeE);
        nodeC.setNextAndRandom(nodeD, null);
        nodeD.setNextAndRandom(nodeE, nodeB);
        nodeE.setNextAndRandom(null, null);
        PrintUtils.getInstance().printListNode(nodeA);
        ListNode newListNode = solution(nodeA);
        PrintUtils.getInstance().printListNode(solution(nodeA), "hashCode=" + nodeA.hashCode() + ",输出");
        PrintUtils.getInstance().printListNode(solution(newListNode), "hashCode=" + newListNode.hashCode() + ",输出");
    }

    private static ListNode solution(ListNode<String> head) {
        if (head == null) return null;

        // 创建复制节点，并且链接好next值
        ListNode<String> cur = head;
        while (cur != null) {
            ListNode<String> newNode = new ListNode(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        // 链接好random值
        cur = head;
        while (cur != null) {
            cur.next.random = (cur.random != null) ? cur.random.next : null;
            cur = cur.next.next;
        }
        // 分离原节点和复制节点，并且链接好对应的next值
        ListNode oldListNode = head;
        ListNode newListNode = head.next;
        // 保存新链表的头结点，用于返回
        ListNode headNew = newListNode;
        while (oldListNode != null) {
            oldListNode.next = oldListNode.next.next;
            // 注意空指针异常
            newListNode.next = (newListNode.next != null) ? newListNode.next.next : null;
            oldListNode = oldListNode.next;
            newListNode = newListNode.next;
        }
        return headNew;
    }
}
