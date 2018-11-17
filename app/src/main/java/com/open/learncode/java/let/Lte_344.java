package com.open.learncode.java.let;

/**
 * 344.反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class Lte_344 {

    public static void main(String[] args) {

        Lte_344 lte = new Lte_344();

        String s1 = "hello";
        String s2 = "A man, a plan, a canal: Panama";
        String s3 = "I love java";

        System.out.println(lte.reverseString(s1));
        System.out.println(lte.reverseString(s2));
        System.out.println(lte.reverseString(s3));

    }

    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int begin = 0;
        int end = s.length()-1;
        while (begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
        return new String(arr);
    }

}
