package com.open.learncode.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class TestMethod7 {


    /**
     * 二叉树节点
     */
    public static class TreeNode {

        int value;//节点值
        TreeNode left;//指向左节点的指针
        TreeNode right;//指向右节点的指针

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inordr[] = {4, 7, 2, 1, 5, 3, 8, 6};
        int length = preorder.length;
        System.out.println("头节点的值为：" + method(preorder, inordr, length).value);
    }

    /**
     * @param preorder 先序遍历序列
     * @param inorder  中序遍历序列
     * @return
     */
    private static TreeNode method(int preorder[], int inorder[], int length) {

        //鲁棒性
        if (preorder == null || inorder == null || length <= 0) {
            return null;
        }

        //前序遍历序列的第一个数字是根节点的值
        TreeNode root = new TreeNode(preorder[0]);


        //递归终止条件：当只有一个数的时候
        if (length == 1) {
            return root;
        }

        //在中序遍历序列中找到根节点的位置i
        int rootValue = root.value;
        int i;//标记根节点的位置
        for (i = 0; i < length; i++) {
            if (rootValue == inorder[i])
                break;
        }

        //创建左子树
        if (i > 0) {
            //根节点左边还有i个数
            int[] pre = new int[i];
            int[] in = new int[i];
            for (int j = 0; j < i; j++) {
                pre[j] = preorder[j + 1];
                in[j] = inorder[j];
            }
            root.left = method(pre, in, pre.length);
        } else {
            root.left = null;
        }

        //创建右子树
        if (length - i - 1 > 0) {
            //根节点的右边还有length-i-1个数
            int[] pre = new int[length - i - 1];
            int[] in = new int[length - i - 1];
            for (int j = i + 1; j < length; j++) {
                in[j - i - 1] = inorder[j];
                pre[j - i - 1] = preorder[j];
            }
            root.right = method(pre, in, pre.length);
        } else {
            root.right = null;
        }

        return root;

    }


}

