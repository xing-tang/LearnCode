package com.open.learncode.算法.old.wcopy.leetcode_快手;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class KS6_计算二叉树个数 {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node5_2 = new TreeNode<Integer>(5);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node11 = new TreeNode<Integer>(11, node7, node2);
        TreeNode<Integer> node13 = new TreeNode<Integer>(13);
        TreeNode<Integer> node4_2 = new TreeNode<Integer>(4, node5_2, node1);
        TreeNode<Integer> node4_1 = new TreeNode<Integer>(4, node11, null);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8, node13, node4_2);
        TreeNode<Integer> node5_1 = new TreeNode<Integer>(5, node4_1, node8);

        PrintUtils.getInstance().print(method(node5_1));
    }

    private static int method(TreeNode<Integer> root) {
        if (root == null) return 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode<Integer> temp = null;
        int count = 0;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            count++;
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        return count;
    }
}
