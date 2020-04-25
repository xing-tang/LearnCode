package com.open.learncode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：
 * 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建此二叉树并输出它的根节点
 * <p>
 * 解题思路：
 * 结合递归思想，利用前序、中序找到根节点，不断细分成左子树和右子树的前序、中序遍历序列，直到序列中只剩唯一的节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class TestMethod7_2 {


    public static void main(String[] args) {

        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inordr[] = {4, 7, 2, 1, 5, 3, 8, 6};
        int length = preorder.length;
        System.out.println("头节点的值为：" + method_1(preorder, inordr).value);
        System.out.println("头节点的值为：" + method_2(preorder, inordr).value);
        System.out.println();
    }


    /**
     * 递归方法重建二叉树
     *
     * @param preorder 先序遍历序列
     * @param inorder  中序遍历序列
     * @return 返回重建二叉树的根节点
     */
    private static TreeNode method_1(int preorder[], int inorder[]) {

        //鲁棒性
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }

        //前序遍历序列的第一个数字是根节点的值
        TreeNode<Integer> root = new TreeNode<Integer>(preorder[0]);
        int length = preorder.length;

        //递归终止条件：当只有一个数的时候
        if (length == 1) {
            return root;
        }

        //在中序遍历序列中找到根节点的位置i
        int rootValue = root.value;
        int inorderIndex;//标记根节点的位置
        for (inorderIndex = 0; inorderIndex < length; inorderIndex++) {
            if (rootValue == inorder[inorderIndex])
                break;
        }

        //创建左子树
        if (inorderIndex > 0) {
            //根节点左边还有i个数
            int[] pre = new int[inorderIndex];
            int[] in = new int[inorderIndex];
            for (int j = 0; j < inorderIndex; j++) {
                pre[j] = preorder[j + 1];
                in[j] = inorder[j];
            }
            root.left = method_1(pre, in);
        } else {
            root.left = null;
        }

        //创建右子树
        if (length - inorderIndex - 1 > 0) {
            //根节点的右边还有length-i-1个数
            int[] pre = new int[length - inorderIndex - 1];
            int[] in = new int[length - inorderIndex - 1];
            for (int j = inorderIndex + 1; j < length; j++) {
                in[j - inorderIndex - 1] = inorder[j];
                pre[j - inorderIndex - 1] = preorder[j];
            }
            root.right = method_1(pre, in);
        } else {
            root.right = null;
        }

        return root;

    }

    /**
     * 迭代方法重建二叉树
     *
     * @param preorder 先序遍历序列
     * @param inorder  中序遍历序列
     * @return 返回重建二叉树的根节点
     */
    public static TreeNode method_2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<Integer>(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if ((int) node.value != inorder[inorderIndex]) {
                node.left = new TreeNode<Integer>(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && (int) stack.peek().value == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode<Integer>(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {

        E value;//节点值
        TreeNode left;//指向左节点的指针
        TreeNode right;//指向右节点的指针

        TreeNode(E value) {
            this.value = value;
        }
    }

}

