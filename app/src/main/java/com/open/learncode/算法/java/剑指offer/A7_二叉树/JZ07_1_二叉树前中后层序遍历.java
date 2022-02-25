package com.open.learncode.算法.java.剑指offer.A7_二叉树;

import com.open.learncode.算法.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：
 * ******1
 * *** /   \
 * ***2     3
 * * / \   / \
 * *4  5  6   7
 * <p>
 * 解题思路：
 * 利用递归、迭代(栈)、Morris方法来打印前中后序遍历
 * 层序遍历：1 2 3 4 5 6 7
 * 前序遍历: 1 2 4 5 3 6 7
 * 中序遍历: 4 2 5 1 6 3 7
 * 后序遍历: 4 5 2 6 7 3 1
 * <p>
 * 复杂度分析：
 * 递归方法：时间复杂度：O(n)，空间复杂度：O(n)
 * 迭代方法：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ07_1_二叉树前中后层序遍历 {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        System.out.print("层序遍历：");
        centerPrint_1(node1);
        System.out.println();
        System.out.print("打印出二叉树每一层的第一个或最后一个节点：");
        centerPrint_2(node1);
        System.out.println();

        System.out.print("递归打印前序遍历: ");
        preOrderPrint_1(node1);
        System.out.println();
        System.out.print("迭代打印前序遍历: ");
        preOrderPrint_2(node1);
        System.out.println();

        System.out.print("递归打印中序遍历: ");
        inOrderPrint_1(node1);
        System.out.println();
        System.out.print("迭代打印中序遍历: ");
        inOrderPrint_2(node1);
        System.out.println();

        System.out.print("递归打印后序遍历: ");
        postOrderPrint_1(node1);
        System.out.println();
        System.out.print("迭代打印后序遍历: ");
        postOrderPrint_2(node1);
        System.out.println();
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    private static void centerPrint_1(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
    }

    /**
     * 打印出二叉树每一层的第一个节点。
     * 打印出二叉树每一层的最后一个节点。
     *
     * @param root 根节点
     */
    private static void centerPrint_2(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                if (i == 0) System.out.print(temp.val + " ");
                // if (i == length - 1) System.out.print(temp.value + " ");
            }
        }
    }

    /**
     * 递归打印前序遍历
     *
     * @param root 根节点
     */
    public static void preOrderPrint_1(TreeNode<Integer> root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preOrderPrint_1(root.left);
        preOrderPrint_1(root.right);
    }

    /**
     * 迭代打印前序遍历
     *
     * @param root 根节点
     */
    public static void preOrderPrint_2(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        stack.push(root);
        TreeNode<Integer> temp = null;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    /**
     * 递归打印中序遍历
     *
     * @param root 根节点
     */
    public static void inOrderPrint_1(TreeNode<Integer> root) {
        if (root == null) return;

        inOrderPrint_1(root.left);
        System.out.print(root.val + " ");
        inOrderPrint_1(root.right);
    }

    /**
     * 迭代打印中序遍历
     *
     * @param root 根节点
     */
    public static void inOrderPrint_2(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> curr = root;
        TreeNode<Integer> temp = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                curr = temp.right;
            }
        }
    }

    /**
     * 递归打印后序遍历
     *
     * @param root 根节点
     */
    public static void postOrderPrint_1(TreeNode<Integer> root) {
        if (root == null) return;

        postOrderPrint_1(root.left);
        postOrderPrint_1(root.right);
        System.out.print(root.val + " ");

    }

    /**
     * 迭代打印后序遍历
     *
     * @param root 根节点
     */
    public static void postOrderPrint_2(TreeNode<Integer> root) {
        if (root == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        stack.push(root);
        TreeNode<Integer> curr = root;
        TreeNode<Integer> peek = null;
        while (!stack.isEmpty()) {
            peek = stack.peek();
            if (peek.left != null && peek.left != curr && peek.right != curr) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != curr) {
                stack.push(peek.right);
            } else {
                System.out.print(stack.pop().val + " ");
                curr = peek;
            }

        }
    }
}

