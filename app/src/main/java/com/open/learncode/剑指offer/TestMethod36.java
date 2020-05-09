package com.open.learncode.剑指offer;


import learncode.open.com.learncode.R;

/**
 * 题目：
 * 二叉搜索树与双向链表：输入一棵二叉树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。比如：
 * *****10
 * *** /  \
 * ***6    14
 * * / \  / \
 * *4  8 12  16
 * 转换之后的排序双向链表：
 * 4<=>6<=>8<=>10<=>12<=>14<=>16
 * <p>
 * 解题思路：
 * 二叉搜索树的中序遍历为递增序列
 * 排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点；
 * 双向链表： 在构建相邻节点（设前驱节点 prepre ，当前节点 curcur ）关系时，不仅应 pre.right = curpre.right=cur ，也应 cur.left = precur.left=pre 。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod36 {


    //用于储存中序遍历当前的节点，作为中间变量，将双向指针链接起来
    public static TreeNode pre = null;
    //递归到最深层，返回双向链表的头
    public static TreeNode head = null;

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


        TreeNode<Integer> node1 = new TreeNode<Integer>(10);
        TreeNode<Integer> node2 = new TreeNode<Integer>(6);
        TreeNode<Integer> node3 = new TreeNode<Integer>(14);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(8);
        TreeNode<Integer> node6 = new TreeNode<Integer>(12);
        TreeNode<Integer> node7 = new TreeNode<Integer>(16);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        TreeNode tail=null;
        TreeNode head = method(node1);

        //从头开始打印双向链表
        while (head != null) {
            System.out.print(head.value + " ");
            if (head.right == null)
                tail = head;
            head = head.right;
        }
        System.out.println();

        //从尾开始打印双向链表
        while (tail != null) {
            System.out.print(tail.value + " ");
            tail = tail.left;

        }
    }

    /**
     * 递归
     *
     * @param node
     * @return
     */
    private static TreeNode method(TreeNode node) {
        //遍历到最深处节点为空进行返回
        if (node == null)
            return null;

        //左递归
        method(node.left);

        /*
         中序遍历在中间进行处理：
         */
        //利用pre将彼此互相指向
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }

        //pre移位
        pre = node;

        //递归到最深处才将头赋值，也就是双向链表的头
        if (head == null) {
            head = node;
        }

        //右递归
        method(node.right);

        return head;
    }
}