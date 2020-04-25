package com.open.learncode.剑指offer.test;

import java.util.Stack;

/**
 * 题目：前中后序遍历
 *      1
 *   2    3
 * 4  5  6  7
 */
public class TestMethod7_1 {

    //二叉树节点
    public static class TreeNode<E>{
        E val;
        TreeNode left;
        TreeNode rigth;

        TreeNode(E val){
            this.val=val;
        }

        public void setLeftAndRight(TreeNode left,TreeNode rigth){
            this.left=left;
            this.rigth=rigth;
        }
    }

    public static void main(String[] args) {

        TreeNode<Integer> node1=new TreeNode<>(1);
        TreeNode<Integer> node2=new TreeNode<>(2);
        TreeNode<Integer> node3=new TreeNode<>(3);
        TreeNode<Integer> node4=new TreeNode<>(4);
        TreeNode<Integer> node5=new TreeNode<>(5);
        TreeNode<Integer> node6=new TreeNode<>(6);
        TreeNode<Integer> node7=new TreeNode<>(7);

        node1.setLeftAndRight(node2,node3);
        node2.setLeftAndRight(node4,node5);
        node3.setLeftAndRight(node6,node7);

        System.out.print("递归前序遍历：");
        preOrder_1(node1);
        System.out.println();
        System.out.print("迭代前序遍历：");
        preOrder_2(node1);
        System.out.println();

        System.out.print("递归中序遍历：");
        inOrder_1(node1);
        System.out.println();
        System.out.print("迭代中序遍历：");
        inOrder_2(node1);
        System.out.println();

        System.out.print("递归后序遍历：");
        postOrder_1(node1);
        System.out.println();

    }

    //前序：根左右
    private static void preOrder_1(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        preOrder_1(root.left);
        preOrder_1(root.rigth);
    }

    private static void preOrder_2(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()){
            cur=stack.pop();
            System.out.print(cur.val+" ");
            if(cur.rigth!=null)
                stack.push(cur.rigth);
            if(cur.left!=null)
                stack.push(cur.left);
        }
    }

    //中序：左根右
    private static void inOrder_1(TreeNode root){
        if(root==null)
            return;
        inOrder_1(root.left);
        System.out.print(root.val+" ");
        inOrder_1(root.rigth);
    }

    private static void inOrder_2(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty() || cur!=null){

            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            TreeNode temp=stack.pop();
            System.out.print(temp.val+" ");

            if(temp.rigth!=null)
                cur=temp.rigth;
        }
    }

    //后序：左右根
    private static void postOrder_1(TreeNode root){
        if(root==null)
            return;
        postOrder_1(root.left);
        postOrder_1(root.rigth);
        System.out.print(root.val+" ");
    }

    private static void postOrder_2(TreeNode root){
        if(root==null)
            return;

    }

}

