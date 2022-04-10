package com.old.old.wcopy.每日回顾.day_01;

import com.open.learncode.算法.base.TreeNode;

/**
 * 题目：
 * 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：输入前序遍历序列{1,2,4,5,3,6,7}和中序遍历序列{4,2,5,1,6,3,7}，
 * 则重建此二叉树并输出它的根节点
 * 示例：
 * ******1
 * *** /   \
 * ***2     3
 * * / \   / \
 * *4  5  6   7
 * 前序遍历: 1 2 4 5 3 6 7
 * 中序遍历: 4 2 5 1 6 3 7
 * 后序遍历: 4 5 2 6 7 3 1
 * <p>
 * 解题思路：
 * 结合递归思想，利用前序、中序找到根节点，不断细分成左子树和右子树的前序、中序遍历序列，直到序列中只剩唯一的节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，[【解析】](https://github.com/xing-tang/LearnCode/blob/master/app/src/main/java/com/open/learncode/%E5%89%91%E6%8C%87offer/TestMethod4.java)空间复杂度：O(n)
 */
public class TestMethod7_2 {
    
    public static void main(String[] args) {
        int preorder[] = {1, 2, 4, 5, 3, 6, 7};
        int inordr[] = {4, 2, 5, 1, 6, 3, 7};
        int postOrder[] = {4, 5, 2, 6, 7, 3, 1};

        System.out.println("根据前中序递归重建二叉树=>打印前序遍历：");
        printPreOrder(method_1(preorder, inordr));
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
    private static TreeNode method_1(int preOrder[], int inOrder[]) {
        if (preOrder == null || inOrder == null
                || preOrder.length <= 0 || inOrder.length <= 0 || preOrder.length != inOrder.length)
            return null;
        return method_1(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private static TreeNode method_1(int preOrder[], int inOrder[], int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;

        TreeNode<Integer> root = new TreeNode<Integer>(preOrder[preLeft]);
        int index;
        for (index = inLeft; index <= inRight; index++) {
            if (root.val == inOrder[index]) break;
        }
        int leftLength = index - inLeft;

        root.left = method_1(preOrder, inOrder, preLeft + 1, preLeft + leftLength, inLeft, inLeft + leftLength - 1);
        root.right = method_1(preOrder, inOrder, preLeft + leftLength + 1, preRight, inLeft + leftLength + 1, inRight);
        return root;
    }

    /**
     * 递归方法
     * 中后续重建二叉树
     *
     * @param inOrder   中序遍历序列
     * @param postOrder 后续遍历序列
     * @return 返回重建二叉树的根节点
     */
    private static TreeNode method_2_1(int inOrder[], int postOrder[]) {
        if (inOrder == null || postOrder == null
                || inOrder.length <= 0 || postOrder.length <= 0 || inOrder.length != postOrder.length)
            return null;
        return method_2_1(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
    }

    private static TreeNode method_2_1(int inOrder[], int postOrder[], int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) return null;

        TreeNode<Integer> root = new TreeNode<Integer>(postOrder[postRight]);
        int index;
        for (index = inLeft; index <= inRight; index++) {
            if (root.val == inOrder[index]) break;
        }
        int leftLenght = index - inLeft;
        root.left = method_2_1(inOrder, postOrder, inLeft, inLeft + leftLenght - 1, postLeft, postLeft + leftLenght - 1);
        root.right = method_2_1(inOrder, postOrder, inLeft + leftLenght + 1, inRight, postLeft + leftLenght, postRight - 1);
        return root;
    }


    /**
     * 递归方法
     * 前后续重建二叉树
     *
     * @param preOrder  前序遍历序列
     * @param postOrder 后续遍历序列
     * @return 返回重建二叉树的根节点
     */
    private static TreeNode method_3_1(int preOrder[], int postOrder[]) {
        if (preOrder == null || postOrder == null
                || preOrder.length <= 0 || postOrder.length <= 0 || preOrder.length != postOrder.length)
            return null;
        return method_3_1(preOrder, postOrder, 0, preOrder.length - 1, 0, postOrder.length - 1);
    }

    private static TreeNode method_3_1(int preOrder[], int postOrder[], int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft == preRight) return new TreeNode<Integer>(preOrder[preLeft]);
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

    /**
     * 打印重建二叉树后的前序遍历
     *
     * @param root
     */
    private static void printPreOrder(TreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }
}

