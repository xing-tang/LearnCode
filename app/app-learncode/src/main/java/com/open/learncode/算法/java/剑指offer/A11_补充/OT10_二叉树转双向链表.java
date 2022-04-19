package com.open.learncode.算法.java.剑指offer.A11_补充;


import com.open.learncode.算法.base.TreeNode;

import java.util.Stack;

/**
 * 题目：
 * 二叉树转双向链表：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 例如二叉搜索树如下：
 * * *****10
 * * *** /  \
 * * ***6   14
 * * * / \  / \
 * * *4  8 12 16
 * 则转换成排序的双向链表为：
 * 4<=>6<=>8<=>10<=>12<=>14<=>16
 * <p>
 * 解题思路：
 * 递归或者利用辅助栈
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class OT10_二叉树转双向链表 {

    public static void main(String[] args) {
        // 测试用例
        TreeNode<Integer> node4 = new TreeNode(4);
        TreeNode<Integer> node8 = new TreeNode(8);
        TreeNode<Integer> node12 = new TreeNode(12);
        TreeNode<Integer> node16 = new TreeNode(16);
        TreeNode<Integer> node6 = new TreeNode(6, node4, node8);
        TreeNode<Integer> node14 = new TreeNode(14, node12, node16);
        TreeNode<Integer> node10 = new TreeNode(10, node6, node14);
        TreeNode node = solution1(node10);
        System.out.println();
    }

    // 用于储存中序遍历当前的节点，作为中间变量，将双向指针链接起来
    public static TreeNode<Integer> pre = null;
    // 递归到最深层，返回双向链表的头
    public static TreeNode<Integer> curr = null;

    public static TreeNode<Integer> solution1(TreeNode<Integer> root) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (root == null) return null;

        Stack<TreeNode<Integer>> stack = new Stack();
        TreeNode<Integer> curr = root;
        TreeNode<Integer> pre = null, head = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (pre == null) {//处理头结点
                head = curr;
            } else {
                pre.right = curr;
                curr.left = pre;
            }
            pre = curr;
            curr = curr.right;
        }
        // curr.right = head;
        // head.left = curr;
        return head;
    }

    private static TreeNode<Integer> solution2(TreeNode<Integer> root) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        // 遍历到最深处节点为空进行返回
        if (root == null) return null;
        // 左递归
        solution2(root.left);
        // 中序遍历在中间进行处理：利用pre将彼此互相指向
        root.left = pre;
        if (pre != null) pre.right = root;
        // pre移位
        pre = root;
        //递归到最深处才将头赋值，也就是双向链表的头
        if (curr == null) curr = root;
        //右递归
        solution2(root.right);
        return curr;
    }
}
