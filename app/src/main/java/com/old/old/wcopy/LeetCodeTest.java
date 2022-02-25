package com.old.old.wcopy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCodeTest
 *
 * @Description:
 * @Author: xing.tang
 */
public class LeetCodeTest {

    public static void main(String[] args) {
        QueueToStack<String> stack = new QueueToStack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        stack.push("4");
        System.out.println(stack.pop());
    }

    private static class QueueToStack<E> {

        private Queue<E> queue1 = new ArrayDeque();
        private Queue<E> queue2 = new ArrayDeque();

        private void push(E value) {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                queue1.offer(value);
            } else if (queue1.isEmpty()) {
                queue2.offer(value);
            } else if (queue2.isEmpty()) {
                queue1.offer(value);
            }
        }

        private E pop() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return null;
            }

            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    /**
                     * Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。
                     * 在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null 。
                     */
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            }
            if (queue2.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            }
            return null;
        }
    }
}
