package com.open.learncode.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：
 * 给定一个二叉树, 找到该树中两个指定节点p和q的最近公共祖先。
 * 例如：
 * ******3
 * *** /   \
 * ***5     1
 * * / \   / \
 * *6  2  0   8
 * *  / \
 * * 7  4
 * <p>
 * 解题思路：
 * 因为它是一个二叉树，故用递归思想，也可以用stack+后续遍历思路去实现
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod68_2 {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node7, node4);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5, node6, node2);
        TreeNode<Integer> node0 = new TreeNode<Integer>(0);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1, node0, node8);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3, node5, node1);


        // 鲁棒性测试
        System.out.println("方法一：");
        System.out.println("鲁棒性测试如下：");
        System.out.println(rob_1(null, null, null));
        System.out.println(rob_1(node3, null, null));
        System.out.println(rob_1(node3, node3, null));
        System.out.println(rob_1(node3, node3, node3));
        // 正常测试
        System.out.println("正常测试如下：");
        System.out.println(rob_1(node3, node7, node4).value);
        System.out.println(rob_1(node3, node6, node8).value);


        // 鲁棒性测试
        System.out.println("方法二：");
        System.out.println("鲁棒性测试如下：");
        System.out.println(rob_2(null, null, null));
        System.out.println(rob_2(node3, null, null));
        System.out.println(rob_2(node3, node3, null));
        System.out.println(rob_2(node3, node3, node3));
        // 正常测试
        System.out.println("正常测试如下：");
        System.out.println(rob_2(node3, node7, node4).value);
        System.out.println(rob_2(node3, node6, node8).value);


    }

    /**
     * 递归方法
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> rob_1(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // 鲁棒性
        if (root == null || p == null || q == null || root == p || root == q) return null;

        return method_1(root, p, q);
    }

    /**
     * 递归方法
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> method_1(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        //递归出口
        if (root == null || root == p || root == q)
            return root;
        //去该节点的左子树上找
        TreeNode left = method_1(root.left, p, q);
        //去该节点的右子树上找
        TreeNode right = method_1(root.right, p, q);
        if (left == null) {
            //左子树上没有，说明在右子树上
            return right;
        } else if (right == null) {
            //右子树上没有，说明在左子树上
            return left;
        }
        //左右均有，说明该节点即为最近公共祖先
        return root;
    }

    /**
     * 非递归方法【stack+后续遍历】
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> rob_2(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // 鲁棒性
        if (root == null || p == null || q == null || root == p || root == q) return null;

        Stack<TreeNode<Integer>> stack1 = new Stack<TreeNode<Integer>>();
        Stack<TreeNode<Integer>> stack2 = new Stack<TreeNode<Integer>>();
        method_2(root, p, stack1);
        method_2(root, q, stack2);

        while (!stack1.empty() && !stack2.empty() && stack1.peek() != stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }

        if (stack1.empty() || stack2.empty()) {
            return null;
        }

        return stack1.peek();
    }

    /**
     * 获取根节点到对应节点的路径
     *
     * @param root  待输入的根节点
     * @param end   该路径结束的节点
     * @param stack 用来保存路径的栈
     */
    public static void method_2(TreeNode<Integer> root, TreeNode<Integer> end, Stack<TreeNode<Integer>> stack) {
        TreeNode cur = root;
        TreeNode peek;
        stack.push(root);
        while (!stack.isEmpty()) {
            peek = stack.peek();
            if (peek == end) return;

            //添加左节点：左节点不为null 且 没有添加过； 右节点没有添加过（针对节点2 3 1）
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            }
            //添加右节点：右节点不为空，且没有添加过
            else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            }
            //否则，输出
            else {
                stack.pop();
                cur = peek;
            }
        }
    }

    public static class TreeNode<E> {

        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
