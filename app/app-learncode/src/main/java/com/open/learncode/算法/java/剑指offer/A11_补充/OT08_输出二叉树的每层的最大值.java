package com.open.learncode.算法.java.剑指offer.A11_补充;


import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 输出二叉树的每层的最大值：给一个二叉树，输出这个二叉树每一层最大的值。
 * * *    8
 * * *   / \
 * * *  6   10
 * * * / \ / \
 * * *5 7 9  11
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(n)。
 */
public class OT08_输出二叉树的每层的最大值 {

    public static void main(String[] args) {
        // 测试用例
        TreeNode<Integer> node5 = new TreeNode(5);
        TreeNode<Integer> node7 = new TreeNode(7);
        TreeNode<Integer> node9 = new TreeNode(9);
        TreeNode<Integer> node11 = new TreeNode(11);
        TreeNode<Integer> node6 = new TreeNode(6, node5, node7);
        TreeNode<Integer> node10 = new TreeNode(10, node9, node11);
        TreeNode<Integer> node8 = new TreeNode(8, node6, node10);
        PrintUtils.getInstance().printArrayList(solution(node8));
    }

    private static ArrayList<Integer> solution(TreeNode<Integer> root) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        if (root == null) return null;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list = new ArrayList();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                max = max > node.val ? max : node.val;
            }
            list.add(max);
        }
        return list;
    }
}
