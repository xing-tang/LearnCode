package com.open.learncode.算法.java.剑指offer.A01_链表;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * <p>
 * 注意：
 * 说明：0 ≤ k 。
 * <p>
 * 示例：
 * 示例1：
 * ==================================
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * ==================================
 * 示例2：
 * ==================================
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * ==================================
 * <p>
 * 解题思路：
 * 首先将链表闭合成环，然后找到相应的位置断开这个环，确定新的链表头和链表尾。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ24_3_旋转链表 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> headNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        int k = 7;
        PrintUtils.getInstance().printListNode(headNode);
        PrintUtils.getInstance().printListNode(solution(headNode, k), "右移" + k + "位数，旋转后的链表为");
    }

    private static ListNode<Integer> solution(ListNode<Integer> head, int k) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null || head.next == null || k <= 0) return head;

        int length = 0;
        ListNode<Integer> curr = head;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        int tempK = length % k;
        if (tempK == 0) return head;
        curr.next = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        ListNode<Integer> newHead = head.next;
        head.next = null;
        return newHead;
    }
}