package com.open.learncode.剑指offer;

import com.open.learncode.java.stack.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：
 * 三、之字形打印二叉树
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三层再按照从左到右的顺序打印，其他航以此类推。
 * 例如：
 * ******1
 * *** /  \
 * ***2    3
 * * / \  / \
 * *4  5 6  7
 * 则依次打印
 * 1
 * 3 2
 * 4 5 6 7
 * <p>
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(1)  空间复杂度：O(1)
 */
public class TestMethod32_3 {

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
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        //根节点为null
        TreeNode<Integer> root = null;

        //只有一个节点的二叉树
        TreeNode<Integer> root2 = new TreeNode<Integer>(8);
        ;

        method(node1);
        System.out.println();
        method(root);
        System.out.println();
        method(root2);
    }


    private static void method(TreeNode root) {

        if (root == null)
            return ;

        //栈stack1 pop：从左到右
        Stack<TreeNode> stack1 = new Stack<>();
        //栈stack2 pop：从右到左
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        ////如果两个栈都为空，那么表示已经遍历完了二叉树
        while (!stack1.isEmpty() || !stack2.isEmpty()) {


            //把栈1中的元素都pop()到vector中，并且把节点的左,右节点push到栈2中
            if (!stack1.empty()) {

                while (!stack1.empty()) {
                    TreeNode node = stack1.peek();
                    stack1.pop();
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }


            }
            //把栈2中的元素都pop()到vector中，并且把节点的右,左节点push到栈1中
            else if (!stack2.empty()) {

                while (!stack2.empty()) {
                    TreeNode node = stack2.pop();

                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }

            }
        }

    }
}

