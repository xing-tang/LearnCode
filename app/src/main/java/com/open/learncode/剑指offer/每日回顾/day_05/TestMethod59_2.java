package com.open.learncode.剑指offer.每日回顾.day_05;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 请定义一个队列并实现函数max_value得到队列里的最大值，要求
 * 函数max_value、push_back和pop_front的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front和max_value需要返回-1。
 * <p>
 * 解题思路：
 * 两个队列，其中一个正常队列存储队列元素，另外一个双端队列存储最大值
 * <p>
 * 复杂度分析：
 * max_value方法时间复杂度：O(1)，push_back方法时间复杂度：O(1)，pop_front方法时间复杂度：O(1)
 */
public class TestMethod59_2 {

    public static void main(String[] args) {
        TestMethod59_2 method = new TestMethod59_2();
        method.push_back(3);
        System.out.println(method.max_value());
        method.push_back(4);
        System.out.println(method.max_value());
        method.push_back(2);
        System.out.println(method.max_value());
        method.pop_front();
        System.out.println(method.max_value());
        method.push_back(3);
        System.out.println(method.max_value());
        method.pop_front();
        System.out.println(method.max_value());
    }

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public TestMethod59_2() {
        queue = new LinkedList<>();  //队列：插入和删除
        deque = new LinkedList<>();  //双端队列：获取最大值
    }

    public int max_value() {
        return deque.size() > 0 ? deque.peek() : -1;  //双端队列的队首为que的最大值
    }

    public void push_back(int value) {
        queue.offer(value);  //value入队
        while (deque.size() > 0 && deque.peekLast() < value) {
            deque.pollLast();  //将deq队尾小于value的元素删掉
        }
        deque.offerLast(value);  //将value放在deq队尾
    }

    public int pop_front() {
        int tmp = queue.size() > 0 ? queue.poll() : -1;  //获得队首元素
        if (deque.size() > 0 && tmp == deque.peek()) {
            deque.poll();  //如果出队的元素是当前最大值，将deq的队首出队
        }
        return tmp;
    }


}
