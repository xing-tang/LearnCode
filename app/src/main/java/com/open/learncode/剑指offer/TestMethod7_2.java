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
 * 示例：
 * *****1
 * *** / \
 * ***2   3
 * * /   / \
 * *4   5  6
 * *\     /
 * *7    8
 * <p>
 * 解题思路：
 * 结合递归思想，利用前序、中序找到根节点，不断细分成左子树和右子树的前序、中序遍历序列，直到序列中只剩唯一的节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class TestMethod7_2 {

    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {

        E value; //节点值
        TreeNode left; //指向左节点的指针
        TreeNode right; //指向右节点的指针

        TreeNode(E value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {

        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inordr[] = {4, 7, 2, 1, 5, 3, 8, 6};
        int postOrder[] = {7, 4, 2, 5, 8, 6, 3, 1};

        System.out.println("根据前中序递归重建二叉树=>打印前序遍历：");
        printPreOrder(method_1_1(preorder, inordr));
        System.out.println();
        System.out.println("根据前中序迭代重建二叉树=>打印前序遍历：");
        printPreOrder(method_1_2(preorder, inordr));
        System.out.println();

        System.out.println("根据中后序递归重建二叉树=>打印前序遍历：");
        printPreOrder(method_2_1(inordr, postOrder));
        System.out.println();

        System.out.println("根据前后序递归重建二叉树=>打印前序遍历：");
        printPreOrder(method_3_1(preorder, postOrder));
        System.out.println();
    }

    /**
     * 递归方法
     * 前中序重建二叉树
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    private static TreeNode method_1_1(int preOrder[], int inOrder[]) {
        if (preOrder == null || inOrder == null
                || preOrder.length <= 0 || inOrder.length <= 0
                || preOrder.length != inOrder.length) {
            return null;
        }
        return method_1_1(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private static TreeNode method_1_1(int preOrder[], int inOrder[], int preLeft, int preRight, int inLeft, int inRight) {

        if (preLeft > preRight || inLeft > inRight) return null;

        TreeNode<Integer> root = new TreeNode<Integer>(preOrder[preLeft]);
        int index;
        for (index = inLeft; index <= inRight; index++) {
            if (root.value == inOrder[index]) break;
        }
        int leftLength = index - inLeft;

        root.left = method_1_1(preOrder, inOrder, preLeft + 1, preLeft + leftLength, inLeft, inLeft + leftLength - 1);
        root.right = method_1_1(preOrder, inOrder, preLeft + leftLength + 1, preRight, inLeft + leftLength + 1, inRight);
        return root;
    }

    /**
     * 迭代方法
     * 前中序重建二叉树
     *
     * @param preorder 先序遍历序列
     * @param inorder  中序遍历序列
     * @return 返回重建二叉树的根节点
     */
    public static TreeNode method_1_2(int[] preorder, int[] inorder) {
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

    private static TreeNode method_2_1(int inOrder[], int postOrder[]) {
        if (inOrder == null || postOrder == null
                || inOrder.length <= 0 || postOrder.length <= 0
                || inOrder.length != postOrder.length) {
            return null;
        }
        return method_2_1(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
    }

    private static TreeNode method_2_1(int inOrder[], int postOrder[], int inLeft, int inRight, int postLeft, int postRight) {

        if (inLeft > inRight || postLeft > postRight) return null;

        TreeNode<Integer> root = new TreeNode<Integer>(postOrder[postRight]);
        int index;
        for (index = inLeft; index <= inRight; index++) {
            if (root.value == inOrder[index]) break;
        }
        int leftLength = index - inLeft;

        root.left = method_2_1(inOrder, postOrder, inLeft, inLeft + leftLength - 1, postLeft, postLeft + leftLength - 1);
        root.right = method_2_1(inOrder, postOrder, inLeft + leftLength + 1, inRight, postLeft + leftLength, postRight - 1);
        return root;
    }

    private static TreeNode method_3_1(int preOrder[], int postOrder[]) {
        if (preOrder == null || postOrder == null
                || preOrder.length <= 0 || postOrder.length <= 0
                || preOrder.length != postOrder.length) {
            return null;
        }
        return method_3_1(preOrder, postOrder, 0, preOrder.length - 1, 0, postOrder.length - 1);
    }

    private static TreeNode method_3_1(int preOrder[], int postOrder[], int preLeft, int preRight, int postLeft, int postRight) {

        if (preLeft == preRight) return new TreeNode(preOrder[preLeft]);
        if (preLeft > preRight || postLeft > postRight) return null;

        TreeNode<Integer> root = new TreeNode<Integer>(preOrder[preLeft]);
        int index;
        for (index = postLeft; index <= postRight; index++) {
            if (preOrder[preLeft + 1] == postOrder[index]) break;
        }
        int leftLength = index - postLeft + 1;

        root.left = method_3_1(preOrder, postOrder, preLeft + 1, preLeft + leftLength, postLeft, postLeft + leftLength - 1);
        root.right = method_3_1(preOrder, postOrder, preLeft + leftLength + 1, preRight, postLeft + leftLength, postRight - 1);
        return root;
    }


//    /**
//     * 递归方法重建二叉树
//     *
//     * @param preorder 先序遍历序列
//     * @param inorder  中序遍历序列
//     * @return 返回重建二叉树的根节点
//     */
//    private static TreeNode method_1(int preorder[], int inorder[]) {
//
//        //鲁棒性
//        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
//            return null;
//        }
//
//        //前序遍历序列的第一个数字是根节点的值
//        TreeNode<Integer> root = new TreeNode<Integer>(preorder[0]);
//        int length = preorder.length;
//
//        //递归终止条件：当只有一个数的时候
//        if (length == 1) {
//            return root;
//        }
//
//        //在中序遍历序列中找到根节点的位置i
//        int rootValue = root.value;
//        int inorderIndex;//标记根节点的位置
//        for (inorderIndex = 0; inorderIndex < length; inorderIndex++) {
//            if (rootValue == inorder[inorderIndex])
//                break;
//        }
//
//        //创建左子树
//        if (inorderIndex > 0) {
//            //根节点左边还有i个数
//            int[] pre = new int[inorderIndex];
//            int[] in = new int[inorderIndex];
//            for (int j = 0; j < inorderIndex; j++) {
//                pre[j] = preorder[j + 1];
//                in[j] = inorder[j];
//            }
//            root.left = method_1(pre, in);
//        } else {
//            root.left = null;
//        }
//
//        //创建右子树
//        if (length - inorderIndex - 1 > 0) {
//            //根节点的右边还有length-i-1个数
//            int[] pre = new int[length - inorderIndex - 1];
//            int[] in = new int[length - inorderIndex - 1];
//            for (int j = inorderIndex + 1; j < length; j++) {
//                pre[j - inorderIndex - 1] = preorder[j];
//                in[j - inorderIndex - 1] = inorder[j];
//            }
//            root.right = method_1(pre, in);
//        } else {
//            root.right = null;
//        }
//
//        return root;
//
//    }

    private static void printPreOrder(TreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.value + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }


}

