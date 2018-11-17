package com.open.learncode.java.stack;


import com.open.learncode.java.array.Array;

/**
 * 基于Array实现的队列
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    //基于数组二次封装的Array类
    private Array<E> array;

    /**
     * 无参构造方法
     */
    public ArrayStack() {
        array = new Array<E>();
    }

    /**
     * 有参构造方法
     *
     * @param capacity Array类的容量
     */
    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    /**
     * 往栈中添加元素
     *
     * @param e 待添加的元素值
     */
    @Override
    public void push(E e) {
        array.addFrist(e);
    }

    /**
     * 删除栈顶的元素
     *
     * @return 返回栈顶的元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获取栈顶的元素，并不删除
     *
     * @return 返回栈顶的元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 判断栈是否为空
     *
     * @return 返回true代表为空，false代表不为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取栈中元素的个数
     *
     * @return 返回栈中元素的个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取栈的容量
     *
     * @return 返回栈的容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
