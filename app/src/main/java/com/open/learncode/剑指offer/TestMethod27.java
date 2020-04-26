package com.open.learncode.剑指offer;


import java.util.Stack;

import learncode.open.com.learncode.R;

/**
 * 题目：
 * 二叉树的镜像：请完成一个函数，输入一棵二叉树，该函数输出它的镜像
 * 二叉树
 * 8
 * / \
 * 6 10
 * / \ / \
 * 5 7 9 11
 * 镜像二叉树
 * 8
 * / \
 * 10 6
 * / \ / \
 * 11 9 7 5
 * <p>
 * 解题思路：
 * 递归法（本质是DFS）
 * 辅助栈（本质是BFS）
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)  空间复杂度：O(n)
 */
public class TestMethod27 {

    /**
     * 内部类：二叉树节点
     */
    public static class TreeNode<E> {

        public E val;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针

        public TreeNode(E val) {
            this.val = val;
        }

        public void setLeftAndRight(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode<Integer> node1 = new TreeNode<>(8);
        TreeNode<Integer> node2 = new TreeNode<>(6);
        TreeNode<Integer> node3 = new TreeNode<>(10);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(7);
        TreeNode<Integer> node6 = new TreeNode<>(9);
        TreeNode<Integer> node7 = new TreeNode<>(11);

        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        System.out.println("递归法");
        printPreorder_1(method_1(node1));
        System.out.println();

        System.out.println("辅助栈：");
        printPreorder_1(method_2(node1));

    }

    /**
     * 递归法（本质是DFS）：
     * 判空操作不能少
     * 先建立辅助节点tmp，存入root的left（后序遍历）/right节点（先序遍历）。这一步是为了防止被修改后左右子树变得相同而无法交换
     * 传入左右子树分别递归和交换
     * 返回root
     *
     * @param root
     */
    private static TreeNode method_1(TreeNode root) {

        //鲁棒性
        if (root == null)
            return root;

        TreeNode tmp = root.left;
        root.left = method_1(root.right);
        root.right = method_1(tmp);

        return root;
    }

    /**
     * 辅助栈（本质是BFS）：
     * 判空操作
     * 创建栈，并添加根节点root
     * while循环下，当栈不为空，栈顶出栈存入node节点
     * 对node节点左右子树进行判断，存在则添加到栈
     * 左右节点交换
     * 返回root
     *
     * @param root
     */
    private static TreeNode method_2(TreeNode root) {

        //鲁棒性
        if (root == null)
            return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;

    }

    /**
     * 递归打印前序遍历
     *
     * @param root 根节点
     */
    public static void printPreorder_1(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        printPreorder_1(root.left);
        printPreorder_1(root.right);
    }
}