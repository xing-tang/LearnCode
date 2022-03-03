package com.open.learncode.算法.java.剑指offer.A02_树;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.ArrayList;

/**
 * 题目：
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 例如二叉树如下：
 * * *****5
 * * *** / \
 * * ***4  8
 * * * /  / \
 * * *11 13 4
 * * / \   / \
 * *7  2  5  1
 * * sum=22
 * <p>
 * 解题思路：
 * 利用辅助栈的特性
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ34_二叉树和为某一值的路径 {

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

        PrintUtils.getInstance().printIntArrayArrayList(method(node5_1, 22));
    }

    private static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> path = new ArrayList<Integer>();

    /**
     * 打印出二叉树中节点值的和为输入整数的所有路径
     *
     * @param root   根节点
     * @param target 路径和值
     */
    private static ArrayList<ArrayList<Integer>> method(TreeNode<Integer> root, int target) {
        if (root == null) return null;
        preOrder(root, target);
        return list;
    }

    /**
     * 打印出二叉树中节点值的和为输入整数的所有路径
     *
     * @param root   根节点
     * @param target 路径和值
     */
    private static void preOrder(TreeNode<Integer> root, int target) {
        if (root == null) return;

        // 将当前节点加入路径中
        path.add(root.val);
        target -= root.val;
        // 如果当前节点是叶子节点(即没有左右子节点)，并且当前累加值等于期望值，则输出路径信息
        if (root.left == null && root.right == null && target == 0) {
            list.add(new ArrayList<>(path));
        }
        // 如果左子节点不为空，说明不是叶子节点，则继续寻找路径
        preOrder(root.left, target);
        // 如果右子节点不为空，说明不是叶子节点，则继续寻找路径
        preOrder(root.right, target);
        // 如果当前节点不符合要求，则从路径中移除当前节点
        path.remove(path.size() - 1);
    }
}
