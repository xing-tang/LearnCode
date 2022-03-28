package com.old.old.wcopy.leetcode_剑指offer.A2_单例模式;

public class Singleton_02 {
    private Singleton_02() { }
    public static Singleton_02 getInstance() {
        return Holder.singleton_02;
    }
    private static class Holder {
        private static Singleton_02 singleton_02 = new Singleton_02();
    }
}
