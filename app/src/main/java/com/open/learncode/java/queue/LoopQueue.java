package com.open.learncode.java.queue;

/**
 * 基于数组实现的循环队列
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    //用来存储队列元素的数组
    private E[] data;
    //队列对头的索引坐标
    private int front;
    //队列对尾的索引坐标
    private int tail;
    //队列中元素个数
    private int size;

    /**
     * 无参构造方法
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 有参构造方法
     *
     * @param capacity 队列的容量
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * 获取队列的容量
     *
     * @return 返回队列的容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 判断队列元素是否为空
     *
     * @return 返回true代表为空，false代表不为空
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取队列中元素的个数
     *
     * @return 返回队列中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 向队列中添加元素
     *
     * @param e 待添加的元素
     */
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            int newCapacity = data.length + (data.length >> 1);
            resize(newCapacity);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 删除队列队头元素
     *
     * @return 返回队列队头元素
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        return ret;
    }

    /**
     * 获取对列对头的元素
     *
     * @return 返回队列队头元素
     */
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        return data[front];
    }

    /**
     * 循环队列私有的扩容操作 每次扩容1.5倍
     *
     * @param newCapacity 将要扩容的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
        newData = null;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Queue：front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        res.append(String.format(" , size = %d , capacity = %d", size, data.length));
        return res.toString();
    }
}
