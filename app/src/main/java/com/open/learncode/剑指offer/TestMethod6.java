package com.open.learncode.剑指offer;

import java.util.Stack;

/**
 * 题目：
 * 从尾到头打印链表：输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 * <p>
 * 解题思路：
 * 利用栈（先进后出），递归，反转链表（改变链表）
 * <p>
 * 复杂度分析：
 * 方法一、二、三：时间复杂度：O(n)
 * 方法一、二：空间复杂度：O(n) 方法三：O(1)
 */
public class TestMethod6 {

    private static ListNode head;
    private static ListNode node1;
    private static ListNode node2;
    private static ListNode node3;
    private static ListNode node4;

    /**
     * 内部类：链表节点
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
        head = new ListNode(-1);
        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);

        head.next = node1;
        node1.next=node2;
        node2.next = node3;
        node3.next = node4;

        method_1(head);
        System.out.println();
        method_2(head);
        System.out.println();
        method_3(head);


    }

    /**
     * 利用栈"先进后出"的特性，遍历整个单链表，将值放入到栈中，再从栈顶逐个输出
     *
     * @param head 单链表的头节点
     */
    private static void method_1(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        while (head.next != null) {
            stack.push(head.next.val);
            head = head.next;

        }

        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }



    /**
     * 递归
     *
     * 先递归输出节点后面的节点，再输出该节点自身 （实质：调用系统的栈空间）
     *
     * @param head 单链表的头节点
     */
    private static void method_2(ListNode head){


        if(head.next!=null){
            if(head.next!=null){
                method_2(head.next);
            }

            System.out.print(head.next.val+" ");
        }
    }


    /**
     * 反转单链表
     *
     * @param head 单链表的头节点
     */
    private static void method_3(ListNode head){

        ListNode resultList = head;

        ListNode p = head.next;
        ListNode pNext = p.next;

        //循环直到单链表结束
        while (pNext!=null){
            p.next = pNext.next;
            pNext.next = resultList.next;
            resultList.next = pNext;
            pNext=p.next;
        }
        while (head.next!=null){
            System.out.print(head.next.val+" ");
            head=head.next;
        }

    }

}

