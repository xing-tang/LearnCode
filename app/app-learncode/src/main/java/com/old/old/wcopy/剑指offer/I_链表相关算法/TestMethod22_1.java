package com.old.old.wcopy.剑指offer.I_链表相关算法;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 链表中倒数第K个节点：输入一个链表，输出该链表中倒数第K个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点。
 * 例如：一个链表有6个节点，从头节点开始，他们的值依次是1->2->3->4->5->6
 * 这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 解题思路：
 * 普通解法：将"倒数第K个节点"转化为"整数第n-k+1个节点"，此时，需两次遍历链表，时间复杂度为O(2n)
 * 快慢两个指针，一前一后，相隔k，当快指针指向空节点时，慢指针走到了链表的n-k+1个节点，正好是倒数第k个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)【fast slow】
 */
public class TestMethod22_1 {

    public static void main(String[] args) {
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例：
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printNode(method(node1, 0), "倒数第0个节点的值为");
        PrintUtils.getInstance().printNode(method(node1, 1), "倒数第1个节点的值为");
        PrintUtils.getInstance().printNode(method(node1, 3), "倒数第3个节点的值为");
        PrintUtils.getInstance().printNode(method(node1, 6), "倒数第6个节点的值为");
    }

    /**
     * 快慢指针
     *
     * @param head 单链表的头节点
     * @param k    待输入的k
     * @return 倒数第K个节点
     */
    private static ListNode<Integer> method(ListNode<Integer> head, int k) {
        // 增强鲁棒性：避免"head为空指针"， 避免"输入的K参数为0"
        if (head == null || k <= 0) return null;

        ListNode<Integer> fast = head;
        ListNode<Integer> slow = head;
        // 让快指针先行K步
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {// 增强鲁棒性：避免"链表的节点总数少于K"的情况
                return null;
            }
        }
        // 让快慢指针每次同行一步，直到快指针指向空节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}