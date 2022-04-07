package com.open.viewmodel.test;

/**
 * Client
 *
 * @Description: xxx
 * @Author: xing.tang
 */
public class Client {
    public static void main(String[] args) {
        // 创建 ZhangSan
        IShow zhangSan = new ZhangSan();
        // 创建代购者并将 zhangSan 作为构造参数传入
        IShow friend = new Friend(zhangSan);
        friend.buy();
    }
}
