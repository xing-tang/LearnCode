package com.open.learncode.java.collection;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<E> {

    private class Node {

        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(0);
        list1.add(1);

        List<Integer> list2 = new java.util.LinkedList<>();
        list2.add(2);

        list1.addAll(list2);

        StringBuilder res = new StringBuilder();
        res.append("list1 [");
        for (int i = 0; i < list1.size(); i++) {
            if (i != list1.size() - 1) {
                res.append(i + ",");
            } else {
                res.append(i + "]");
            }
        }
        System.out.println(res.toString());

        int[] as = new int[10];
        as[1] = 0;
        System.out.println("as=" + 23 / 10);

        System.out.println("as=" + isMopNumber(233333));

    }

    public static boolean isMopNumber(long number) {
        if (number < 0) return false;
        if (number < 10) {
            return number == 2;
        }
        long temp1 = number % 10;
        long temp2 = number / 10;
        boolean temp3 = isMopNumber(number / 10);

        System.out.println("temp1=" + temp1 + ";temp2=" + temp2 + ";temp3=" + temp3);
        return temp1 == 3 && isMopNumber(temp2);
    }


}

