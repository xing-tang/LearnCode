package com.open.learncode.算法.java.剑指offer.A02_树;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：
 * 之字形打印二叉树：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 * 则返回：{{8},{10,6},{5,7,9,11}}
 * ======================
 * <p>
 * 解题思路：
 * 双栈+奇数偶数帕努单。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(n)。
 */
public class JZ32_3_之字形打印二叉树 {

    public static void main(String[] args) {
        // 测试用例
        int[] preOrder = {8, 6, 5, 7, 10, 9, 11};
        int[] inOrder = {5, 6, 7, 8, 9, 10, 11};
        TreeNode<Integer> treeNode = TreeNode.createTreeNode(preOrder, inOrder);
        PrintUtils.getInstance().printIntArrayArrayList(solution(treeNode), "之字形打印二叉树");
    }

    /**
     * 之字形打印二叉树
     *
     * @param root 根节点
     */
    private static ArrayList<ArrayList<Integer>> solution(TreeNode<Integer> root) {
        if (root == null) return new ArrayList<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList();
        // stack1 stack2分别存储奇数层、偶数层的节点
        Stack<TreeNode<Integer>> stack1 = new Stack();
        Stack<TreeNode<Integer>> stack2 = new Stack();
        stack1.add(root);
        boolean flag = true;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> tempList = new ArrayList();
            if (flag) {// 奇数层
                while (!stack1.isEmpty()) {
                    TreeNode<Integer> temp = stack1.pop();
                    tempList.add(temp.val);
                    // 要倒序打印，必须正序压入
                    if (temp.left != null) stack2.add(temp.left);
                    if (temp.right != null) stack2.add(temp.right);
                }
            } else {// 偶数层
                while (!stack2.isEmpty()) {
                    TreeNode<Integer> temp = stack2.pop();
                    tempList.add(temp.val);
                    // 要正序打印，必须倒序压入
                    if (temp.right != null) stack1.add(temp.right);
                    if (temp.left != null) stack1.add(temp.left);
                }
            }
            list.add(tempList);
            flag = !flag;
        }
        return list;
    }
}
