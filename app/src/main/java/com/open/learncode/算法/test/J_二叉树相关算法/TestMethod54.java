package com.open.learncode.算法.test.J_二叉树相关算法;

/**
 * 题目：
 * 给定一颗二叉搜索树，请找出其中第K大的节点。例如，在如下的二叉搜索树中，
 * 按节点数值大小顺序，第三大节点的值是4。
 * * *****5
 * * *** / \
 * * ***3   7
 * * * / \ / \
 * * *2  4 6  8
 * <p>
 * 解题思路：
 * 动态规划
 * <p>
 * 复杂度分析：
 */
public class TestMethod54 {

    public static void main(String[] args) {
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7, node6, node8);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3, node2, node4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5, node3, node7);
        TreeNode<Integer> temp = methodT(node5, 3);
        System.out.println(temp.value);
    }

    public static TreeNode<Integer> methodT(TreeNode<Integer> root, int k) {
        if (root == null || k == 0) return null;
        return method(root, k);
    }

    public static TreeNode<Integer> method(TreeNode<Integer> root, int k) {
        TreeNode<Integer> target = null;
        if (root.right != null) {
            target = method(root.right, k);
        }
        if (target == null) {
            if (k == 0) target = root;
            k--;
        }
        System.out.print(root.value + " ");
        if (target == null && root.left != null) {
            target = method(root.left, k);
        }
        return target;
    }

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

}
