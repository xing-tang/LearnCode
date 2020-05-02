package com.open.learncode.剑指offer;


/**
 * 题目：
 * 二叉搜索树的后序遍历序列：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果
 * 返回值为Boolean类型。假设输入的数组的任意两个数字都互不相同。
 * 例如：输入数组{5,7,6,9,11,10,8}，则返回true，因为这个整数序列是二叉搜索树的后序遍历结果
 * 如果输入的数组是{7,4,6,5}，则由于没有哪棵二叉搜索树的后序遍历结果是这个序列，因此返回false
 * ******8
 * *** /  \
 * ***6   10
 * * / \  / \
 * *5  7 9  11
 * <p>
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n^2)，空间复杂度：O(n)
 */
public class TestMethod33 {

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

        int[] postorder = {5, 7, 6, 9, 11, 10, 8};
        int[] postorder2 = {7,4,6,5};
        System.out.println("这个整数序列是否为二叉搜索树的后序遍历结果:"+ method_1(postorder, 0, postorder.length - 1));
        System.out.println("这个整数序列是否为二叉搜索树的后序遍历结果:"+ method_1(postorder2, 0, postorder2.length - 1));
    }

    /**
     * 递归
     *
     * @param postorder
     */
    private static boolean method_1(int[] postorder, int start, int end) {

        if (postorder == null || postorder.length <= 0)
            return false;

        //递归终止条件
        if (start >= end) return true;

        int p = start;
        while (postorder[p] < postorder[end])
            p++;

        int m=p;
        while (postorder[p] > postorder[end])
            p++;


        return p == end && method_1(postorder, start, m - 1) && method_1(postorder, m, end - 1);

    }

}

