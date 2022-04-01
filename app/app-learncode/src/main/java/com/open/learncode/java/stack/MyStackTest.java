package com.open.learncode.java.stack;

/**
 * 测试用例
 */
public class MyStackTest {

    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<Integer>();
        for (int i = 0; i < 11; i++) {
            stack.push(i);
            System.out.println("进栈=>" + stack + ";size=" + stack.getSize() + ";capacity=" + stack.getCapacity());
        }
        stack.pop();
        System.out.println("出栈=>" + stack + ";size=" + stack.getSize() + ";capacity=" + stack.getCapacity());
        stack.pop();
        System.out.println("出栈=>" + stack + ";size=" + stack.getSize() + ";capacity=" + stack.getCapacity());
    }

}
