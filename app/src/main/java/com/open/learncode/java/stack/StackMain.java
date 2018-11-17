package com.open.learncode.java.stack;


public class StackMain {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<Integer>();
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
