package com.open.learncode.剑指offer;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ATest {

    public static void main(String[] args) {
//        TreeMap<String, String> map = new TreeMap<String, String>();
//        for (int i = 1; i < 100; i++) {
//            map.put(i + "", i + "");
//        }
//        map.put(null, null);
//        Iterator<String> hashtableItr = map.keySet().iterator();
//        while (hashtableItr.hasNext()) {
//            String key = hashtableItr.next();
//            System.out.println("key=" + key + ";value=" + map.get(key));
//        }

        TreeSet<String> set = new TreeSet<String>();
        for (int i = 1; i < 100; i++) {
            set.add(i + "");
        }
//        set.add(null);
        for(String s: set) {
            System.out.println(s);
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
