package com.old.old.delete;

import com.open.learncode.算法.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 从上到下打印出二叉树的每个节点。同一层的节点按照从左到右的顺序打印,
 * 每一层打印到一行里。例如二叉树如下：
 * *      8
 * *     / \
 * *    6  10
 * *   / \ / \
 * *  5  7 9  11
 * 则依次打印出：
 * 8
 * 6，10
 * 5，7，9，11
 * <p>
 * 解题思路：
 * 利用队列的特性进行操作，再加上两个临时变量
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)【队列用到的最大空间是存储最下面一层的节点的时候】
 */
public class TestMethod32_2 {
    
    public static void main(String[] args) {
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node11 = new TreeNode<Integer>(11);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6, node5, node7);
        TreeNode<Integer> node10 = new TreeNode<Integer>(10, node9, node11);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8, node6, node10);

        System.out.println("分行打印二叉树：");
        method(node8);
    }

    private static void method(TreeNode<Integer> root) {
        if (root == null) return;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            System.out.println();
        }
    }
}
