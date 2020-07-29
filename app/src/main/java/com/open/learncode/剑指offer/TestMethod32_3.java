package com.open.learncode.剑指offer;

import java.util.Stack;

/**
 * 题目：
 * 之字形打印二叉树：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如二叉树如下：
 * *    8
 * *   / \
 * *  6   10
 * * / \ / \
 * *5 7 9  11
 * 则依次打印出：
 * 8
 * 6，10
 * 11，9，7，5
 * <p>
 * 解题思路：
 * 双栈+奇数偶数帕努单
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod32_3 {

    public static class TreeNode<E> {
        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node11 = new TreeNode<Integer>(11);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6, node5, node7);
        TreeNode<Integer> node10 = new TreeNode<Integer>(10, node9, node11);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8, node6, node10);

        System.out.println("之字形打印二叉树：");
        method(node8);
    }

    public static void method(TreeNode<Integer> root) {
        if (root == null) return;

        //stack1 stack2分别存储奇数层、偶数层的节点
        Stack<TreeNode<Integer>> stack1 = new Stack<TreeNode<Integer>>();
        Stack<TreeNode<Integer>> stack2 = new Stack<TreeNode<Integer>>();
        stack1.add(root);

        boolean flag = true;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) {// 奇数层
                while (!stack1.isEmpty()) {
                    TreeNode<Integer> temp = stack1.pop();
                    System.out.print(temp.value + " ");
                    //要倒序打印，必须正序压入
                    if (temp.left != null) stack2.add(temp.left);
                    if (temp.right != null) stack2.add(temp.right);
                }
            } else {// 偶数层
                while (!stack2.isEmpty()) {
                    TreeNode<Integer> temp = stack2.pop();
                    System.out.print(temp.value + " ");
                    //要正序打印，必须倒序压入
                    if (temp.right != null) stack1.add(temp.right);
                    if (temp.left != null) stack1.add(temp.left);
                }

            }
            flag = !flag;
            System.out.println();
        }
    }
}
