package com.old.old.wcopy.leetcode_剑指offer.A9_二叉树相关算法;

import com.open.learncode.java.stack.Stack;
import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

/**
 * 题目：
 * 把搜索二叉树的后序数组重新反转成搜索二叉树，
 * 后续数组为{3,5,4,7,9,8,6}，输出二叉树的根节点。
 * 例如二叉树如下：
 * * *****6
 * * *** / \
 * * ***4   8
 * * * / \ / \
 * * *3  5 7  9
 * 前序：{6,4,3,5,8,7,9}
 * 中序：{3,4,5,6,7,8,9}
 * 后序：{3,5,4,7,9,8,6}
 * 层序：{6,4,8,3,5,7,9}
 * <p>
 * 解题思路：
 * 利用二叉树和后续遍历特性+栈
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class OT_前序数组重建二分搜索树 {
    public static void main(String[] args) {
        int[] preArr = {6, 4, 3, 5, 8, 7, 9};
        PrintUtils.getInstance().printArray(preArr);
        PrintUtils.getInstance().printCenterTreeNode(method(preArr));
    }

    public static TreeNode<Integer> method(int[] arr) {
        if (arr == null || arr.length <= 0) ;
        if (arr.length == 1) return new TreeNode<Integer>(arr[0]);

        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> tempRoot = new TreeNode<Integer>(arr[0]);
        TreeNode<Integer> root = tempRoot;
        stack.push(tempRoot);

        for (int i = 1; i < arr.length; i++) {
            tempRoot = stack.peek();
            while (!stack.isEmpty() && stack.peek().val <= arr[i]) {
                tempRoot = stack.pop();
            }
            if (tempRoot.val >= arr[i]) {
                tempRoot.left = new TreeNode<Integer>(arr[i]);
                tempRoot = tempRoot.left;
            } else {
                tempRoot.right = new TreeNode<Integer>(arr[i]);
                tempRoot = tempRoot.right;
            }

            stack.add(tempRoot);
        }
        return root;
    }
}
