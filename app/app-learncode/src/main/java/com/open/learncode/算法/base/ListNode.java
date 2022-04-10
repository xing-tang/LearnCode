package com.open.learncode.算法.base;

/**
 * 自定义单链表
 *
 * @param <E> 接受一个泛型
 */
public class ListNode<E> {

    // 当前节点的值
    public E val = null;
    // 指向的下一个节点，默认为指向null
    public ListNode<E> next = null;
    // 指向的一个随机节点，默认为指向null
    public ListNode<E> random = null;

    /**
     * 将数组转换为一个单链表
     *
     * @param arr int[] 数组
     * @return ListNode<Integer> 返回头结点
     */
    public static ListNode<Integer> createListNode(int[] arr) {
        if (arr == null || arr.length <= 0) return null;
        ListNode<Integer> node = new ListNode<>(0);
        ListNode<Integer> origin = node;
        for (int item : arr) {
            ListNode<Integer> next = new ListNode(item);
            node.next = next;
            node = node.next;
        }
        return origin.next;
    }

    /**
     * 将数组转换为一个单链表
     *
     * @param arr String[] 数组
     * @return ListNode<String> 返回头结点
     */
    public static ListNode<String> createListNode(String[] arr) {
        if (arr == null || arr.length <= 0) return null;
        ListNode<String> node = new ListNode<>("");
        ListNode<String> origin = node;
        for (String item : arr) {
            ListNode<String> next = new ListNode(item);
            node.next = next;
            node = node.next;
        }
        return origin.next;
    }

    /**
     * 将数组转换为一个随机单链表
     *
     * @param arr String[] 数组
     * @return ListNode<String> 返回头结点
     */
    public static ListNode<Integer> createRandomListNode(String[] arr) {
        if (arr == null || arr.length <= 0) return null;
        ListNode<Integer> node = new ListNode<>(0);
        ListNode<Integer> origin = node;
        for (String item : arr) {
            ListNode<Integer> next = new ListNode(item);
            node.next = next;
            node = node.next;
        }
        origin.next.random = node;
        return origin.next;
    }

    /**
     * 有一个参数的构造函数
     *
     * @param val 接受一个泛型值
     */
    public ListNode(E val) {
        this.val = val;
    }

    /**
     * 有两个参数的构造函数
     *
     * @param val 接受一个泛型值
     * @param next  接受指向下一个节点的泛型值
     */
    public ListNode(E val, ListNode<E> next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 设置下一个节点和一个随机节点¬
     *
     * @param next   接受指向下一个节点的泛型值
     * @param random 接受指向一个随机节点的泛型值
     */
    public void setNextAndRandom(ListNode<E> next, ListNode<E> random) {
        this.next = next;
        this.random = random;
    }
}
