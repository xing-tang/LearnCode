package com.open.learncode.剑指offer.每日回顾.day_02;


/**
 * 题目：
 * 删除链表中重复的节点：在一个排序的链表中，如何删除重复的节点？
 * 例如：1->2->3->3->5 删除重复的节点后变成 1->2->5
 * 链表节点和函数的定义如下:
 * struct ListNode{
 * int m_nValue;
 * ListNode m_pNext;
 * }
 * <p>
 * void DeleteBode(ListNode ppHead,ListNode pToBeDeleted);
 * <p>
 * 解题思路：
 * 对于非尾节点，把下一个节点的内容覆盖要删除的节点，并删除下一个节点
 * 对于尾节点，先顺序查找，再删除
 * <p>
 * 复杂度分析：
 *
 */
public class TestMethod18_2 {

    private static ListNode head;
    private static ListNode node1;
    private static ListNode node2;
    private static ListNode node3;
    private static ListNode node4;

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
        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;



        print(deleteDuplication((head)));

    }


    private static ListNode deleteDuplication(ListNode pHead) {

        //如果链表为空，返回
        if (pHead == null)
            return null;

        //定义pNode的前一个节点和pNode节点
        ListNode pPreNode = null;
        ListNode pNode = pHead;

        //若pNode节点不为空（没有遍历到尾节点）
        while (pNode != null) {

            ListNode pNext = pNode.next;

            //标记该节点是否需要删除（即是否为重复元素）
            boolean needDelete = false;

            //判断需要删除的重复元素：pNode、pNext节点不为空，且pNode与pNext节点的值相等
            // （pNode节点不为空是循环进行的条件，故在这里可以不用再次判断）
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;

            //若无需删除，继续遍历
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            }
            //若是需要删除，进行删除操作（把val值相同的两个元素全部删除）
            else {
                int val = pNode.val;

                //定义要被删除的节点
                ListNode pToBeDel = pNode;

                //判断是否满足删除的条件
                while (pToBeDel != null && pToBeDel.val == val) {
                    pNext = pToBeDel.next;
                    pToBeDel = null;
                    pToBeDel = pNext;
                }

                //删除的节点是头结点
                if (pPreNode == null)
                    pHead = pNext;
                else
                    pPreNode.next = pNext;


                pNode = pNext;


            }

        }
        return pHead;


    }

    private static void print(ListNode pHead) {

        ListNode pNode = pHead;
        while (pNode != null) {
            if(pNode.next==null)
                System.out.println(pNode.val);
            System.out.print(pNode.val + "->");
            pNode = pNode.next;

        }
        System.out.println();
    }


}