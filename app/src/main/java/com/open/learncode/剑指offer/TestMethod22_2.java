package com.open.learncode.剑指offer;

/**
 * 题目：
 * 求链表的中间节点。如果链表中的节点总数为奇数，则返回中间节点，
 * 如果节点总数为偶数，则返回中间两个节点的任意一个。
 * <p>
 * 解题思路：
 * 快慢两个指针，一个指针一次走一步走，另一个指针一次走两步。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod22_2 {

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

    public static void main(String[] args) {
        //创建单链表
        ListNode<Integer> node6 = new ListNode<Integer>(6);
        ListNode<Integer> node5 = new ListNode<Integer>(5, node6);
        ListNode<Integer> node4 = new ListNode<Integer>(4, node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3, node4);
        ListNode<Integer> node2 = new ListNode<Integer>(2, node3);
        ListNode<Integer> node1 = new ListNode<Integer>(1, node2);

        //测试用例：
        System.out.println("链表的中间节点为：" + method(node1).value);
        System.out.println("链表的中间节点为：" + method(node2).value);
    }

    /**
     * 快慢指针方法
     *
     * @param head 单链表的头节点
     * @return 返回链表的中间节点
     */
    private static ListNode method(ListNode head) {

        //鲁棒性
        if (head == null) return null;

        ListNode fast = head, low = head;

        //当fast为null 或 fast.next为null（fast.next.next报错）时，结束循环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        return low;
    }

}