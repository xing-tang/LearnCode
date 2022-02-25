package com.open.learncode.算法.old.wcopy.leetcode_快手;

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
public class KS4_二叉树的前中后序遍历 {

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
        centerPrint(node1);
        System.out.println();

        System.out.print("迭代打印前序遍历: ");
        preOrderPrint(node1);
        System.out.println();

        System.out.print("迭代打印中序遍历: ");
        inOrderPrint(node1);
        System.out.println();

        System.out.print("迭代打印后序遍历: ");
        postOrderPrint(node1);
        System.out.println();
    }

    private static void centerPrint(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                System.out.print(temp.val + " ");
            }
        }
    }

    private static void preOrderPrint(TreeNode<Integer> root) {
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

    private static void inOrderPrint(TreeNode<Integer> root) {
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

    private static void postOrderPrint(TreeNode<Integer> root) {
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
