package com.open.learncode.剑指offer;

/**
 * 题目：
 * 数组中的逆序对：在数组中的两个数字，如果前面一个数字大于后面一个数字，则这两个数字组成一组逆序对。
 * 输入一个数组，求出这个数组中逆序对的总数。
 * 例如，在数组{7,5,6,4}中，一共存在5个逆序对，分别是(7，5)、(7，6)、(7，4)、(5，4)、(6，4)
 * <p>
 * 解题思路：
 * 动态规划
 * <p>
 * 复杂度分析：
 * 具体如下
 */

public class TestMethod54 {

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
            TreeNode<Integer> node1 = new TreeNode<Integer>(5);
            TreeNode<Integer> node2 = new TreeNode<Integer>(3);
            TreeNode<Integer> node3 = new TreeNode<Integer>(7);
            TreeNode<Integer> node4 = new TreeNode<Integer>(2);
            TreeNode<Integer> node5 = new TreeNode<Integer>(4);
            TreeNode<Integer> node6 = new TreeNode<Integer>(6);
            TreeNode<Integer> node7 = new TreeNode<Integer>(8);
            node1.setLeftAndRight(node2, node3);
            node2.setLeftAndRight(node4, node5);
            node3.setLeftAndRight(node6, node7);

        System.out.println(method(node1,1));
    }

    static int res;

    private static int method(TreeNode<Integer> root,int k){

        if(root==null||k==0)
            return -1;

        dfs(root,k);

        return res;
    }


    private static void dfs(TreeNode<Integer> root,int k) {

        if(root == null)
            return;
        dfs(root.right,k);
        if(k == 0)
            return;
        if(--k == 0)
            res = root.value;
        dfs(root.left,k);


    }
}
