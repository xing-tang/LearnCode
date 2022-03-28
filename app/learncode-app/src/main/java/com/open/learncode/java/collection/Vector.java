//package java.util;
//
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//import java.util.function.UnaryOperator;
//
//
//public class Vector<E> extends AbstractList<E> implements List<E>
//        , RandomAccess, Cloneable, java.io.Serializable {
//
//    /**
//     * 保存Vector中数据的数组
//     */
//    protected Object[] elementData;
//
//    /**
//     * 实际数据的数量
//     */
//    protected int elementCount;
//
//    /**
//     * 容量增长系数
//     */
//    protected int capacityIncrement;
//
//    /**
//     * Vector的序列版本号
//     */
//    private static final long serialVersionUID = -2767605614048989439L;
//
//    /**
//     * 有参构造函数
//     *
//     * @param initialCapacity   容量大小
//     * @param capacityIncrement 增长系数
//     */
//    public Vector(int initialCapacity, int capacityIncrement) {
//        super();
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
//        //新建一个数组，数组容量是initialCapacity
//        this.elementData = new Object[initialCapacity];
//        //设置容量增长系数
//        this.capacityIncrement = capacityIncrement;
//    }
//
//    /**
//     * 有参构造函数
//     *
//     * @param initialCapacity 容量大小
//     */
//    public Vector(int initialCapacity) {
//        this(initialCapacity, 0);
//    }
//
//    /**
//     * 无参构造函数，设置默认容量大小为10
//     */
//    public Vector() {
//        this(10);
//    }
//
//    /**
//     * 构造函数，指定集合的Vector
//     *
//     * @param c 集合c
//     */
//    public Vector(Collection<? extends E> c) {
//        //将集合c转换为数组，并且赋值给elementData数组
//        elementData = c.toArray();
//        //设置数组中数据的数量
//        elementCount = elementData.length;
//        // c.toArray might (incorrectly) not return Object[] (see 6260652)
//        if (elementData.getClass() != Object[].class)
//            elementData = Arrays.copyOf(elementData, elementCount, Object[].class);
//    }
//
//    /**
//     * 将anArray数组拷贝到elementData数组中来
//     *
//     * @param anArray 待拷贝的数组
//     */
//    public synchronized void copyInto(Object[] anArray) {
//        System.arraycopy(elementData, 0, anArray, 0, elementCount);
//    }
//
//    /**
//     * 将当前数组的容量设置为数组实际元素个数
//     */
//    public synchronized void trimToSize() {
//        modCount++;
//        int oldCapacity = elementData.length;
//        if (elementCount < oldCapacity) {
//            elementData = Arrays.copyOf(elementData, elementCount);
//        }
//    }
//
//    /**
//     * 确定Vector的容量。
//     *
//     * @param minCapacity 数组的容量大小
//     */
//    public synchronized void ensureCapacity(int minCapacity) {
//        //如果传入的容量大小小于等于0则无效，反之有效
//        if (minCapacity > 0) {
//            //将Vector的改变统计数+1
//            modCount++;
//            ensureCapacityHelper(minCapacity);
//        }
//    }
//
//    /**
//     * 确认“Vector容量”的帮助函数
//     *
//     * @param minCapacity 数组的容量大小
//     */
//    private void ensureCapacityHelper(int minCapacity) {
//        // 判断重新设置的数组容量是否大于现有的数组容量，这样才有效
//        if (minCapacity - elementData.length > 0)
//            grow(minCapacity);
//    }
//
//    /**
//     * The maximum size of array to allocate.
//     * Some VMs reserve some header words in an array.
//     * Attempts to allocate larger arrays may result in
//     * OutOfMemoryError: Requested array size exceeds VM limit
//     */
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//    /**
//     * 数组动态扩容
//     *
//     * @param minCapacity 数组的容量大小
//     */
//    private void grow(int minCapacity) {
//        // overflow-conscious code
//        int oldCapacity = elementData.length;
//        //若容量增长系数大于0(即capacityIncrement>0),则将容量增大到现有容量长度+容量增长系数发，
//        //否则，将原有容量乘2倍处理
//        int newCapacity = oldCapacity +
//                ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
//        //如果扩展后的容量大小newCapacity<传递进来的容量大小，则扩展的容量大小设置为传递进来的容量大小
//        if (newCapacity - minCapacity < 0)
//            newCapacity = minCapacity;
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);
//        elementData = Arrays.copyOf(elementData, newCapacity);
//    }
//
//    private static int hugeCapacity(int minCapacity) {
//        if (minCapacity < 0) // overflow
//            throw new OutOfMemoryError();
//        return (minCapacity > MAX_ARRAY_SIZE) ?
//                Integer.MAX_VALUE :
//                MAX_ARRAY_SIZE;
//    }
//
//    /**
//     * 设置容量值为 newSize
//     *
//     * @param newSize
//     */
//    public synchronized void setSize(int newSize) {
//        modCount++;
//        if (newSize > elementCount) {
//            ensureCapacityHelper(newSize);
//        } else {
//            for (int i = newSize; i < elementCount; i++) {
//                elementData[i] = null;
//            }
//        }
//        elementCount = newSize;
//    }
//
//    /**
//     * 返回"Vector"的总容量的容量大小
//     *
//     * @return
//     */
//    public synchronized int capacity() {
//        return elementData.length;
//    }
//
//    /**
//     * 返回"Vector"的实际大小。即Vector中元素个数
//     *
//     * @return Vector集合中数据大小
//     */
//    public synchronized int size() {
//        return elementCount;
//    }
//
//    /**
//     * 判断"Vector"集合是否为空
//     *
//     * @return true为空，反之亦然
//     */
//    public synchronized boolean isEmpty() {
//        return elementCount == 0;
//    }
//
//    /**
//     * 返回“Vector中全部元素对应的Enumeration”
//     *
//     * @return
//     */
//    public Enumeration<E> elements() {
//        return new Enumeration<E>() {
//            int count = 0;
//
//            public boolean hasMoreElements() {
//                return count < elementCount;
//            }
//
//            public E nextElement() {
//                synchronized (Vector.this) {
//                    if (count < elementCount) {
//                        return elementData(count++);
//                    }
//                }
//                throw new NoSuchElementException("Vector Enumeration");
//            }
//        };
//    }
//
//    /**
//     * 判断"Vector"是否包含元素(o)
//     *
//     * @param o 元素(o)
//     * @return true代表包含，false代表不包含
//     */
//    public boolean contains(Object o) {
//        return indexOf(o, 0) >= 0;
//    }
//
//    /**
//     * 查找并返回元素(o)在Vector中的索引值
//     *
//     * @param o 元素(o)
//     * @return 返回元素(0)的索引坐标，如若不存在返回-1
//     */
//    public int indexOf(Object o) {
//        return indexOf(o, 0);
//    }
//
//    /**
//     * 从index位置开始向后查找元素(o)
//     *
//     * @param o     元素(o)
//     * @param index 索引位置
//     * @return
//     */
//    public synchronized int indexOf(Object o, int index) {
//        //若查找元素为null，则正向找出null元素，并返回它对应的序号
//        if (o == null) {
//            for (int i = index; i < elementCount; i++)
//                if (elementData[i] == null)
//                    return i;
//        } else {
//            //若查找元素不为null，则正向找出该元素，并返回它对应的序号
//            for (int i = index; i < elementCount; i++)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    /**
//     * 从后向前查找元素(o),并返回元素的索引
//     *
//     * @param o 元素(o)
//     * @return 返回元素的索引坐标，如若不存在返回-1
//     */
//    public synchronized int lastIndexOf(Object o) {
//        return lastIndexOf(o, elementCount - 1);
//    }
//
//    /**
//     * 从后向前查找元素(o),开始位置是从前向后的第index个数
//     *
//     * @param o     元素(o)
//     * @param index 索引坐标
//     * @return 返回元素的索引坐标，如若不存在返回-1
//     */
//    public synchronized int lastIndexOf(Object o, int index) {
//        if (index >= elementCount)
//            throw new IndexOutOfBoundsException(index + " >= " + elementCount);
//
//        if (o == null) {
//            for (int i = index; i >= 0; i--)
//                if (elementData[i] == null)
//                    return i;
//        } else {
//            for (int i = index; i >= 0; i--)
//                if (o.equals(elementData[i]))
//                    return i;
//        }
//        return -1;
//    }
//
//    /**
//     * 返回"Vector"中索引坐标为index位置的元素
//     *
//     * @param index 索引坐标
//     * @return 返回对应的元素，失败则抛出异常
//     */
//    public synchronized E elementAt(int index) {
//        //判断index索引坐标是否有效
//        if (index >= elementCount) {
//            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
//        }
//
//        return elementData(index);
//    }
//
//    /**
//     * 返回"Vector"中的第一个元素
//     *
//     * @return 元素值，若失败则抛出异常
//     */
//    public synchronized E firstElement() {
//        if (elementCount == 0) {
//            throw new NoSuchElementException();
//        }
//        return elementData(0);
//    }
//
//    /**
//     * 返回"Vector"中的最后一个元素
//     *
//     * @return 元素值，若失败则抛出异常
//     */
//    public synchronized E lastElement() {
//        if (elementCount == 0) {
//            throw new NoSuchElementException();
//        }
//        return elementData(elementCount - 1);
//    }
//
//    /**
//     * 设置索引坐标为index的元素值obj
//     *
//     * @param obj   元素值
//     * @param index 索引坐标
//     */
//    public synchronized void setElementAt(E obj, int index) {
//        if (index >= elementCount) {
//            throw new ArrayIndexOutOfBoundsException(index + " >= " +
//                    elementCount);
//        }
//        elementData[index] = obj;
//    }
//
//    /**
//     * 删除索引坐标为index的元素
//     *
//     * @param index 索引坐标
//     */
//    public synchronized void removeElementAt(int index) {
//        modCount++;
//        if (index >= elementCount) {
//            throw new ArrayIndexOutOfBoundsException(index + " >= " +
//                    elementCount);
//        } else if (index < 0) {
//            throw new ArrayIndexOutOfBoundsException(index);
//        }
//        int j = elementCount - index - 1;
//        if (j > 0) {
//            System.arraycopy(elementData, index + 1, elementData, index, j);
//        }
//        elementCount--;
//        elementData[elementCount] = null; /* to let gc do its work */
//    }
//
//    /**
//     * 在索引坐标为index的位置插入元素obj
//     *
//     * @param obj   元素
//     * @param index 索引位置
//     */
//    public synchronized void insertElementAt(E obj, int index) {
//        modCount++;
//        if (index > elementCount) {
//            throw new ArrayIndexOutOfBoundsException(index
//                    + " > " + elementCount);
//        }
//        ensureCapacityHelper(elementCount + 1);
//        System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
//        elementData[index] = obj;
//        elementCount++;
//    }
//
//    /**
//     * 将某个元素添加到"Vector"末尾位置
//     *
//     * @param obj 待添加的元素
//     */
//    public synchronized void addElement(E obj) {
//        modCount++;
//        ensureCapacityHelper(elementCount + 1);
//        elementData[elementCount++] = obj;
//    }
//
//    /**
//     * 在Vector中查找并删除元素obj。
//     *
//     * @param obj 待删除的元素
//     * @return 返回true成功，返回false则失败
//     */
//    public synchronized boolean removeElement(Object obj) {
//        modCount++;
//        int i = indexOf(obj);
//        if (i >= 0) {
//            removeElementAt(i);
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 删除Vector中的全部元素
//     */
//    public synchronized void removeAllElements() {
//        modCount++;
//        // Let gc do its work
//        for (int i = 0; i < elementCount; i++)
//            elementData[i] = null;
//
//        elementCount = 0;
//    }
//
//    /**
//     * 克隆函数
//     * 可以将当前集合克隆给另外一个相同类型的集合
//     */
//    public synchronized Object clone() {
//        try {
//            @SuppressWarnings("unchecked")
//            Vector<E> v = (Vector<E>) super.clone();
//            v.elementData = Arrays.copyOf(elementData, elementCount);
//            v.modCount = 0;
//            return v;
//        } catch (CloneNotSupportedException e) {
//            // this shouldn't happen, since we are Cloneable
//            throw new InternalError(e);
//        }
//    }
//
//    /**
//     * 将集合转换为数组
//     *
//     * @return 返回转换后的数组对象
//     */
//    public synchronized Object[] toArray() {
//        return Arrays.copyOf(elementData, elementCount);
//    }
//
//    /**
//     * 返回Vector的模板数组。
//     * 所谓模板数组，即可以将T设为任意的数据类型
//     *
//     * @param a   数组
//     * @param <T> 泛型
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public synchronized <T> T[] toArray(T[] a) {
//        if (a.length < elementCount)
//            return (T[]) Arrays.copyOf(elementData, elementCount, a.getClass());
//
//        System.arraycopy(elementData, 0, a, 0, elementCount);
//
//        if (a.length > elementCount)
//            a[elementCount] = null;
//
//        return a;
//    }
//
//    // Positional Access Operations
//
//    @SuppressWarnings("unchecked")
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//
//    /**
//     * 获取index位置的元素
//     *
//     * @param index
//     * @return
//     */
//    public synchronized E get(int index) {
//        if (index >= elementCount)
//            throw new ArrayIndexOutOfBoundsException(index);
//
//        return elementData(index);
//    }
//
//    /**
//     * 设置index位置的值为element,并返回index位置的原始值
//     *
//     * @param index
//     * @param element
//     * @return
//     */
//    public synchronized E set(int index, E element) {
//        if (index >= elementCount)
//            throw new ArrayIndexOutOfBoundsException(index);
//
//        E oldValue = elementData(index);
//        elementData[index] = element;
//        return oldValue;
//    }
//
//    /**
//     * 将元素e添加到Vector集合最后位置
//     *
//     * @param e
//     * @return
//     */
//    public synchronized boolean add(E e) {
//        modCount++;
//        ensureCapacityHelper(elementCount + 1);
//        elementData[elementCount++] = e;
//        return true;
//    }
//
//    /**
//     * 删除Vector中元素o
//     *
//     * @param o
//     * @return
//     */
//    public boolean remove(Object o) {
//        return removeElement(o);
//    }
//
//    /**
//     * 在index位置添加元素element
//     *
//     * @param index
//     * @param element
//     */
//    public void add(int index, E element) {
//        insertElementAt(element, index);
//    }
//
//    /**
//     * 删除index位置的元素，并返回index位置的原始值
//     *
//     * @param index
//     * @return
//     */
//    public synchronized E remove(int index) {
//        modCount++;
//        if (index >= elementCount)
//            throw new ArrayIndexOutOfBoundsException(index);
//        E oldValue = elementData(index);
//
//        int numMoved = elementCount - index - 1;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index + 1, elementData, index,
//                    numMoved);
//        elementData[--elementCount] = null; // Let gc do its work
//
//        return oldValue;
//    }
//
//    /**
//     * 清空Vector
//     */
//    public void clear() {
//        removeAllElements();
//    }
//
//    /**
//     * 返回Vector是否包含集合c
//     *
//     * @param c
//     * @return
//     */
//    public synchronized boolean containsAll(Collection<?> c) {
//        return super.containsAll(c);
//    }
//
//    /**
//     * 将集合c添加到Vector中
//     *
//     * @param c
//     * @return
//     */
//    public synchronized boolean addAll(Collection<? extends E> c) {
//        modCount++;
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        ensureCapacityHelper(elementCount + numNew);
//        System.arraycopy(a, 0, elementData, elementCount, numNew);
//        elementCount += numNew;
//        return numNew != 0;
//    }
//
//    /**
//     * 删除集合c的全部元素
//     *
//     * @param c
//     * @return
//     */
//    public synchronized boolean removeAll(Collection<?> c) {
//        return super.removeAll(c);
//    }
//
//    /**
//     * 删除"非集合c中的元素"
//     *
//     * @param c
//     * @return
//     */
//    public synchronized boolean retainAll(Collection<?> c) {
//        return super.retainAll(c);
//    }
//
//    /**
//     * 从index位置开始，将集合c添加到Vector中
//     * @param index
//     * @param c
//     * @return
//     */
//    public synchronized boolean addAll(int index, Collection<? extends E> c) {
//        modCount++;
//        if (index < 0 || index > elementCount)
//            throw new ArrayIndexOutOfBoundsException(index);
//
//        Object[] a = c.toArray();
//        int numNew = a.length;
//        ensureCapacityHelper(elementCount + numNew);
//
//        int numMoved = elementCount - index;
//        if (numMoved > 0)
//            System.arraycopy(elementData, index, elementData, index + numNew,
//                    numMoved);
//
//        System.arraycopy(a, 0, elementData, index, numNew);
//        elementCount += numNew;
//        return numNew != 0;
//    }
//
//    /**
//     * 返回两个对象是否相等
//     *
//     * @param o
//     * @return
//     */
//    public synchronized boolean equals(Object o) {
//        return super.equals(o);
//    }
//
//    /**
//     * 计算哈希值
//     *
//     * @return
//     */
//    public synchronized int hashCode() {
//        return super.hashCode();
//    }
//
//    /**
//     * 调用父类的toString()方法
//     */
//    public synchronized String toString() {
//        return super.toString();
//    }
//
//    /**
//     * 获取Vector中fromIndex(包括)到toIndex(不包括)的子集
//     *
//     * @param fromIndex
//     * @param toIndex
//     * @return
//     */
//    public synchronized List<E> subList(int fromIndex, int toIndex) {
//        return Collections.synchronizedList(super.subList(fromIndex, toIndex),
//                this);
//    }
//
//    /**
//     * 删除Vector中fromIndex到toIndex的元素
//     *
//     * @param fromIndex
//     * @param toIndex
//     */
//    protected synchronized void removeRange(int fromIndex, int toIndex) {
//        modCount++;
//        int numMoved = elementCount - toIndex;
//        System.arraycopy(elementData, toIndex, elementData, fromIndex,
//                numMoved);
//
//        // Let gc do its work
//        int newElementCount = elementCount - (toIndex - fromIndex);
//        while (elementCount != newElementCount)
//            elementData[--elementCount] = null;
//    }
//
//    /**
//     * Save the state of the {@code Vector} instance to a stream (that
//     * is, serialize it).
//     * This method performs synchronization to ensure the consistency
//     * of the serialized data.
//     */
//    private void writeObject(java.io.ObjectOutputStream s)
//            throws java.io.IOException {
//        final java.io.ObjectOutputStream.PutField fields = s.putFields();
//        final Object[] data;
//        synchronized (this) {
//            fields.put("capacityIncrement", capacityIncrement);
//            fields.put("elementCount", elementCount);
//            data = elementData.clone();
//        }
//        fields.put("elementData", data);
//        s.writeFields();
//    }
//
//    /**
//     * Returns a list iterator over the elements in this list (in proper
//     * sequence), starting at the specified position in the list.
//     * The specified index indicates the first element that would be
//     * returned by an initial call to {@link ListIterator#next next}.
//     * An initial call to {@link ListIterator#previous previous} would
//     * return the element with the specified index minus one.
//     * <p>
//     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
//     *
//     * @throws IndexOutOfBoundsException {@inheritDoc}
//     */
//    public synchronized ListIterator<E> listIterator(int index) {
//        if (index < 0 || index > elementCount)
//            throw new IndexOutOfBoundsException("Index: " + index);
//        return new ListItr(index);
//    }
//
//    /**
//     * Returns a list iterator over the elements in this list (in proper
//     * sequence).
//     * <p>
//     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
//     *
//     * @see #listIterator(int)
//     */
//    public synchronized ListIterator<E> listIterator() {
//        return new ListItr(0);
//    }
//
//    /**
//     * Returns an iterator over the elements in this list in proper sequence.
//     * <p>
//     * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
//     *
//     * @return an iterator over the elements in this list in proper sequence
//     */
//    public synchronized Iterator<E> iterator() {
//        return new Itr();
//    }
//
//    /**
//     * An optimized version of AbstractList.Itr
//     */
//    private class Itr implements Iterator<E> {
//        // Android-changed: changes around elementCount, introduced limit.
//        // b/27430229 AOSP commit 6e5b758a4438d2c154dd11a5c04d14a5d2fc907c
//        //
//        // The "limit" of this iterator. This is the size of the list at the time the
//        // iterator was created. Adding & removing elements will invalidate the iteration
//        // anyway (and cause next() to throw) so saving this value will guarantee that the
//        // value of hasNext() remains stable and won't flap between true and false when elements
//        // are added and removed from the list.
//        protected int limit = Vector.this.elementCount;
//
//        int cursor;       // index of next element to return
//        int lastRet = -1; // index of last element returned; -1 if no such
//        int expectedModCount = modCount;
//
//        public boolean hasNext() {
//            return cursor < limit;
//        }
//
//        public E next() {
//            synchronized (Vector.this) {
//                checkForComodification();
//                int i = cursor;
//                if (i >= limit)
//                    throw new NoSuchElementException();
//                cursor = i + 1;
//                return elementData(lastRet = i);
//            }
//        }
//
//        public void remove() {
//            if (lastRet == -1)
//                throw new IllegalStateException();
//            synchronized (Vector.this) {
//                checkForComodification();
//                Vector.this.remove(lastRet);
//                expectedModCount = modCount;
//                limit--;
//            }
//            cursor = lastRet;
//            lastRet = -1;
//        }
//
//        @Override
//        public void forEachRemaining(Consumer<? super E> action) {
//            Objects.requireNonNull(action);
//            synchronized (Vector.this) {
//                final int size = limit;
//                int i = cursor;
//                if (i >= size) {
//                    return;
//                }
//                @SuppressWarnings("unchecked") final E[] elementData = (E[]) Vector.this.elementData;
//                if (i >= elementData.length) {
//                    throw new ConcurrentModificationException();
//                }
//                while (i != size && modCount == expectedModCount) {
//                    action.accept(elementData[i++]);
//                }
//                // update once at end of iteration to reduce heap write traffic
//                cursor = i;
//                lastRet = i - 1;
//                checkForComodification();
//            }
//        }
//
//        final void checkForComodification() {
//            if (modCount != expectedModCount)
//                throw new ConcurrentModificationException();
//        }
//    }
//
//    /**
//     * An optimized version of AbstractList.ListItr
//     */
//    final class ListItr extends Itr implements ListIterator<E> {
//        ListItr(int index) {
//            super();
//            cursor = index;
//        }
//
//        public boolean hasPrevious() {
//            return cursor != 0;
//        }
//
//        public int nextIndex() {
//            return cursor;
//        }
//
//        public int previousIndex() {
//            return cursor - 1;
//        }
//
//        public E previous() {
//            synchronized (Vector.this) {
//                checkForComodification();
//                int i = cursor - 1;
//                if (i < 0)
//                    throw new NoSuchElementException();
//                cursor = i;
//                return elementData(lastRet = i);
//            }
//        }
//
//        public void set(E e) {
//            if (lastRet == -1)
//                throw new IllegalStateException();
//            synchronized (Vector.this) {
//                checkForComodification();
//                Vector.this.set(lastRet, e);
//            }
//        }
//
//        public void add(E e) {
//            int i = cursor;
//            synchronized (Vector.this) {
//                checkForComodification();
//                Vector.this.add(i, e);
//                expectedModCount = modCount;
//                limit++;
//            }
//            cursor = i + 1;
//            lastRet = -1;
//        }
//    }
//
//    @Override
//    public synchronized void forEach(Consumer<? super E> action) {
//        Objects.requireNonNull(action);
//        final int expectedModCount = modCount;
//        @SuppressWarnings("unchecked") final E[] elementData = (E[]) this.elementData;
//        final int elementCount = this.elementCount;
//        for (int i = 0; modCount == expectedModCount && i < elementCount; i++) {
//            action.accept(elementData[i]);
//        }
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public synchronized boolean removeIf(Predicate<? super E> filter) {
//        Objects.requireNonNull(filter);
//        // figure out which elements are to be removed
//        // any exception thrown from the filter predicate at this stage
//        // will leave the collection unmodified
//        int removeCount = 0;
//        final int size = elementCount;
//        final BitSet removeSet = new BitSet(size);
//        final int expectedModCount = modCount;
//        for (int i = 0; modCount == expectedModCount && i < size; i++) {
//            @SuppressWarnings("unchecked") final E element = (E) elementData[i];
//            if (filter.test(element)) {
//                removeSet.set(i);
//                removeCount++;
//            }
//        }
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//
//        // shift surviving elements left over the spaces left by removed elements
//        final boolean anyToRemove = removeCount > 0;
//        if (anyToRemove) {
//            final int newSize = size - removeCount;
//            for (int i = 0, j = 0; (i < size) && (j < newSize); i++, j++) {
//                i = removeSet.nextClearBit(i);
//                elementData[j] = elementData[i];
//            }
//            for (int k = newSize; k < size; k++) {
//                elementData[k] = null;  // Let gc do its work
//            }
//            elementCount = newSize;
//            if (modCount != expectedModCount) {
//                throw new ConcurrentModificationException();
//            }
//            modCount++;
//        }
//
//        return anyToRemove;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public synchronized void replaceAll(UnaryOperator<E> operator) {
//        Objects.requireNonNull(operator);
//        final int expectedModCount = modCount;
//        final int size = elementCount;
//        for (int i = 0; modCount == expectedModCount && i < size; i++) {
//            elementData[i] = operator.apply((E) elementData[i]);
//        }
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//        modCount++;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public synchronized void sort(Comparator<? super E> c) {
//        final int expectedModCount = modCount;
//        Arrays.sort((E[]) elementData, 0, elementCount, c);
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//        modCount++;
//    }
//
//    /**
//     * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
//     * and <em>fail-fast</em> {@link Spliterator} over the elements in this
//     * list.
//     * <p>
//     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
//     * {@link Spliterator#SUBSIZED}, and {@link Spliterator#ORDERED}.
//     * Overriding implementations should document the reporting of additional
//     * characteristic values.
//     *
//     * @return a {@code Spliterator} over the elements in this list
//     * @since 1.8
//     */
//    @Override
//    public Spliterator<E> spliterator() {
//        return new VectorSpliterator<>(this, null, 0, -1, 0);
//    }
//
//    /**
//     * Similar to ArrayList Spliterator
//     */
//    static final class VectorSpliterator<E> implements Spliterator<E> {
//        private final Vector<E> list;
//        private Object[] array;
//        private int index; // current index, modified on advance/split
//        private int fence; // -1 until used; then one past last index
//        private int expectedModCount; // initialized when fence set
//
//        /**
//         * Create new spliterator covering the given  range
//         */
//        VectorSpliterator(Vector<E> list, Object[] array, int origin, int fence,
//                          int expectedModCount) {
//            this.list = list;
//            this.array = array;
//            this.index = origin;
//            this.fence = fence;
//            this.expectedModCount = expectedModCount;
//        }
//
//        private int getFence() { // initialize on first use
//            int hi;
//            if ((hi = fence) < 0) {
//                synchronized (list) {
//                    array = list.elementData;
//                    expectedModCount = list.modCount;
//                    hi = fence = list.elementCount;
//                }
//            }
//            return hi;
//        }
//
//        public Spliterator<E> trySplit() {
//            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
//            return (lo >= mid) ? null :
//                    new VectorSpliterator<E>(list, array, lo, index = mid,
//                            expectedModCount);
//        }
//
//        @SuppressWarnings("unchecked")
//        public boolean tryAdvance(Consumer<? super E> action) {
//            int i;
//            if (action == null)
//                throw new NullPointerException();
//            if (getFence() > (i = index)) {
//                index = i + 1;
//                action.accept((E) array[i]);
//                if (list.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
//                return true;
//            }
//            return false;
//        }
//
//        @SuppressWarnings("unchecked")
//        public void forEachRemaining(Consumer<? super E> action) {
//            int i, hi; // hoist accesses and checks from loop
//            Vector<E> lst;
//            Object[] a;
//            if (action == null)
//                throw new NullPointerException();
//            if ((lst = list) != null) {
//                if ((hi = fence) < 0) {
//                    synchronized (lst) {
//                        expectedModCount = lst.modCount;
//                        a = array = lst.elementData;
//                        hi = fence = lst.elementCount;
//                    }
//                } else
//                    a = array;
//                if (a != null && (i = index) >= 0 && (index = hi) <= a.length) {
//                    while (i < hi)
//                        action.accept((E) a[i++]);
//                    if (lst.modCount == expectedModCount)
//                        return;
//                }
//            }
//            throw new ConcurrentModificationException();
//        }
//
//        public long estimateSize() {
//            return (long) (getFence() - index);
//        }
//
//        public int characteristics() {
//            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
//        }
//    }
//}
