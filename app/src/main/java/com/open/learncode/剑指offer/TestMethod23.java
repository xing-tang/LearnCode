package com.open.learncode.剑指offer;


/**
 * 题目：
 * 链表中环的入口节点：如果一个链表中包含环，如何找出环的入口节点？
 * 例如：在如图所示的链表中，环的入口节点是节点3
 * ----------
 * |        |
 * ↓        |
 * 1->2->3->4->5->6
 * <p>
 * 解题思路：
 * 1、一快一慢指针，快指针一次向前移动两步，慢指针一次向前移动一步，直到它们相遇，相遇的节点就是环中的一节点
 * 2、得出环的节点总数k
 * 3、一前一后指针，一指针先向前走k步，之后，两指针以形同的速度向前移动，直到它们相遇，相遇的节点就是环的入口节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod23 {


    /**
     * 内部类：单链表节点
     */
    public static class ListNode<E> {

        E val;//节点值
        ListNode next;//指针，指向下一个节点

        ListNode(E val) {
            this.val = val;
        }

        ListNode(E val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

    public static void main(String[] args) {


        //创建单链表
        ListNode<Integer> node6 = new ListNode(6);
        ListNode<Integer> node5 = new ListNode(5, node6);
        ListNode<Integer> node4 = new ListNode(4, node5);
        ListNode<Integer> node3 = new ListNode(3, node4);
        ListNode<Integer> node2 = new ListNode(2, node3);
        ListNode<Integer> node1 = new ListNode(1, node2);
        node6.next = node3;

        System.out.println("环的入口节点：" + EntryNodeOfLoop(node1).val);


    }


    /**
     * 在链表中存在环的前提下，找到一快一慢指针相遇的节点(环中的一节点）
     *
     * @param pHead
     * @return
     */
    private static ListNode MeetingNode(ListNode pHead) {

        //鲁棒性
        if (pHead == null)
            return null;

        //如果链表只有一个节点，不存在环，返回null
        ListNode pSlow = pHead.next;
        if (pSlow == null)
            return null;

        ListNode pFast = pSlow.next;

        while (pFast != null && pSlow != null) {
            if (pSlow == pFast)
                return pFast;

            //慢指针一次走一步
            pSlow = pSlow.next;

            //快指针一次走两步
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
        }

        return null;
    }


    /**
     * 在找到环中任意一个节点之后，就能得出环中的节点数目，并找到环的入口节点
     *
     * @param pHead
     * @return
     */
    private static ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode meetingNode = MeetingNode(pHead);
        //鲁棒性
        if (meetingNode == null)
            return null;

        //得到环中节点的数目
        int nodesInLoop = 0;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            nodesInLoop++;
        }

        //先移动pNode1，让它在链表上移动 环中的节点数
        pNode1 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.next;
        }

        //再移动pNode1 pNode2，一步一步向前，相遇的节点就是闭环的入口节点
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }

}