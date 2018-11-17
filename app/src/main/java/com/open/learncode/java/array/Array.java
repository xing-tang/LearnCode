package com.open.learncode.java.array;

/**
 * 通过对数组封装实现自己的Array类
 */
public class Array<E> {

    //定义一个整型的一维数组的成员变量
    private E[] data;
    //数组中元素的个数，手动去维系它
    private int size;

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 有参构造函数
     *
     * @param capacity 数组的容量，默认为10
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 获取数组中的元素个数
     *
     * @return 数组中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量大小
     *
     * @return 数组的容量大小
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组是否为空
     *
     * @return 数组是否为空，true为空，false不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组中某个位置添加一个新的元素
     *
     * @param index 待添加的索引坐标
     * @param e     待添加的新元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if (size - data.length >= 0) {
            int newCapacity = data.length + (data.length >> 1);
            resize(newCapacity);
        }

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    /**
     * 向数组中所有元素前添加一个新的元素
     *
     * @param e 添加的元素
     */
    public void addFrist(E e) {
        add(0, e);
    }

    /**
     * 向数组中所有元素后添加一个新的元素
     *
     * @param e 添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取某个索引坐标的元素值
     *
     * @param index 索引坐标
     * @return 索引坐标对应的元素值
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 获取第一个索引坐标的元素值
     *
     * @return 索引坐标对应的元素值
     */
    public E getFrist() {
        return get(0);
    }

    /**
     * 获取最后一个索引坐标的元素值
     *
     * @return 索引坐标对应的元素值
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改index索引坐标的元素e
     *
     * @param index 索引坐标
     * @param e     修改的元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 检查当前数组是否包含元素e
     *
     * @param e 要包含的元素
     * @return true代表包含，false代表不包含
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e的索引坐标
     *
     * @param e 要查找的元素
     * @return 存在则返回元素e对应的索引坐标，不存在则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素
     *
     * @param index 待删除的索引坐标
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];

        size--;
        data[size] = null;

        return ret;
    }

    /**
     * 从数组中删除第一个元素
     *
     * @return 删除的元素
     */
    public E removeFrist() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     *
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * 但是这里注意，这里删除的e只是元素e第一次出现在数组中的位置，
     * 如果后续有相同的元素e则不会删除
     *
     * @param e 待删除的元素e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     * 动态数组自动扩容
     *
     * @param newCapactity 数组的容度大小
     */
    private void resize(int newCapactity) {
        E[] newData = (E[]) new Object[newCapactity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        newData = null;
    }

    /**
     * 获取String类型结果
     * 注意：@Override 代表的是复用父类的方法
     *
     * @return 输出String类型结果
     */
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Array：[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        res.append(String.format(" , size = %d , capacity = %d", size, data.length));
        return res.toString();
    }


}

