package com.open.learncode.算法.java.剑指offer.A02_树;

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
        printPreorder(solution1(node4));
        System.out.println();
        System.out.println("二叉树镜像=>前序遍历：");
        printPreorder(solution2(node4));
    }

    /**
     * 迭代：
     *
     * @param root 二叉树根节点
     * @return 返回镜像二叉树的根节点
     */
    public static TreeNode<Integer> solution1(final TreeNode<Integer> root) {
        //
        if (root == null) return null;

        Stack<TreeNode<Integer>> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> temp = stack.pop();
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
            // 交换node节点的左右子树
            TreeNode<Integer> tempLeft = temp.left;
            temp.left = temp.right;
            temp.right = tempLeft;
        }
        return root;
    }

    /**
     * 递归：
     *
     * @param root 二叉树根节点
     * @return 返回镜像二叉树的根节点
     */
    public static TreeNode<Integer> solution2(TreeNode<Integer> root) {
        if (root == null) return null;
        // 交换root节点的左右子树
        TreeNode<Integer> temp = root.left;
        root.left = solution2(root.right);
        root.right = solution2(temp);
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
