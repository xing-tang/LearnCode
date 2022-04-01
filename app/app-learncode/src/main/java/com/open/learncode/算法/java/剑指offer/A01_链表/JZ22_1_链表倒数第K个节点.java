package com.open.learncode.算法.java.剑指offer.A01_链表;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 链表中倒数第K个节点：输入一个链表，输出该链表中倒数第K个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点。
 * 例如：一个链表有6个节点，从头节点开始，他们的值依次是1->2->3->4->5->6
 * 这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 注意：
 * <p>
 * 示例：
 * 示例1：给定一个链表: 1->2->3->4->5 且 k = 2，返回链表 4->5。
 * <p>
 * 解题思路：
 * 普通解法：将"倒数第K个节点"转化为"整数第n-k+1个节点"，此时，需两次遍历链表，时间复杂度为O(2n)。
 * 快慢两个指针解法：一前一后，相隔k，当快指针指向空节点时，慢指针走到了链表的n-k+1个节点，正好是倒数第k个节点。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)【fast slow】。
 */
public class JZ22_1_链表倒数第K个节点 {

    public static void main(String[] args) {
        // 测试用例
        for (int i = 1; i < 6; i++) {
            ListNode<Integer> headNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
            if (i == 1) PrintUtils.getInstance().printListNode(headNode);
            PrintUtils.getInstance().printListNode(solution(headNode, i), "输入" + i + "，输出");
        }
    }

    private static ListNode<Integer> solution(ListNode<Integer> head, int k) {
        if (head == null || k <= 0) return null;

        ListNode curr = head;
        while (k > 0) {
            if (curr == null) return null;
            curr = curr.next;
            k--;
        }
        while (curr != null) {
            curr = curr.next;
            head = head.next;
        }
        return head;
    }
}