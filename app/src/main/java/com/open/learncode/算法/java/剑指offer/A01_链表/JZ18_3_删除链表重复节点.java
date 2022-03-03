package com.open.learncode.算法.java.剑指offer.A01_链表;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 删除链表中重复的节点：在一个排序的链表中，如何删除重复的节点？
 * 例如：1->2->3->3->4->4->5 删除重复的节点后变成 1->2->3>4->5
 * <p>
 * 注意：
 * <p>
 * 示例：
 * 示例1：输入: 1->2->3->3->4->4->5，输出: 1->2->3>4->5。
 * <p>
 * 解题思路：
 * 构建辅助头节点，遇到重复元素跳过，重新建立前一个节点与第一个不重复节点的连接
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ18_3_删除链表重复节点 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> node = ListNode.createListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        PrintUtils.getInstance().printListNode(node);
        PrintUtils.getInstance().printListNode(solution((node)), "删除重复元素后的链表");
    }

    private static ListNode<Integer> solution(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

        ListNode<Integer> curr = head;
        while (curr != null) {
            while (curr.next != null && curr.value == curr.next.value) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}