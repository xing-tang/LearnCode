package com.open.learncode.java.stack;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Stack源码解析
 *
 * @param <E>
 */
public class Stack<E> extends Vector<E> {

    /**
     * * 序列化唯一表示UID
     */
    private static final long serialVersionUID = 1224463164541339165L;

    /**
     * 无参构造函数
     * 创建一个空的栈
     */
    public Stack() {
    }

    /**
     * 将一个元素添加到栈顶，线程安全
     *
     * @param item 元素
     * @return
     */
    public E push(E item) {
        addElement(item);
        return item;
    }

    /**
     * 移除栈顶的元素，并且返回该元素，线程安全
     *
     * @return 返回将要移除栈顶的元素
     */
    public synchronized E pop() {
        E obj;
        int len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }

    /**
     * 查看栈顶的元素，但是不把其移除栈顶，线程安全
     *
     * @return 返回查看的栈顶元素
     */
    public synchronized E peek() {
        int len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    /**
     * 判断当前栈是否为空
     *
     * @return true代表为空，false代表不为空
     */
    public boolean empty() {
        return size() == 0;
    }

    /**
     * 获取当前元素在栈中的索引坐标，线程安全
     *
     * @param o 将查找的元素
     * @return 返回-1则代表该栈中不包含当前元素，否则返回其对应的索引位置
     */
    public synchronized int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
}
