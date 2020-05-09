package com.open.learncode.剑指offer;


import com.open.learncode.java.stack.Stack;

/**
 * 题目：
 * 二叉树中和位某一值的路径：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * ******10
 * *** /  \
 * ***5   12
 * * / \
 * *4  7
 * 有两条和为22的路径：10 5 7； 10 12
 * <p>
 * 解题思路：
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n^2)，空间复杂度：O(n)
 */
public class TestMethod34 {

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
        TreeNode<Integer> node2 = new TreeNode<Integer>(5);
        TreeNode<Integer> node3 = new TreeNode<Integer>(12);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(7);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);

        System.out.println("是否有路径：");
        findAllPath(node1, 22);
    }


    private static void findAllPath(TreeNode<Integer> root, int target) {

        if (root == null || target <= 0)
            return;

        Stack<Integer> path = new Stack();

        findPath(root, target, path);
    }

    private static void findPath(TreeNode<Integer> root, int target, Stack<Integer> path) {

        target-= root.value;

        // 将当前节点加入路径中
        path.push(root.value);

        // 如果当前节点是叶子节点(即没有左右子节点)，并且当前累加值等于期望值，则输出路径信息
        if (root.left == null && root.right == null && target == 0) {
            for (Integer val : path) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // 如果左子节点不为空，说明不是叶子节点，则继续寻找路径
        if (root.left != null) {
            findPath(root.left, target, path);
        }
        // 如果右子节点不为空，说明不是叶子节点，则继续寻找路径
        if (root.right != null) {
            findPath(root.right, target, path);
        }

        // 如果当前节点不符合要求，则从路径中移除当前节点
        path.pop();
    }

}
