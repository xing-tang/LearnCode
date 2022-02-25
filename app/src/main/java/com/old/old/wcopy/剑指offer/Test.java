package com.old.old.wcopy.剑指offer;

public class Test {

    public static void main(String[] args) {
        String result = func("Tencent");
        System.out.println(result);

        Integer a = new Integer(1234);
        Integer b = new Integer(1234);
        boolean result2 = (a == b);
        System.out.println("result2=" + result2);

        int result3 = (((0xF0FF & 0x000F) | 0x00F0) << 1 ) / (4 >> 1);
        System.out.println("result3=" + result3);

    }

    public static String func(String s) {
        return s.length() > 0 ? func(s.substring(1)) + s.charAt(0) : "";
    }

}
