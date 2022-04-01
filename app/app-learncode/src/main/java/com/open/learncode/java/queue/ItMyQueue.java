package com.open.learncode.java.queue;

/**
 * 定义一个泛型的队列接口
 * @param <E>
 */
public interface ItMyQueue<E> {

    //入队列,将一个元素添加到对尾
    void enqueue(E e);

    //出对列，将一个元素从对头删除，并且返回这个元素
    E dequeue();

    //获取队列对头的元素
    E getFront();

    //判断这个队列是否为空
    boolean isEmpty();

    //获取队列中的元素个数
    int getSize();

}
