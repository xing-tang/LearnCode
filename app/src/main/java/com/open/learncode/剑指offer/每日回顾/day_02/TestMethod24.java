package com.open.learncode.剑指offer.每日回顾.day_02;


/**
 * 题目：
 * 反转链表：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 例如：a->b->...->h->i->j->...
 * 反转后变成：a<-b<-...<-h<-i   j->...
 * 链表节点定义如下：
 * class ListNode{
 * int value;
 * ListNode next;
 * }
 * <p>
 * 解题思路：
 * 定义三个指针，分别为：当前遍历到的节点cur，它的前一个节点pre，它的后一个节点tempNext
 * 在改变节点h的next指向pre的同时，需要保存节点tempNext，防止链表断裂
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod24 {

    public static void main(String[] args) {

        ListNode<Integer> node5 = new ListNode<Integer>(5);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        System.out.print("反转前的链表：");
        print(node1);

        System.out.print("反转后的链表：");
        print(method_1(node1));
//        print(method_2(node1));
    }

    /**
     * 迭代方法反转单链表
     *
     * @param head 链表头结点
     * @return 返回反转后的链表头结点
     */
    public static ListNode method_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode curr = method_1(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return curr;
    }

    /**
     * 迭代方法反转单链表
     *
     * @param head 链表头结点
     * @return 返回反转后的链表头结点
     */
    public static ListNode method_2(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        ListNode temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static class ListNode<E> {

        public E value;
        public ListNode<E> next;

        public ListNode(E value) {
            this.value = value;
        }

        public ListNode(E value, ListNode<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private static void print(ListNode pHead) {

        ListNode pNode = pHead;
        while (pNode != null) {

            if (pNode.next == null) {
                System.out.println(pNode.value);
                break;
            }
            System.out.print(pNode.value + "->");
            pNode = pNode.next;

        }
        System.out.println();
    }

}