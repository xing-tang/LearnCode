package com.open.learncode.剑指offer;


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
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod25 {

    private static ListNode head1, node1_1, node1_2, node1_3;
    private static ListNode head2, node2_1, node2_2, node2_3;

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


        //链表1：
//        head1 = new ListNode(1);
//        node1_1 = new ListNode(3);
//        node1_2 = new ListNode(5);
//        node1_3 = new ListNode(7);

//        head1.next = node1_1;
//        node1_1.next = node1_2;
//        node1_2.next = node1_3;

        head1=null;

        //链表2：
        head2 = new ListNode(2);
        node2_1 = new ListNode(4);
        node2_2 = new ListNode(6);
        node2_3 = new ListNode(8);

        head2.next = node2_1;
        node2_1.next = node2_2;
        node2_2.next = node2_3;

        //合并后：
        System.out.print("递增链表1：");
        print(head1);
        System.out.print("递增链表2：");
        print(head2);
        System.out.print("合并后的升序链表3：");
        print(Merge(head1,head2));


    }

    private static ListNode Merge(ListNode pHead1, ListNode pHead2) {

        //解决鲁棒性：若输入空链表
        if (pHead1 == null)
            return pHead2;
        if (pHead2 == null)
            return pHead1;

        ListNode pMergedHead = null;

        if (pHead1.val < pHead2.val) {
            pMergedHead = pHead1;
            pMergedHead.next = Merge(pHead1.next, pHead2);
        } else {
            pMergedHead = pHead2;
            pMergedHead.next = Merge(pHead1, pHead2.next);
        }

        return pMergedHead;
    }

    private static void print(ListNode pHead) {

        if(pHead==null)
            System.out.println("这是一个空链表");

        ListNode pNode = pHead;
        while (pNode != null) {

            if (pNode.next == null) {
                System.out.println(pNode.val);
                break;
            }
            System.out.print(pNode.val + "->");
            pNode = pNode.next;

        }
        System.out.println();
    }

}