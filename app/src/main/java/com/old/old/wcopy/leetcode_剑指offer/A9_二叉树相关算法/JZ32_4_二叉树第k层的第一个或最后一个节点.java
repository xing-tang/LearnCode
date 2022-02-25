package com.old.old.wcopy.leetcode_剑指offer.A9_二叉树相关算法;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 二叉树第k层的第一个节点或最后一个节点。
 * 例如二叉树如下：
 * *    8
 * *   / \
 * *  6   10
 * * / \ / \
 * *5 7 9  11
 * <p>
 * 解题思路：
 * 利用队列的特性进行操作，再加上两个临时变量
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ32_4_二叉树第k层的第一个或最后一个节点 {

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

        System.out.println("二叉树第2层的第一个节点为：");
        System.out.println(method_first(node8, 2).value);
        System.out.println("二叉树第3层的最后一个节点为：");
        System.out.println(method_last(node8, 3).value);
    }

    /**
     * 获取二叉树第k层第一个节点
     *
     * @param root 根节点
     * @param k    第k层
     * @return 返回对应的节点值
     */
    private static TreeNode<Integer> method_first(TreeNode<Integer> root, int k) {
        if (root == null) return null;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        int row = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                if (k == row) return temp;
            }
            row++;
        }
        return null;
    }

    /**
     * 获取二叉树第k层最后一个节点
     *
     * @param root 根节点
     * @param k    第k层
     * @return 返回对应的节点值
     */
    private static TreeNode<Integer> method_last(TreeNode<Integer> root, int k) {
        if (root == null) return null;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        int row = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                if (k == row && i == length - 1) return temp;
            }
            row++;
        }
        return null;
    }
}
