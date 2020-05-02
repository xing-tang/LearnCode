package com.open.learncode.剑指offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：
 * 一、不分行从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 * 例如：
 * *****8
 * *** / \
 * ***6   10
 * * / \ / \
 * *5 7 9  11
 * 则依次打印8 6 10 5 7 9 11
 * <p>
 * 解题思路：
 * 层序遍历，利用队列queue实现。
 * 从左到右的顺序：先添加左节点，再添加右节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)  空间复杂度：O(1)
 */
public class TestMethod32_1 {

    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {

        public E value;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRight(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode<Integer> node1 = new TreeNode<Integer>(8);
        TreeNode<Integer> node2 = new TreeNode<Integer>(6);
        TreeNode<Integer> node3 = new TreeNode<Integer>(10);
        TreeNode<Integer> node4 = new TreeNode<Integer>(5);
        TreeNode<Integer> node5 = new TreeNode<Integer>(7);
        TreeNode<Integer> node6 = new TreeNode<Integer>(9);
        TreeNode<Integer> node7 = new TreeNode<Integer>(11);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        TreeNode<Integer> root=null;

        method(node1);

        System.out.println();

        method(root);
    }

    /**
     * 层序遍历：BFS
     *
     * @param root
     */
    private static void method(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }
}

