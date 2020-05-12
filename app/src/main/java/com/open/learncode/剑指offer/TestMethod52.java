package com.open.learncode.剑指offer;

/**
 * 题目：
 * 两个链表的第一个公共节点：输入两个链表，找到它们的第一个公共节点。
 * <p>
 * 解题思路：
 * 双指针法：
 * 我们使用两个指针node1，node2分别指向两个链表headA，headB的头结点，然后同时分别对结点遍历，
 * 当node1到达链表headA的末尾时，重新定位到链表headB的头结点；
 * 当node2到达链表headB的末尾时，重新定位到链表headA的头结点。
 * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(m+n)【m n分别是两个链表的长度】
 * 空间复杂度：O(1)
 */

public class TestMethod52 {
    /**
     * 链表节点
     */
    public static class ListNode<E> {

        public E value;//节点值
        public ListNode next;//指向下一个节点的指针
        public ListNode sibling;//指向任意节点的指针

        public ListNode(E value) {
            this.value = value;
        }

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }

    }

    public static void main(String[] args) {

        //公共部分：
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6,node7);

        //链表1：
        ListNode node3 = new ListNode(3,node6);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        //链表2：
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);


        ListNode head=new ListNode(10);

        System.out.print("两个链表的第一个公共节点为：");
//        System.out.println(method(node1,node4)!=null?method(node1,node4).value:method(node1,node4));
        System.out.println(method(node1,head)!=null?method(node1,head).value:method(node1,head));
    }


    private static ListNode method(ListNode head1,ListNode head2){

        //鲁棒性
        if(head1==null||head2==null)
            return null;

        ListNode node1=head1;
        ListNode node2=head2;

        while (node1!=node2){
            node1=node1!=null?node1.next:head2;
            node2=node2!=null?node2.next:head1;
        }

        return node1;
    }
}
