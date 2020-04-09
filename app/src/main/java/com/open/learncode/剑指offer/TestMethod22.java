package com.open.learncode.剑指offer;


/**
 * 题目：
 * 链表中倒数第K个节点：输入一个链表，输出该链表中倒数第K个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点。
 * 例如：一个链表有6个节点，从头节点开始，他们的值依次是1 2 3 4 5 6
 * 这个链表的倒数第3个节点是值为4的节点。
 * 链表节点定义如下：
 * struct ListNode{
 * int value;
 * ListNode next;
 * }
 * <p>
 * 解题思路：
 * 两个指针，一前一后，相隔k-1，当前一个走到链表的尾节点，后一个走到了链表的n-(k-1)=n-k+1个节点，正好是倒数第K个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod22 {

    private static ListNode head, node1, node2, node3, node4, node5;

    /**
     * 内部类：单链表节点
     */
    public static class ListNode {

        int val;//节点值
        ListNode next;//指针，指向下一个节点

        ListNode(int val) {
            this.val = val;
            next = null;
        }


    }

    public static void main(String[] args) {


        //创建带头节点的单链表
        head = new ListNode(1);
        node1 = new ListNode(2);
        node2 = new ListNode(3);
        node3 = new ListNode(4);
        node4 = new ListNode(5);
        node5 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        head=null;

        System.out.println("倒数第K个节点的值为：" + FindKthToTail(head, 2).val);


    }

    private static ListNode FindKthToTail(ListNode pHead, int k) {

        //增强鲁棒性：避免"pHead为空指针"， 避免"输入的K参数为0"
        // 若K=0，在for循环中k-1得到的不是-1，而是无符号的OxFFFF,FFFF（4294967295），循环次数超出预期，程序崩溃
        if (pHead == null || k == 0)
            return null;


        ListNode pAhead = pHead;
        ListNode pBehind = null;

        for (int i = 0; i < k - 1; i++) {

            if (pAhead.next != null)//增强鲁棒性：避免"链表的节点总数少于K"的情况
                pAhead = pAhead.next;
            else
                return null;
        }

        pBehind = pHead;

        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pBehind;

    }


}