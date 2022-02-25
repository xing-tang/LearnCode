package com.open.learncode.算法.java.leetcode.A0_单例模式;

/**
 * {@link }
 */
public class JZ02_1_单例模式 {

    private static volatile JZ02_1_单例模式 instance;

    private JZ02_1_单例模式() {
    }

    public static JZ02_1_单例模式 getInstance() {
        if (instance == null) {
            synchronized (JZ02_1_单例模式.class) {
                if (instance == null) {
                    instance = new JZ02_1_单例模式();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(JZ02_1_单例模式.getInstance().hashCode());
        System.out.println(JZ02_1_单例模式.getInstance().hashCode());
    }
}
