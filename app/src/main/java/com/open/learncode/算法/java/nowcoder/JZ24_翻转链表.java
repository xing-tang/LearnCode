package com.open.learncode.算法.java.nowcoder;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 输入一个长度为n链表，反转链表后，输出新链表的表头。
 * <p>
 * 数据范围：
 * 0 <= 1000
 * <p>
 * 复杂度分析：
 * 时间复杂度O(n)，空间复杂度O(1)
 */
public class JZ24_翻转链表 {

    public static void main(String[] args) {
        // 测试用例
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        PrintUtils.getInstance().printListNode(head);
        PrintUtils.getInstance().printListNode(solution(head), "三指针反转后的链表为");
    }

    private static ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

