package com.old.old.wcopy.每日回顾.day_02;

import java.util.Arrays;

public class TestMethod {

    public static void main(String[] args) {
        String[] str = {"bb", "dd", "aa", "cc", "aa"};
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            if ((i + 1) < str.length && str[i].equals(str[i + 1])) {
                System.out.print("相同元素为：" + str[i]);
            }
        }
        System.out.println(reverseBits(13));


    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }



}
