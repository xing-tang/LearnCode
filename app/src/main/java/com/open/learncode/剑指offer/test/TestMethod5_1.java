package com.open.learncode.剑指offer.test;


/**
 * 题目：
 * 替换空格：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如：输入"We are happy."，则输出"We%20are%20happy."
 */
public class TestMethod5_1 {

    public static void main(String[] args) {

        String str = "we are happy.";
        System.out.print(method(str));

    }

    public static String method(String str) {

        //鲁棒性
        if(str==null || str.length()<=0)
            return null;

        int spacesNum=0;
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)==' ')
                spacesNum++;
        }

        int oldIndex=str.length()-1;
        int newLength=str.length()+spacesNum*2;
        int newIndex=newLength-1;

        StringBuilder builder=new StringBuilder(str);
        builder.setLength(newLength);

        while (oldIndex>=0 && newIndex>oldIndex){

            if(str.charAt(oldIndex)==' '){
                builder.setCharAt(newIndex--,'0');
                builder.setCharAt(newIndex--,'2');
                builder.setCharAt(newIndex--,'%');
            }else{
                builder.setCharAt(newIndex--,str.charAt(oldIndex));
            }

            oldIndex--;
        }

        return builder.toString();
    }
}

