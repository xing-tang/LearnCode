package com.open.learncode.算法.base;

import java.util.Stack;

/**
 * 自定义二叉树
 *
 * @param <E> 接受一个泛型
 */
public class TreeNode<E> {

    // 当前节点的值
    public E val;
    // 指向左孩子，默认为指向null
    public TreeNode<E> left;
    // 指向右孩子，默认为指向null
    public TreeNode<E> right;

    /**
     * 有一个参数的构造函数
     *
     * @param val 接受一个泛型值
     */
    public TreeNode(E val) {
        this.val = val;
    }

    /**
     * 有三个参数的构造函数
     *
     * @param val   接受一个泛型值
     * @param left  接受指向左孩子的泛型值
     * @param right 接受指向右孩子的泛型值
     */
    public TreeNode(E val, TreeNode<E> left, TreeNode<E> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 设置左孩子和右孩子
     *
     * @param left  接受指向左孩子的泛型值
     * @param right 接受指向右孩子的泛型值
     */
    public void setLeftAndRight(TreeNode<E> left, TreeNode<E> right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 迭代方法，前中序重建二叉树
     *
     * @param preOrder 先序遍历序列
     * @param inOrder  中序遍历序列
     * @return 返回重建二叉树的根节点
     */
    public static TreeNode createTreeNode(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length <= 0 || inOrder.length <= 0) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode(preOrder[0]);
        int length = preOrder.length;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preOrderVal = preOrder[i];
            TreeNode node = stack.peek();
            if ((int) node.val != inOrder[inorderIndex]) {
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && (int) stack.peek().val == inOrder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}

