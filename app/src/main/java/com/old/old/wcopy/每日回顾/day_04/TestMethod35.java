package com.old.old.wcopy.每日回顾.day_04;

/**
 * 题目：
 * 复杂链表的复制：请实现函数复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向
 * 下一个节点，还有一个sibling指针指向链表中的任意节点或null
 * 例如：
 * *** —————
 * ***↓     |
 * A->B->C->D->E
 * |  |  ↑     ↑
 * **————      |
 * ***|        |
 * ****————————
 * <p>
 * 解题思路：
 * 利用辅助栈的特性，注意栈内数字不能相等
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod35 {

    public static class ListNode<E> {

        public E value;
        public ListNode<E> next;
        public ListNode<E> random;

        public ListNode(E value) {
            this.value = value;
        }

        public void setNextAndRandom(ListNode<E> next, ListNode<E> random) {
            this.next = next;
            this.random = random;
        }
    }

    public static void main(String[] args) {
        ListNode<String> nodeA = new ListNode<String>("A");
        ListNode<String> nodeB = new ListNode<String>("B");
        ListNode<String> nodeC = new ListNode<String>("C");
        ListNode<String> nodeD = new ListNode<String>("D");
        ListNode<String> nodeE = new ListNode<String>("E");
        nodeA.setNextAndRandom(nodeB, nodeC);
        nodeB.setNextAndRandom(nodeC, nodeE);
        nodeC.setNextAndRandom(nodeD, null);
        nodeD.setNextAndRandom(nodeE, nodeB);
        nodeE.setNextAndRandom(null, null);

        ListNode newListNode = method(nodeA);
        printListNode(newListNode);
    }

    public static ListNode method(ListNode<String> head) {
        if (head == null) return null;

        // 创建复制节点，并且链接好next值
        ListNode<String> tempNode = head;
        while (tempNode != null) {
            ListNode<String> newNode = new ListNode<String>(tempNode.value);
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            tempNode = newNode.next;
        }
        // 链接好random值
        tempNode = head;
        while (tempNode != null) {
            tempNode.next.random = (tempNode.random != null) ? tempNode.random.next : null;
            tempNode = tempNode.next.next;
        }
        // 分离原节点和复制节点，并且链接好对应的next值
        ListNode oldListNode = head;
        ListNode newListNode = head.next;
        ListNode headNew = head.next;
        while (oldListNode != null) {
            oldListNode.next = oldListNode.next.next;
            // 注意空指针异常
            newListNode.next = (newListNode.next != null) ? newListNode.next.next : null;
            oldListNode = oldListNode.next;
            newListNode = newListNode.next;
        }
        return headNew;
    }

    /**
     * 打印链表
     *
     * @param pHead 链表头结点
     */
    private static void printListNode(ListNode<Integer> pHead) {
        if (pHead == null) System.out.println("这是一个空链表");
        while (pHead != null) {
            if (pHead.next == null) {
                System.out.println(pHead.value);
                break;
            }
            System.out.print(pHead.value + "->");
            pHead = pHead.next;
        }
        System.out.println();
    }
}
