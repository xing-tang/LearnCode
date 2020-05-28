package com.open.learncode.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ATest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();
        list2.add(null);
        list2.add("a");
        list2.add("b");
        list2.remove("a");
        HashMap hashMap = new HashMap(6);
        Queue queue = new PriorityQueue();
        System.out.println(tableSizeFor(6));


        int[] src = new int[8];
        for (int i = 0; i < 7; i++) {
            src[i] =i+1;
        }
        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i]+" ");
        }
        System.out.println();
        System.arraycopy(src, 2, src, 3, 5);
        src[3] = 99;
        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i]+" ");
        }
    }
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
