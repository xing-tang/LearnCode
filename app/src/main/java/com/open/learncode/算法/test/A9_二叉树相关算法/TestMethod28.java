package com.open.learncode.算法.test.A9_二叉树相关算法;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：
 * 对称的二叉树：请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如：
 * *    8
 * *   / \
 * *  6   6
 * * / \ / \
 * *5 7 7  5
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法三：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod28 {

    public static class TreeNode<E> {
        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRight(TreeNode<E> left, TreeNode<E> right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(8);
        TreeNode<Integer> node2 = new TreeNode<>(6);
        TreeNode<Integer> node3 = new TreeNode<>(6);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(7);
        TreeNode<Integer> node6 = new TreeNode<>(7);
        TreeNode<Integer> node7 = new TreeNode<>(5);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        System.out.println("递归判断是否是一颗对称二叉树：" + method_1(node1, node1));
        System.out.println("DFS判断是否是一颗对称二叉树：" + method_2(node1));
        System.out.println("BFS判断是否是一颗对称二叉树：" + method_3(node1));
    }

    /**
     * 递归方法
     * 以root1 root2为根的两个子树是否是对称的
     *
     * @param root1 二叉树的根节点root1
     * @param root2 二叉树的根节点root2
     * @return true，是对称二叉树；否，不是对称二叉树
     */
    private static boolean method_1(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null || root1.value != root2.value)
            return false;
        // 判断A的左边和B的右边是否相等，判断A的右边和B的左边是否相等，都相等就是对称的
        return method_1(root1.left, root2.right) && method_1(root1.right, root2.left);
    }

    /**
     * DFS：
     * 使用堆栈来实现树的深度优先遍历，将左右节点成对的压入堆栈，
     * 出栈的时候也要成对出栈，若value不相同或是有单独的空树，返回false；
     * 否则，继续成对的压入左右节点。
     *
     * @param root 二叉树的根节点
     * @return true，是对称二叉树；否，不是对称二叉树
     */
    private static boolean method_2(TreeNode<Integer> root) {
        if (root == null) return true;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode<Integer> right = stack.pop();
            TreeNode<Integer> left = stack.pop();
            if (right == null && left == null)
                continue;
            if (right == null || left == null || left.value != right.value)
                return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    /**
     * BFS：
     * 使用队列来实现树的广度优先遍历，代码与DFS十分相似，
     * 只不过节点先进先出，同样要注意入队以及出队的时候，左右节点要成对
     *
     * @param root 二叉树的根节点root
     * @return true，是对称二叉树；否，不是对称二叉树
     */
    private static boolean method_3(TreeNode<Integer> root) {
        if (root == null) return true;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode<Integer> left = queue.remove();
            TreeNode<Integer> right = queue.remove();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.value != right.value)
                return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}

