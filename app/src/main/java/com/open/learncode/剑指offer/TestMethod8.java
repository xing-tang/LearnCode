package com.open.learncode.剑指offer;

/**
 * 题目：
 * 二叉树的下一个节点：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 * <p>
 * 解题思路：
 * 分情况找出下一个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class TestMethod8 {


    /**
     * 二叉树节点
     */
    public static class BinaryTreeNode {
        String val;//节点值
        BinaryTreeNode left;//指向左节点的指针
        BinaryTreeNode right;//指向右节点的指针
        BinaryTreeNode parent;//指向该节点的父亲节点

        BinaryTreeNode(String val) {
            this.val = val;
            left = null;
            right = null;
            parent = null;
        }

    }


    public static void main(String[] args) {

        String inorder[] = {"d", "b", "h", "e", "i", "a", "f", "c", "g"};

        //创建二叉树
        BinaryTreeNode node1 = new BinaryTreeNode("a");
        BinaryTreeNode node2 = new BinaryTreeNode("b");
        BinaryTreeNode node3 = new BinaryTreeNode("c");
        BinaryTreeNode node4 = new BinaryTreeNode("d");
        BinaryTreeNode node5 = new BinaryTreeNode("e");
        BinaryTreeNode node6 = new BinaryTreeNode("f");
        BinaryTreeNode node7 = new BinaryTreeNode("g");
        BinaryTreeNode node8 = new BinaryTreeNode("h");
        BinaryTreeNode node9 = new BinaryTreeNode("i");

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node2.parent = node1;

        node3.left = node6;
        node3.right = node7;
        node3.parent = node1;

        node5.left = node8;
        node5.right = node9;
        node5.parent = node2;

        node4.parent = node2;

        node6.parent = node3;
        node7.parent = node3;

        node8.parent = node5;
        node9.parent = node5;


        method(node1);
        method(node2);
        method(node3);
        method(node4);
        method(node5);
        method(node6);
        method(node7);
        method(node8);
        method(node9);

    }

    /**
     * 找到p节点的下一个节点，分下列几种情况
     * 1、有右子树
     * 2、无右子树 2.1 是其父亲节点的右孩子
     *
     * @param p 给定的一个节点
     * @return
     */
    private static BinaryTreeNode method(BinaryTreeNode p) {


        if (p == null)
            return null;

        BinaryTreeNode cur = p.right;

        // 右子树不为空，它的下一个节点是它的右子树中的最左子节点
        if (cur != null) {
            while (cur.left != null) {
                cur = cur.left;
            }
            System.out.println(p.val + "的下一个节点是：" + cur.val);
            return cur;
        }


        // 右子树为空
        BinaryTreeNode temp = p;
        BinaryTreeNode parent = p.parent;
        //节点是父亲节点的左孩子，下一个节点就是它的父亲节点
        //节点是父亲节点的右孩子，找到其父亲节点的左孩子
        while (parent != null && parent.left != p) {
            p = parent;
            parent = p.parent;

        }

        if (parent == null) {
            System.out.println(temp.val + "没有下一个节点");
            return null;
        }
        System.out.println(temp.val + "的下一个节点是：" + parent.val);
        return parent;


    }
}

