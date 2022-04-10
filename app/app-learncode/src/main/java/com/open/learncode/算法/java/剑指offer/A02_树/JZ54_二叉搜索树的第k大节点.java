package com.open.learncode.算法.java.剑指offer.A02_树;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.Stack;

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
public class JZ54_二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        // 测试用例
        TreeNode<Integer> node2 = new TreeNode(2);
        TreeNode<Integer> node4 = new TreeNode(4);
        TreeNode<Integer> node6 = new TreeNode(6);
        TreeNode<Integer> node8 = new TreeNode(8);
        TreeNode<Integer> node7 = new TreeNode(7, node6, node8);
        TreeNode<Integer> node3 = new TreeNode(3, node2, node4);
        TreeNode<Integer> node5 = new TreeNode(5, node3, node7);

        PrintUtils.getInstance().print(solution(node5, 3));
    }

    private static int solution(TreeNode<Integer> root, int k) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (root == null || k == 0) return -1;

        Stack<TreeNode> stack = new Stack();
        TreeNode<Integer> curr = root;
        TreeNode<Integer> temp = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            temp = stack.pop();
            k--;
            if (k == 0) return temp.val;
            if (temp.right != null) {
                curr = temp.right;
            }
        }
        return -1;
    }
}
