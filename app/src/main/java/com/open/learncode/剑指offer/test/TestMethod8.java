package com.open.learncode.剑指offer.test;

/**
 * 题目：
 * 二叉树的下一个节点：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 *      a
 *   b     c
 * d  e  f   g
 *   h i
 */
public class TestMethod8 {

    //二叉树节点
    public static class TreeNode<E>{
        E val;
        TreeNode left;
        TreeNode rigth;
        TreeNode parent;

        TreeNode(E val){
            this.val=val;
        }

        public void setLeftAndRightAndParent(TreeNode left,TreeNode rigth,TreeNode parent){
            this.left=left;
            this.rigth=rigth;
            this.parent=parent;
        }
    }

    public static void main(String[] args) {

        TreeNode<String> nodeA=new TreeNode<>("a");
        TreeNode<String> nodeB=new TreeNode<>("b");
        TreeNode<String> nodeC=new TreeNode<>("c");
        TreeNode<String> nodeD=new TreeNode<>("d");
        TreeNode<String> nodeE=new TreeNode<>("e");
        TreeNode<String> nodeF=new TreeNode<>("f");
        TreeNode<String> nodeG=new TreeNode<>("g");
        TreeNode<String> nodeH=new TreeNode<>("h");
        TreeNode<String> nodeI=new TreeNode<>("i");

        nodeA.setLeftAndRightAndParent(nodeB,nodeC,null);
        nodeB.setLeftAndRightAndParent(nodeD,nodeE,nodeA);
        nodeC.setLeftAndRightAndParent(nodeF,nodeG,nodeA);
        nodeD.setLeftAndRightAndParent(null,null,nodeB);
        nodeE.setLeftAndRightAndParent(nodeH,nodeI,nodeB);
        nodeF.setLeftAndRightAndParent(null,null,nodeC);
        nodeG.setLeftAndRightAndParent(null,null,nodeC);
        nodeH.setLeftAndRightAndParent(null,null,nodeE);
        nodeI.setLeftAndRightAndParent(null,null,nodeE);

        method(nodeA);
        method(nodeB);
        method(nodeC);
        method(nodeD);
        method(nodeE);
        method(nodeF);
        method(nodeG);
        method(nodeH);
        method(nodeI);
    }

    private static TreeNode method(TreeNode node){
        //鲁棒性
        if (node==null)
            return null;

        TreeNode cur=node.rigth;

        //有右子树
        if (cur!=null){
            while (cur.left!=null){
                cur=cur.left;
            }
            System.out.println(node.val+"的下一个节点是："+cur.val);
            return cur;
        }

        //无右子树
        TreeNode p=node;
        TreeNode parent=node.parent;

        //1、是其父亲节点的右孩子
        while (parent!=null && parent.left!=p){
            p=parent;
            parent=p.parent;
        }

        if(parent==null){
            System.out.println(node.val+"没有下一个节点");
            return parent;
        }

        System.out.println(node.val+"的下一个节点是："+parent.val);

        //2、是其父亲节点的左孩子
        return parent;


    }


}

