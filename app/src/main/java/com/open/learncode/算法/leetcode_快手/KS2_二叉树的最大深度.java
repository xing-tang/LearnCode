package com.open.learncode.算法.leetcode_快手;


import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）
 * 形成树的一条路径，最长路径的长度为树的深度。
 * * *****1
 * * *** / \
 * * ***2   3
 * * * / \   \
 * * *4  5   6
 * * *  /
 * * * 7
 * <p>
 * 解题思路：
 * 递归、层序遍历
 * <p>
 * 复杂度分析：
 * 方法二：时间复杂度 O(n)，空间复杂度：O(n)【最差情况下（当树平衡时）】
 */
public class KS2_二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5, node7, null);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3, null, node6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node4, node5);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1, node2, node3);

        PrintUtils.getInstance().print(method(node1));
    }

    private static int method(TreeNode<Integer> root) {
        if (root == null) return 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            count++;
        }
        return count;
    }
}
