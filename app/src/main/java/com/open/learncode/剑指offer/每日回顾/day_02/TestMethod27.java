package com.open.learncode.剑指offer.每日回顾.day_02;

import java.util.Stack;

/**
 * 题目：
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * ****  4
 * *** /   \
 * ***2     7
 * * / \   / \
 * *1   3 6   9
 * 镜像后：
 * ****  4
 * *** /   \
 * ***7     2
 * * / \   / \
 * *9   6 3   1
 * <p>
 * 解题思路：
 * 递归、迭代
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod27 {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node1, node3);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7, node6, node9);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4, node2, node7);

        printPreorder(node4);
        System.out.println();
        System.out.println("二叉树镜像为：");
        printPreorder(method_1(node4));
        System.out.println();
        System.out.println("二叉树镜像为：");
        printPreorder(method_2(node4));

    }

    /**
     * 递归方法进行二叉树镜像
     *
     * @param root 二叉树根节点
     * @return 返回二叉树的镜像二叉树
     */
    public static TreeNode method_1(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = method_1(root.right);
        root.right = method_1(temp);
        return root;
    }

    /**
     * 迭代方法进行二叉树镜像
     *
     * @param root 二叉树根节点
     * @return 返回二叉树的镜像二叉树
     */
    public static TreeNode method_2(final TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    /**
     * 递归打印前序遍历
     *
     * @param head 根节点
     */
    public static void printPreorder(TreeNode head) {
        if (head == null) return;

        System.out.print(head.value + " ");
        printPreorder(head.left);
        printPreorder(head.right);
    }

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
}
