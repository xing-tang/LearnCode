package com.open.learncode.剑指offer.每日回顾.day_01;

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

        System.out.println();
        System.out.println("根据前中序迭代重建二叉树=>打印前序遍历：");

        System.out.println();

        System.out.println("根据中后序递归重建二叉树=>打印前序遍历：");

        System.out.println();

        System.out.println("根据前后序递归重建二叉树=>打印前序遍历：");

        System.out.println();
    }


}

