package com.open.learncode.剑指offer;


/**
 * 题目：
 * 反转链表：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 例如：a->b->...->h->i->j->...
 * 反转后变成：a<-b<-...<-h<-i   j->...
 * 链表节点定义如下：
 * struct ListNode{
 * int value;
 * ListNode next;
 * }
 * <p>
 * 解题思路：
 * 定义三个指针，分别为：当前遍历到的节点h，它的前一个节点i，它的后一个节点j
 * 在改变节点h的next指向i的同时，需要保存节点j，防止链表断裂
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod24 {

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


        System.out.print("反转前的链表：");
        print(head);

        System.out.print("反转后的链表：");
        print(ReverseList(head));


    }

    private static ListNode ReverseList(ListNode pHead) {

        //反转后链表的头节点
        ListNode pReverseHead = null;

        ListNode pNode = pHead;
        ListNode pPrev = null;

        while (pNode != null) {

            ListNode pNext = pNode.next;

            //如果pNext为空，即pNode为原链表的尾节点，即为反转后链表的头结点
            if (pNext == null){
                pReverseHead = pNode;
            }

            //将pNode pNext之间的指针断开
            pNode.next = pPrev;

            pPrev = pNode;
            pNode = pNext;
        }

        return pReverseHead;
    }

    private static void print(ListNode pHead) {

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