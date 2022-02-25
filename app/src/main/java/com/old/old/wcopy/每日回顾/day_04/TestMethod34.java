package com.old.old.wcopy.每日回顾.day_04;

import java.util.Stack;

/**
 * 题目：
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 例如二叉树如下：
 * * *****5
 * * *** / \
 * * ***4  8
 * * * /  / \
 * * *11 13 4
 * * / \   / \
 * *7  2  5  1
 * * sum=22
 * <p>
 * 解题思路：
 * 利用辅助栈的特性
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod34 {

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
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node5_2 = new TreeNode<Integer>(5);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node11 = new TreeNode<Integer>(11, node7, node2);
        TreeNode<Integer> node13 = new TreeNode<Integer>(13);
        TreeNode<Integer> node4_2 = new TreeNode<Integer>(4, node5_2, node1);
        TreeNode<Integer> node4_1 = new TreeNode<Integer>(4, node11, null);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8, node13, node4_2);
        TreeNode<Integer> node5_1 = new TreeNode<Integer>(5, node4_1, node8);

        method(node5_1, 22);
    }

    private static void method(TreeNode<Integer> root, int target) {
        if (root == null || target <= 0) return;
        method(root, target, new Stack<Integer>());
    }

    private static void method(TreeNode<Integer> root, int target, Stack<Integer> path) {
        target -= root.value;
        // 将当前节点加入路径中
        path.push(root.value);

        // 如果当前节点是叶子节点(即没有左右子节点)，并且当前累加值等于期望值，则输出路径信息
        if (root.left == null && root.right == null && target == 0) {
            for (Integer val : path) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // 如果左子节点不为空，说明不是叶子节点，则继续寻找路径
        if (root.left != null) {
            method(root.left, target, path);
        }
        // 如果右子节点不为空，说明不是叶子节点，则继续寻找路径
        if (root.right != null) {
            method(root.right, target, path);
        }
        // 如果当前节点不符合要求，则从路径中移除当前节点
        path.pop();
    }

}
