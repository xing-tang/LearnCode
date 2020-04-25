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
 * 定义三个指针，分别为：当前遍历到的节点cur，它的前一个节点pre，它的后一个节点tempNext
 * 在改变节点h的next指向pre的同时，需要保存节点tempNext，防止链表断裂
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod24 {

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


        //创建带头节点的单链表
        ListNode<Integer> node6 = new ListNode(6);
        ListNode<Integer> node5 = new ListNode(5, node6);
        ListNode<Integer> node4 = new ListNode(4, node5);
        ListNode<Integer> node3 = new ListNode(3, node4);
        ListNode<Integer> node2 = new ListNode(2, node3);
        ListNode<Integer> node1 = new ListNode(1, node2);


        System.out.print("反转后的链表：");
        ReverseList(node1);


    }

    private static void ReverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        while (curr!=null){
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        while (prev != null) {

            if (prev.next == null) {
                System.out.println(prev.val);
                break;
            }
            System.out.print(prev.val + "->");
            prev = prev.next;
        }

    }

}