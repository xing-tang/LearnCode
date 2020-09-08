package com.open.learncode.算法.剑指offer.J_二叉树相关算法;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 不分行从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如二叉树如下：
 * *    8
 * *   / \
 * *  6   10
 * * / \ / \
 * *5 7 9  11
 * 则依次打印 8 6 10 5 7 9 11
 * <p>
 * 解题思路：
 * 层序遍历，利用队列queue实现。
 * 从左到右的顺序：先添加左节点，再添加右节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)，空间复杂度：O(1)
 */
public class TestMethod32_1 {

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

        System.out.println("不分行从上到下打印二叉树：");
        method(node8);
    }

    /**
     * 层序遍历：BFS
     *
     * @param root 根节点
     */
    private static void method(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
    }
}
