package com.open.learncode.剑指offer;


/**
 * 题目：
 * 树的子结构：输入两棵二叉树A B，判断B是不是A的子结构。
 * 二叉树节点的定义如下：
 * class TreeNode{
 * double value;
 * TreeNode left;
 * TreeNode right;
 * }
 * 二叉树A：          二叉树B：
 * 8              8
 * 8     7        9     2
 * 9   2
 * 4   7
 * 二叉树B是二叉树A的子结构
 * <p>
 * 解题思路：
 * 第一步：在树A中查找与根节点的值一样的节点（递归）
 * 第二步：判断树A中以R为根节点的子树是不是和树B具有相同的结构（递归）
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod26 {

    public static void main(String[] args) {
        // 二叉树A
        TreeNode<Integer> nodeA4 = new TreeNode<Integer>(4);
        TreeNode<Integer> nodeA7_2 = new TreeNode<Integer>(7);
        TreeNode<Integer> nodeA2 = new TreeNode<Integer>(2, nodeA4, nodeA7_2);
        TreeNode<Integer> nodeA9 = new TreeNode<Integer>(9);
        TreeNode<Integer> nodeA8 = new TreeNode<Integer>(8, nodeA9, nodeA2);
        TreeNode<Integer> nodeA7_1 = new TreeNode<Integer>(7);
        TreeNode<Integer> rootA8 = new TreeNode<Integer>(8, nodeA8, nodeA7_1);
        // 二叉树B
        TreeNode<Integer> nodeB9 = new TreeNode<Integer>(9);
        TreeNode<Integer> nodeB2 = new TreeNode<Integer>(2);
        TreeNode<Integer> rootB8 = new TreeNode<Integer>(8, nodeB9, nodeB2);

        System.out.println("二叉树B是不是二叉树A的子结构：" + isSubStructure(rootA8, rootB8));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public static boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.value != B.value) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
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