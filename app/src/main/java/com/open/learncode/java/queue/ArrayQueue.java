package com.open.learncode.java.queue;


import com.open.learncode.java.arraylist.MyArrayList;

/**
 * 基于Array实现的队列
 *
 * @param <E>
 */
public class ArrayQueue<E> implements ItMyQueue<E> {

    //基于数组二次封装的Array类
    private MyArrayList<E> array;

    /**
     * 无参构造方法
     */
    public ArrayQueue() {
        array = new MyArrayList<E>();
    }

    /**
     * 有参构造方法
     *
     * @param capacity Array类的容量
     */
    public ArrayQueue(int capacity) {
        array = new MyArrayList<E>(capacity);
    }

    /**
     * 往队列队尾添加元素
     *
     * @param e 待添加的元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 删除队列队头元素
     *
     * @return 返回队列队头元素
     */
    @Override
    public E dequeue() {
        return array.removeFrist();
    }

    /**
     * 获取对列对头的元素
     *
     * @return 返回队列队头元素
     */
    @Override
    public E getFront() {
        return array.getFrist();
    }

    /**
     * 判断队列是否为空
     *
     * @return true代表为空，false代表不为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取队列中有多少个元素
     *
     * @return 返回队列中元素的个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 获取队列的容量
     *
     * @return 返回队列的容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] rear");
        return res.toString();
    }
}
