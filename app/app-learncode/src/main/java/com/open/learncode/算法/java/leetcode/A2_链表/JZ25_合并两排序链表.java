package com.open.learncode.算法.java.leetcode.A2_链表;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 例如：链表1：1->3->5->7，链表2：2->4->6->8，合并的链表3：1->2->3->4->5->6->7->8
 * <p>
 * 数据范围：
 * 0 ≤ n ≤ 1000，−1000 ≤ 节点值 ≤ 1000
 * <p>
 * 解题思路：
 * 用迭代思想：得到链表1 2中值较小的头节点，并链接到已经合并的链表3之后
 * 两个链表剩余的节点仍然是排序的，因此合并的步骤和之前的步骤一样
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ25_合并两排序链表 {

    public static void main(String[] args) {
        // 测试用例
        ListNode<Integer> listNode1 = ListNode.createListNode(new int[]{1, 2, 4});
        ListNode<Integer> listNode2 = ListNode.createListNode(new int[]{1, 3, 4});
        PrintUtils.getInstance().printListNode(listNode1);
        PrintUtils.getInstance().printListNode(listNode2);
        PrintUtils.getInstance().printListNode(solution(listNode1, listNode2), "打印合并后的链表");
    }

    /**
     * 迭代
     *
     * @param listNode1 链表1的头节点
     * @param listNode2 链表2的头节点
     * @return 返回合并后的链表头节点
     */
    private static ListNode<Integer> solution(ListNode<Integer> listNode1, ListNode<Integer> listNode2) {
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;

        ListNode<Integer> pre = new ListNode(-1);
        ListNode<Integer> cur = pre;
        while (listNode1 != null && listNode2 != null) {
            if (listNode2.value >= listNode1.value) {
                cur.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                cur.next = listNode2;
                listNode2 = listNode2.next;
            }
            cur = cur.next;
        }
        cur.next = listNode1 != null ? listNode1 : listNode2;
        return pre.next;
    }
}