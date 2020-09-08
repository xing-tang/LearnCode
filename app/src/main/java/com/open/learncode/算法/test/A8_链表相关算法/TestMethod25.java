package com.open.learncode.算法.test.A8_链表相关算法;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 合并两个排序的链表：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 例如：
 * 链表1：1->3->5->7
 * 链表2：2->4->6->8
 * 合并的链表3：1->2->3->4->5->6->7->8
 * <p>
 * 解题思路：
 * 用递归完成：得到链表1 2中值较小的头节点，并链接到已经合并的链表3之后
 * 两个链表剩余的节点仍然是排序的，因此合并的步骤和之前的步骤一样
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod25 {

    public static void main(String[] args) {
        // 链表1
        ListNode<Integer> node7 = new ListNode<Integer>(7);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node7);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node5);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node3);
        // 链表2
        ListNode<Integer> node8 = new ListNode<Integer>(8);
        ListNode<Integer> node6 = new ListNode<Integer>(6, node8);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node6);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node4);
        // 测试用例
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(node2);
        PrintUtils.getInstance().printListNode(method_1(node1, node2), "打印合并后的链表");
    }

    /**
     * 迭代
     *
     * @param head1 链表1的头节点
     * @param head2 链表2的头节点
     * @return 返回合并后的链表头节点
     */
    public static ListNode<Integer> method_1(ListNode<Integer> head1, ListNode<Integer> head2) {
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
        return pre.next;
    }
}