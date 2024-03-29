package com.old.old.wcopy.leetcode_剑指offer.A9_二叉树相关算法;

import com.open.learncode.算法.base.TreeNode;

import java.util.Stack;

/**
 * 题目：
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * *     4
 * *   /   \
 * *  2     7
 * * / \   / \
 * *1   3 6   9
 * 镜像后：
 * *     4
 * *   /   \
 * *  7     2
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
public class JZ27_二叉树的镜像 {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode(1);
        TreeNode<Integer> node3 = new TreeNode(3);
        TreeNode<Integer> node6 = new TreeNode(6);
        TreeNode<Integer> node9 = new TreeNode(9);
        TreeNode<Integer> node2 = new TreeNode(2, node1, node3);
        TreeNode<Integer> node7 = new TreeNode(7, node6, node9);
        TreeNode<Integer> node4 = new TreeNode(4, node2, node7);

        System.out.println("二叉树=>前序遍历：");
        printPreorder(node4);
        System.out.println();
        System.out.println("二叉树镜像=>前序遍历：");
        printPreorder(method_1(node4));
        System.out.println();
        System.out.println("二叉树镜像=>前序遍历：");
        printPreorder(method_2(node4));

    }

    /**
     * 递归：
     *
     * @param root 二叉树根节点
     * @return 返回镜像二叉树的根节点
     */
    public static TreeNode<Integer> method_1(TreeNode<Integer> root) {
        if (root == null) return null;
        //交换root节点的左右子树
        TreeNode<Integer> temp = root.left;
        root.left = method_1(root.right);
        root.right = method_1(temp);
        return root;
    }

    /**
     * 迭代：
     *
     * @param root 二叉树根节点
     * @return 返回镜像二叉树的根节点
     */
    public static TreeNode<Integer> method_2(final TreeNode<Integer> root) {
        if (root == null) return null;

        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            // 交换node节点的左右子树
            TreeNode<Integer> tmp = node.left;
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
    public static void printPreorder(TreeNode<Integer> head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        printPreorder(head.left);
        printPreorder(head.right);
    }
}
