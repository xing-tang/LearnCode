package com.open.learncode.剑指offer.每日回顾.day_01;

/**
 * 题目：
 * 二叉树的下一个节点：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * 示例：测试b、d、e，分别对应三种情况
 * *****a
 * *** / \
 * ***b   c
 * * /\  / \
 * *d e f  g
 * <p>
 * 解题思路：
 * 分情况找出下一个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class TestMethod8 {

    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {
        public E value;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针
        public TreeNode parent;//指向该节点的父亲节点

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRightAndParent(TreeNode left, TreeNode right, TreeNode parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        //创建二叉树
        TreeNode<String> nodeA = new TreeNode<String>("a");
        TreeNode<String> nodeB = new TreeNode<String>("b");
        TreeNode<String> nodeC = new TreeNode<String>("c");
        TreeNode<String> nodeD = new TreeNode<String>("d");
        TreeNode<String> nodeE = new TreeNode<String>("e");
        TreeNode<String> nodeF = new TreeNode<String>("f");
        TreeNode<String> nodeG = new TreeNode<String>("g");
        nodeA.setLeftAndRightAndParent(nodeB, nodeC, null);
        nodeB.setLeftAndRightAndParent(nodeD, nodeE, nodeA);
        nodeC.setLeftAndRightAndParent(nodeF, nodeG, nodeA);
        nodeE.setLeftAndRightAndParent(null, null, nodeB);
        nodeD.setLeftAndRightAndParent(null, null, nodeB);
        nodeF.setLeftAndRightAndParent(null, null, nodeC);
        nodeG.setLeftAndRightAndParent(null, null, nodeC);

        // 分别获取节点b、d、e、g的下一个节点

    }

}

