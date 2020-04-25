package com.open.learncode.剑指offer.test;

import android.support.annotation.NonNull;

import java.util.Stack;

/**
 * 题目：
 * 从尾到头打印链表：输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 * <p>
 */
public class TestMethod6 {

    //单链表节点
    public static class ListNode<E>{

        E val;
        ListNode next;

        ListNode(E val){
            this.val=val;
        }

        ListNode(E val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        ListNode<String> node5=new ListNode("e");
        ListNode<String> node4=new ListNode("d",node5);
        ListNode<String> node3=new ListNode("c",node4);
        ListNode<String> node2=new ListNode("b",node3);
        ListNode<String> node1=new ListNode("a",node2);


        System.out.print("反转链表：");

        print(method(node1));

    }

    private static ListNode method(ListNode node){

        //鲁棒性
        if(node==null)
            return null;

        ListNode cur=node;
        ListNode pre=null;

        while (cur!=null){
            ListNode tempNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tempNext;
        }

        return pre;
    }

    private static void print(ListNode node){
        if(node==null)
            return;

        while (node!=null){
            if(node.next!=null)
                System.out.print(node.val+"->");
            else
                System.out.print(node.val+" ");
            node=node.next;
        }

        System.out.println();
    }



}

