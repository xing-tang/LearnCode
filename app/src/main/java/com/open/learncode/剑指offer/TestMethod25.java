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


    /**
     * 内部类：单链表节点
     */
    public static class ListNode<E extends Comparable> {

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


        //链表1:
        ListNode<Integer> node7 = new ListNode(7);
        ListNode<Integer> node5 = new ListNode(5, node7);
        ListNode<Integer> node3 = new ListNode(3, node5);
        ListNode<Integer> node1 = new ListNode(1, node3);

        //链表2:
        ListNode<Integer> node8 =new ListNode(8);
        ListNode<Integer> node6 = new ListNode(6,node8);
        ListNode<Integer> node4 = new ListNode(4, node6);
        ListNode<Integer> node2 = new ListNode(2, node4);


        //合并前：
        System.out.print("递增链表1：");
        print(node1);

        System.out.print("递增链表2：");
        print(node2);

        //合并后：
        System.out.print("合并后的升序链表3：");
        print(Merge(node1,node2));


    }

    private static ListNode Merge(ListNode pHead1, ListNode pHead2) {

        //解决鲁棒性：若输入空链表
        if (pHead1 == null)
            return pHead2;
        if (pHead2 == null)
            return pHead1;

        ListNode pMergedHead = null;

        if(pHead1.val.compareTo(pHead2.val)<0){
            pMergedHead = pHead1;
            pMergedHead.next = Merge(pHead1.next, pHead2);
        } else {
            pMergedHead = pHead2;
            pMergedHead.next = Merge(pHead1, pHead2.next);
        }

        return pMergedHead;

    }

    private static void print(ListNode pNode) {

        if(pNode==null)
            System.out.println("这是一个空链表");

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