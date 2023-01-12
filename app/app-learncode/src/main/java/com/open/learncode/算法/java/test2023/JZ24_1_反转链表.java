package com.open.learncode.算法.java.test2023;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 反转链表：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 注意：
 * 0 <= 节点个数 <= 5000。
 * <p>
 * 示例：
 * 示例1：输入：1->2->3->4->5，输出：5->4->3->2->1。
 * <p>
 * 解题思路：
 * 迭代：定义三个指针，分别为：当前遍历到的节点cur，它的前一个节点pre，它的后一个节点tempNext
 * 在改变节点h的next指向pre的同时，需要保存节点tempNext，防止链表断裂。
 * <p>
 * 方法一复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 * 方法二复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(n)。
 */
public class JZ24_1_反转链表 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> headNode = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        PrintUtils.getInstance().printListNode(headNode);
        PrintUtils.getInstance().printListNode(solution1(headNode), "三指针反转后的链表为");
        // PrintUtils.getInstance().printListNode(solution2(headNode), "递归反转后的链表为");
    }

    private static ListNode<Integer> solution1(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

        ListNode<Integer> pre = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private static ListNode<Integer> solution2(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;
        ListNode cur = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}