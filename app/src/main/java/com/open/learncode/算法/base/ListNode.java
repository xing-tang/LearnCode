package com.open.learncode.算法.base;

/**
 * 自定义单链表
 *
 * @param <E> 接受一个泛型
 */
public class ListNode<E> {

    // 当前节点的值
    public E value;
    // 指向的下一个节点，默认为指向null
    public ListNode<E> next;
    // 指向的一个随机节点，默认为指向null
    public ListNode<E> random;

    /**
     * 有一个参数的构造函数
     *
     * @param value 接受一个泛型值
     */
    public ListNode(E value) {
        this.value = value;
    }


    /**
     * 有两个参数的构造函数
     *
     * @param value 接受一个泛型值
     * @param next  接受指向下一个节点的泛型值
     */
    public ListNode(E value, ListNode<E> next) {
        this.value = value;
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
