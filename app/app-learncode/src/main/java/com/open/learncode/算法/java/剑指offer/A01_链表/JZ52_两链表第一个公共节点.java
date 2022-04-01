package com.open.learncode.算法.java.剑指offer.A01_链表;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 两个链表的第一个公共节点：输入两个链表，找到它们的第一个公共节点。
 * <p>
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 示例：
 * 示例1：输出 A [a1->a2->c1->c2->c3]，B [b1->b2->b3->c1->c2->c3]，输出：c1。
 * 示例2：输出 A [4->1->8->4->5]，B [5->0->1->8->4->5]，输出：8。
 * 示例3：输出 A [2->6->4]，B [1->5]，输出：null。
 * <p>
 * 解题思路：
 * 双指针法：我们使用两个指针node1，node2分别指向两个链表headA，headB的头结点，然后同时分别对结点遍历，
 * 当node1到达链表headA的末尾时，重新定位到链表headB的头结点。
 * 当node2到达链表headB的末尾时，重新定位到链表headA的头结点。
 * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
 * <p>
 * 复杂度分析：
 * 时间复杂度：时间复杂度：O(m+n)，其中 m 和 n 是分别是链表 headA 和 headB 的长度。两个指针同时遍历两个链表，每个指针遍历两个链表各一次。
 * 空间复杂度：O(1)。
 */
public class JZ52_两链表第一个公共节点 {
    public static void main(String[] args) {
        // 测试用例
        ListNode nodeA1 = ListNode.createListNode(new String[]{"a1", "a2"});
        ListNode nodeA2 = ListNode.createListNode(new String[]{"b1", "b2", "b3"});
        ListNode nodeA3 = ListNode.createListNode(new String[]{"c1", "c2", "c3"});
        nodeA1.next = nodeA3;
        nodeA2.next = nodeA3;
        PrintUtils.getInstance().print(solution(nodeA1, nodeA2).value, "输出");

        ListNode nodeB1 = ListNode.createListNode(new int[]{4, 1});
        ListNode nodeB2 = ListNode.createListNode(new int[]{5, 0, 1});
        ListNode nodeB3 = ListNode.createListNode(new int[]{8, 4, 5});
        nodeB1.next = nodeB3;
        nodeB2.next = nodeB3;
        PrintUtils.getInstance().print(solution(nodeB1, nodeB2).value, "输出");

        ListNode nodeC1 = ListNode.createListNode(new int[]{1, 3, 3, 4});
        ListNode nodeC2 = ListNode.createListNode(new int[]{5, 6, 7});
        PrintUtils.getInstance().print(solution(nodeC1, nodeC2) == null ? "null" : "非null", "输出");
    }

    private static ListNode solution(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null || nodeB == null) return null;

        ListNode tempA = nodeA;
        ListNode tempB = nodeB;
        while (tempA != tempB) {
            tempA = tempA == null ? nodeB : tempA.next;
            tempB = tempB == null ? nodeA : tempB.next;
        }
        return tempA;
    }
}
