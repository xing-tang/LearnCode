package com.open.learncode.算法.delete;

/**
 * 题目：
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 示例：
 * * *****1
 * * *** / \
 * * ***2   3
 * * * / \   \
 * * *4  5   6
 * * *  /
 * * * 7
 * <p>
 * 解题思路：
 * 递归
 * <p>
 * 复杂度分析：
 * 时间复杂度 O(n)，空间复杂度 O(n)
 */
public class TestMethod55_2 {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5, node7, null);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3, null, node6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node4, node5);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1, node2, node3);
        System.out.println(method(node1));
    }

    /**
     * 递归方法
     * @param root 根节点
     * @return 返回是否是平衡二叉树，是返回true，否返回false
     */
    public static boolean method(TreeNode root) {
        return dfs(root) != -1;
    }

    /**
     * 递归方法
     * @param root 根节点
     * @return 返回是否是平衡二叉树
     */
    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
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
