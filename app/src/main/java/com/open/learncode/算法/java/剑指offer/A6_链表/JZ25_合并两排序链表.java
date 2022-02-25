package com.open.learncode.算法.java.剑指offer.A6_链表;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 合并两个排序的链表：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 注意：
 * 0 <= 链表长度 <= 1000。
 * <p>
 * 示例：
 * 示例1：输入：1->2->4 和 1->3->4，输出：1->1->2->3->4->4
 * <p>
 * 解题思路：
 * 迭代思维
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ25_合并两排序链表 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> headNode1 = ListNode.createListNode(new int[]{1, 2, 4});
        ListNode<Integer> headNode2 = ListNode.createListNode(new int[]{1, 3, 4});
        PrintUtils.getInstance().printListNode(headNode1);
        PrintUtils.getInstance().printListNode(headNode2);
        PrintUtils.getInstance().printListNode(solution(headNode1, headNode2), "打印合并后的链表");
    }

    private static ListNode<Integer> solution(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode<Integer> pre = new ListNode<Integer>(-1);
        ListNode<Integer> curr = pre;
        while (head1 != null && head2 != null) {
            if (head2.value >= head1.value) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        curr.next = head1 == null ? head2 : head1;
        return pre.next;
    }
}