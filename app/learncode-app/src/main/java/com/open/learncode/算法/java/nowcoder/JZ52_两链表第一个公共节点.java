package com.open.learncode.算法.java.nowcoder;

import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 两个链表的第一个公共节点：输入两个链表，找到它们的第一个公共节点。
 * <p>
 * 数据范围：
 * n ≤ 1000
 * <p>
 * 解题思路：
 * 双指针法：
 * 我们使用两个指针node1，node2分别指向两个链表headA，headB的头结点，然后同时分别对结点遍历，
 * 当node1到达链表headA的末尾时，重新定位到链表headB的头结点；
 * 当node2到达链表headB的末尾时，重新定位到链表headA的头结点。
 * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(m+n)【m n分别是两个链表的长度】，空间复杂度：O(1)
 */
public class JZ52_两链表第一个公共节点 {
    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> listNode1 = ListNode.createListNode(new int[]{4, 5, 6, 7});
        ListNode<Integer> listNode2 = ListNode.createListNode(new int[]{1, 2, 3});
        PrintUtils.getInstance().printListNode(listNode1, "打印第一条链表");
        PrintUtils.getInstance().printListNode(listNode2, "打印第二条链表");
        PrintUtils.getInstance().printNode(solution(listNode1, listNode2), "两条链表第一个公共节点为");
    }

    /**
     * 双指针法
     *
     * @param nodeA 链表A
     * @param nodeB 链表B
     * @return 返回第一个公共节点
     */
    public static ListNode solution(ListNode<Integer> nodeA, ListNode<Integer> nodeB) {
        if (nodeA == null || nodeB == null) return null;

        ListNode<Integer> tempA = nodeA;
        ListNode<Integer> tempB = nodeB;
        int count = 0;
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
            if (tempA == null) {
                tempA = nodeB;
                count++;
            }
            if (tempB == null) {
                tempB = nodeA;
                count++;
            }
            if (count > 2) return null;

        }
        return tempA;
    }
}
