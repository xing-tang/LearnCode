package com.open.learncode.算法.old.wcopy.剑指offer.I_链表相关算法;


import com.open.learncode.算法.base.ListNode;
import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 反转链表：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 例如：1->2->3->4->5，反转后变成：5->4->3->2->1
 * <p>
 * 解题思路：
 * 迭代：定义三个指针，分别为：当前遍历到的节点cur，它的前一个节点pre，它的后一个节点tempNext
 * 在改变节点h的next指向pre的同时，需要保存节点tempNext，防止链表断裂
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(1)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod24_1 {

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);
        // 测试用例
        PrintUtils.getInstance().printListNode(node1);
        PrintUtils.getInstance().printListNode(method_1(node1), "三指针反转后的链表为");
//        PrintUtils.getInstance().printListNode(method_2(node1), "递归反转后的链表为");
    }

    /**
     * 三个指针
     *
     * @param head 链表头结点
     * @return 返回反转后的链表头结点
     */
    public static ListNode<Integer> method_1(ListNode<Integer> head) {
        if (head == null || head.next == null) return head;

        // 三个指针：pre指针指向已经反转好的链表的最后一个节点，最开始没有反转，所以指向null
        // cur指针指向待反转链表的第一个节点，最开始第一个节点待反转，所以指向head
        // next指针指向待反转链表的第二个节点，目的是保存链表，因为cur改变指向后，后面的链表则失效了，所以需要保存
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head 链表头结点
     * @return 返回反转后的链表头结点
     */
    public static ListNode<Integer> method_2(ListNode<Integer> head) {
        // 鲁棒性
        if (head == null || head.next == null) return head;

        // 这里的cur就是最后一个节点
        ListNode<Integer> cur = method_2(head.next);
        // 这里请配合动画演示理解
        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // 而head是4，head的下一个是5，下下一个是空
        // 所以head.next.next 就是5->4
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        // 每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }
}