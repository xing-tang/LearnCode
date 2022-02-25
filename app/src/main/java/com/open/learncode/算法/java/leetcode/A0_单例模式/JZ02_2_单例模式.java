package com.open.learncode.算法.java.leetcode.A0_单例模式;

/**
 * {@link }
 */
public class JZ02_2_单例模式 {

    private JZ02_2_单例模式() {
    }

    private static class Holder {
        static JZ02_2_单例模式 instance = new JZ02_2_单例模式();
    }

    public static JZ02_2_单例模式 getInstance() {
        return Holder.instance;
    }

    public static void main(String[] args) {
        System.out.println(JZ02_2_单例模式.getInstance().hashCode());
        System.out.println(JZ02_2_单例模式.getInstance().hashCode());
    }
}
