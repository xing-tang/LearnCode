package com.open.learncode.剑指offer;


/**
 * 题目一：
 * 在O(1)时间内删除链表节点：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)
 * 时间内删除该节点。
 * 链表节点和函数的定义如下:
 * struct ListNode{
 *     int m_nValue;
 *     ListNode m_pNext;
 * }
 *
 * void DeleteBode(ListNode plistHead,ListNode pToBeDeleted);
 * <p>
 * 解题思路：
 * 对于非尾节点，把下一个节点的内容覆盖要删除的节点，并删除下一个节点
 * 对于尾节点，先顺序查找，再删除
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)   空间复杂度：O(1)
 * n-1非尾节点，1尾节点
 * 故平均时间复杂度为[O(1)*(n-1)+O(n)]/n
 *
 */
public class TestMethod18_1 {

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

        ListNode(int val){
            this.val=val;
            next=null;
        }

    }

    public static void main(String[] args) {

        //创建带头节点的单链表
        head = new ListNode(1);
        node1 = new ListNode(2);
        node2 = new ListNode(3);
        node3 = new ListNode(4);
        node4 = new ListNode(5);

        head.next = node1;
        node1.next=node2;
        node2.next = node3;
        node3.next = node4;

        method_1(head,node2);
        print(head);



    }


    private static void method_1(ListNode listHead,ListNode deletedNode) {

        if(listHead==null||deletedNode==null)
            return;

        //要删除的节点不是尾节点
        if(deletedNode.next!=null){
            ListNode delete_next=deletedNode.next;
            deletedNode.val=delete_next.val;
            deletedNode.next=delete_next.next;

            delete_next=null;

        }

        //链表只有一个节点，删除头节点（也是尾节点）
        else if(listHead==deletedNode){
            deletedNode=null;
            listHead=null;

        }

        //链表中有多个节点，删除尾节点
        else{
            ListNode node=listHead;
            while (node.next!=deletedNode){
                node=node.next;
            }

            node.next=null;
            deletedNode=null;
        }

    }

    private static void print(ListNode head){
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }



}