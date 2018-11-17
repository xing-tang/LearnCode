package com.open.learncode.java.stack;

/**
 * 定义一个泛型的栈接口
 * @param <E>
 */
public interface Stack<E> {

    //进栈
    void push(E e);

    //出栈
    E pop();

    //获取栈顶值，但是不出栈
    E peek();

    //判断这个栈是否为空
    boolean isEmpty();

    //获取栈中的元素个数
    int getSize();

}
