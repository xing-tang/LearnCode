package com.open.learncode.算法.old.wcopy;

import java.util.TreeSet;

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

        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(3);
            int i=1;
            System.out.println("thread1=>"+threadLocal1.get()+":"+threadLocal2.get());
        });
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(4);
            int i=1;
            System.out.println("thread2=>"+threadLocal1.get()+":"+threadLocal2.get());
        });
        thread1.start();
        thread2.start();
        System.out.println("mainThread=>"+threadLocal1.get()+":"+threadLocal2.get());
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
