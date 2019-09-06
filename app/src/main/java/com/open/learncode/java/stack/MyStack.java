package com.open.learncode.java.stack;


import com.open.learncode.java.arraylist.MyArrayList;

/**
 * 基于数组实现的队列
 *
 * @param <E>
 */
public class MyStack<E> implements ItMyStack<E> {

    /**
     * 基于数组二次封装的ArrayList类
     * 这里的MyArrayList是第一篇博客中(https://blog.csdn.net/u011035026/article/details/83820427)自定义的
     * 也可以用系统的AraayList替换，同理
     */
    private MyArrayList<E> arrayList;

    /**
     * 无参构造方法
     */
    public MyStack() {
        arrayList = new MyArrayList<E>();
    }

    /**
     * 有参构造方法
     *
     * @param capacity 栈的容量
     */
    public MyStack(int capacity) {
        arrayList = new MyArrayList<E>(capacity);
    }

    /**
     * 往栈中添加元素
     *
     * @param e 待添加的元素值
     */
    @Override
    public void push(E e) {
        arrayList.addFrist(e);
    }

    /**
     * 删除栈顶的元素
     *
     * @return 返回栈顶的元素
     */
    @Override
    public E pop() {
        return arrayList.removeLast();
    }

    /**
     * 获取栈顶的元素，并不删除
     *
     * @return 返回栈顶的元素
     */
    @Override
    public E peek() {
        return arrayList.getLast();
    }

    /**
     * 判断栈是否为空
     *
     * @return 返回true代表为空，false代表不为空
     */
    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    /**
     * 获取栈中元素的个数
     *
     * @return 返回栈中元素的个数
     */
    @Override
    public int getSize() {
        return arrayList.getSize();
    }

    /**
     * 获取栈的容量
     *
     * @return 返回栈的容量
     */
    public int getCapacity() {
        return arrayList.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < arrayList.getSize(); i++) {
            res.append(arrayList.get(i));
            if (i != arrayList.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
