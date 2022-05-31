package com.open.learncode.算法.java.剑指offer.A02_树;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

/**
 * 前序序列：abdgcefh
 * 中序序列：dgbaechf
 * 求：后序序列 gdbehfca
 * *      a
 * *     / \
 * *    b   c
 * *   /   / \
 * *  d   e   f
 * *   \     /
 * *    g   h
 *
 * <p>
 * 链接：https://blog.csdn.net/zhimajiejie/article/details/8056648
 */
public class OT_前中序序列输出后序序列数组 {
    public static void main(String[] args) {
        TreeNode<String> node1 = new TreeNode("a");
        TreeNode<String> node2 = new TreeNode("b");
        TreeNode<String> node3 = new TreeNode("d");
        TreeNode<String> node4 = new TreeNode("g");
        TreeNode<String> node5 = new TreeNode("c");
        TreeNode<String> node6 = new TreeNode("f");
        TreeNode<String> node7 = new TreeNode("h");
        TreeNode<String> node8 = new TreeNode("e");
        node1.setLeftAndRight(node2, node5);
        node2.setLeftAndRight(node3, null);
        node3.setLeftAndRight(null, node4);
        node5.setLeftAndRight(node8, node6);
        node6.setLeftAndRight(node7, null);

        String[] preOrder = {"a", "b", "d", "g", "c", "e", "f", "h"};
        String[] inOrder = {"d", "g", "b", "a", "e", "c", "h", "f"};

        PrintUtils.getInstance().printArray(method(preOrder, inOrder).split(","), "根据前中序递归得到后序序列");
    }

    private static String method(String[] preOrder, String[] inOrder) {
        if (preOrder == null || inOrder == null || inOrder.length <= 0 || preOrder.length != inOrder.length)
            return null;
        return getPostByPreAndMid(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    public static String getPostByPreAndMid(String[] preOrder, String[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;
        String root = preOrder[preLeft];
        int index;
        for (index = inLeft; index <= inRight; index++) {
            if (root.equals(inOrder[index])) break;
        }
        int leftLength = index - inLeft;
        String leftPostOrder = getPostByPreAndMid(preOrder, inOrder, preLeft + 1, preLeft + leftLength, inLeft, inLeft + leftLength - 1);
        String rightPostOrder = getPostByPreAndMid(preOrder, inOrder, preLeft + leftLength + 1, preRight, inLeft + leftLength + 1, inRight);

        String postOrder = "";
        if (leftPostOrder != null && !leftPostOrder.isEmpty()) {
            if (leftPostOrder.endsWith(",")) {
                postOrder += leftPostOrder;
            } else {
                postOrder += leftPostOrder + ",";
            }
        }
        if (rightPostOrder != null && !rightPostOrder.isEmpty()) {
            if (rightPostOrder.endsWith(",")) {
                postOrder += rightPostOrder;
            } else {
                postOrder += rightPostOrder + ",";
            }
        }
        postOrder += root;
        return postOrder;
    }
}