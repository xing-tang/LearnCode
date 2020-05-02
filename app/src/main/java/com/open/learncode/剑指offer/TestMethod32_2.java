package com.open.learncode.剑指offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：
 * 二、分行从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印，每一层打印一行
 * 例如：
 * *****8
 * *** / \
 * ***6   10
 * * / \ / \
 * *5 7 9  11
 * 则依次打印
 * 8
 * 6 10
 * 5 7 9 11
 * <p>
 * 解题思路：
 * 分行打印，设置两个计数器：nextLevel来计算下一层的个数，使用toBeList计算这层还没有打印完的个数
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(n)
 */
public class TestMethod32_2 {

    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {

        public E value;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRight(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        //完全二叉树
        TreeNode<Integer> node1 = new TreeNode<Integer>(8);
        TreeNode<Integer> node2 = new TreeNode<Integer>(6);
        TreeNode<Integer> node3 = new TreeNode<Integer>(10);
        TreeNode<Integer> node4 = new TreeNode<Integer>(5);
        TreeNode<Integer> node5 = new TreeNode<Integer>(7);
        TreeNode<Integer> node6 = new TreeNode<Integer>(9);
        TreeNode<Integer> node7 = new TreeNode<Integer>(11);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        //根节点为null
        TreeNode<Integer> root = null;

        //只有一个节点的二叉树
        TreeNode<Integer> root2 = new TreeNode<Integer>(8);;

        method(node1);
        System.out.println();
        method(root);
        System.out.println();
        method(root2);
    }


    private static void method(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new ArrayDeque<>();

        //nextLevel来计算下一层的个数，使用toBeList计算这层还没有打印完的个数
        //初始化ToBeList=0.因为最少有一个节点（如根节点）
        int nextLevel = 0, toBeList = 1;

        queue.add(root);

        while (!queue.isEmpty()) {

            //出栈
            TreeNode temp = queue.remove();
            toBeList--;
            System.out.print(temp.value + " ");

            if (temp.left != null) {
                //入栈
                queue.add(temp.left);
                nextLevel++;
            }
            if (temp.right != null) {
                //入栈
                queue.add(temp.right);
                nextLevel++;
            }

            //若toBeList为0 ==> 当前层已经打印结束
            if(toBeList==0){
                //将计数器置于初始状态
                toBeList=nextLevel;
                nextLevel=0;
                //换行
                System.out.println();
            }
        }
    }
}

