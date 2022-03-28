package com.open.learncode.算法.java.剑指offer.A02_树;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 二叉树第k层的第一个节点或最后一个节点。
 * <p>
 * 注意：
 * 节点总数 <= 1000。
 * <p>
 * 示例：
 * ======================
 * 示例1：
 * 二叉树如下：
 * *     8
 * *   /  \
 * *  6    10
 * * / \   / \
 * *5  7  9  11
 * 第2层的第一个节点，则返回：6。
 * ======================
 * <p>
 * 解题思路：
 * 利用队列的特性进行操作，再加上两个临时变量
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ32_4_二叉树第k层的第一个或最后一个节点 {

    public static void main(String[] args) {
        // 测试用例
        int[] preOrder = {8, 6, 5, 7, 10, 9, 11};
        int[] inOrder = {5, 6, 7, 8, 9, 10, 11};
        TreeNode<Integer> treeNode = TreeNode.createTreeNode(preOrder, inOrder);
        PrintUtils.getInstance().print(solution1(treeNode, 2).val, "二叉树第2层的第一个节点为");
        PrintUtils.getInstance().print(solution2(treeNode, 3).val, "二叉树第3层的最后一个节点为");
    }

    private static TreeNode<Integer> solution1(TreeNode<Integer> root, int k) {
        if (root == null) return null;

        Queue<TreeNode<Integer>> queue = new LinkedList();
        queue.add(root);
        int row = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (k == row) return temp;
                if (temp != null) {
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
            }
            row++;
        }
        return null;
    }

    private static TreeNode<Integer> solution2(TreeNode<Integer> root, int k) {
        if (root == null) return null;

        Queue<TreeNode<Integer>> queue = new LinkedList();
        queue.add(root);
        int row = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (k == row && i == length - 1) return temp;
                if (temp != null) {
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
            }
            row++;
        }
        return null;
    }
}
