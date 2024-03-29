package com.old.old.wcopy.每日回顾.day_04;

import com.open.learncode.算法.base.TreeNode;

import java.util.Stack;

/**
 * 题目：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
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
public class TestMethod36 {

    public static void main(String[] args) {
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node12 = new TreeNode<Integer>(12);
        TreeNode<Integer> node16 = new TreeNode<Integer>(16);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6, node4, node8);
        TreeNode<Integer> node14 = new TreeNode<Integer>(14, node12, node16);
        TreeNode<Integer> node10 = new TreeNode<Integer>(10, node6, node14);
//        TreeNode node = method_1(node10);
        TreeNode node = method_2(node10);
        System.out.println();
    }

    // 用于储存中序遍历当前的节点，作为中间变量，将双向指针链接起来
    public static TreeNode pre = null;
    // 递归到最深层，返回双向链表的头
    public static TreeNode curr = null;

    private static TreeNode method_1(TreeNode root) {
        // 遍历到最深处节点为空进行返回
        if (root == null) return null;
        // 左递归
        method_1(root.left);
        // 中序遍历在中间进行处理：利用pre将彼此互相指向
        root.left = pre;
        if (pre != null) pre.right = root;
        // pre移位
        pre = root;
        //递归到最深处才将头赋值，也就是双向链表的头
        if (curr == null) curr = root;
        //右递归
        method_1(root.right);
        return curr;
    }

    public static TreeNode method_2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode pre = null, head = null;
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
//        curr.right = head;
//        head.left = curr;
        return head;
    }
}
