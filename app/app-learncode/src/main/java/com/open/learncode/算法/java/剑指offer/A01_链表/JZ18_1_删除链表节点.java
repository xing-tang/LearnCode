package com.open.learncode.算法.java.剑指offer.A01_链表;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 在O(1)时间内删除链表节点：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * <p>
 * 注意：
 * 题目保证链表中节点的值互不相同。
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点。
 * <p>
 * 示例：
 * 示例1：输入: 4->5->1->9，head(4)，输出: 5->1->9。
 * 示例2：输入: 4->5->1->9，head(5)，输出: 4->1->9。
 * 示例3：输入: 4->5->1->9，head(6)，输出: 4->5->1。
 * 示例3：输入: 9，delete=9，输出: null。
 * 解题思路：
 * 对于非尾节点，把下一个节点的内容覆盖要删除的节点，并删除下一个节点
 * 对于尾节点，先顺序查找，再删除
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(1)。
 */
public class JZ18_1_删除链表节点 {

    public static void main(String[] args) {
        // 测试用例
        for (int i = 0; i < 4; i++) {
            ListNode<Integer> node9 = new ListNode(9);
            ListNode<Integer> node1 = new ListNode(1, node9);
            ListNode<Integer> node5 = new ListNode(5, node1);
            ListNode<Integer> node4 = new ListNode(4, node5);
            if (i == 0) {
                // 删除头结点
                PrintUtils.getInstance().printListNode(node4);
                PrintUtils.getInstance().printListNode(solution(node4, node4), "打印删除节点4后的链表");
                PrintUtils.getInstance().printListNode(solution2(node4, node4), "打印删除节点4后的链表");
            } else if (i == 1) {
                // 删除中间节点
                PrintUtils.getInstance().printListNode(node4);
                PrintUtils.getInstance().printListNode(solution(node4, node5), "打印删除节点5后的链表");
                PrintUtils.getInstance().printListNode(solution2(node4, node5), "打印删除节点5后的链表");
            } else if (i == 2) {
                // 删除尾节点
                PrintUtils.getInstance().printListNode(node4);
                PrintUtils.getInstance().printListNode(solution(node4, node9), "打印删除节点9后的链表");
                PrintUtils.getInstance().printListNode(solution2(node4, node9), "打印删除节点9后的链表");
            } else if (i == 3) {
                // 删除节点，有且仅有一个节点
                PrintUtils.getInstance().printListNode(node9);
                PrintUtils.getInstance().printListNode(solution(node9, node9), "打印删除节点9后的链表");
                PrintUtils.getInstance().printListNode(solution2(node9, node9), "打印删除节点9后的链表");
            }
        }
    }

    private static ListNode<Integer> solution(ListNode<Integer> head, ListNode<Integer> delete) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) return head;
        if (head.val.equals(delete.val)) return head.next;

        ListNode<Integer> pre = head, curr = head.next;
        while (curr != null && !curr.val.equals(delete.val)) {
            pre = curr;
            curr = curr.next;
        }
        if (curr != null) pre.next = curr.next;
        return head;
    }

    private static ListNode<Integer> solution2(ListNode<Integer> head, ListNode<Integer> delete) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (head == null) return head;
        if (head == delete) return head.next;
        ListNode<Integer> cur = head.next;
        while (cur != null) {
            if (cur == delete) {
                delete.val = cur.next != null ? cur.next.val : null;
                delete.next = cur.next != null ? cur.next.next: null;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
