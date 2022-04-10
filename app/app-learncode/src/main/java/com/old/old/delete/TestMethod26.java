package com.old.old.delete;


import com.open.learncode.算法.base.TreeNode;

/**
 * 题目：
 * 树的子结构：输入两棵二叉树A B，判断B是不是A的子结构。
 * 例如：
 * 二叉树A           二叉树B
 * *      8              8
 * *    /   \          /   \
 * *   8    7         9    2
 * *  / \
 * * 9   2
 * *    / \
 * *   4  7
 * 二叉树B是二叉树A的子结构
 * <p>
 * 解题思路：
 * 第一步：在树A中查找与根节点的值一样的节点R（递归）
 * 第二步：判断树A中以R为根节点的子树是不是和树B具有相同的结构（递归）
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod26 {

    public static void main(String[] args) {
        // 二叉树A
        TreeNode<Integer> nodeA4 = new TreeNode<Integer>(4);
        TreeNode<Integer> nodeA7_2 = new TreeNode<Integer>(7);
        TreeNode<Integer> nodeA2 = new TreeNode<Integer>(2, nodeA4, nodeA7_2);
        TreeNode<Integer> nodeA9 = new TreeNode<Integer>(9);
        TreeNode<Integer> nodeA8 = new TreeNode<Integer>(8, nodeA9, nodeA2);
        TreeNode<Integer> nodeA7_1 = new TreeNode<Integer>(7);
        TreeNode<Integer> rootA8 = new TreeNode<Integer>(8, nodeA8, nodeA7_1);
        // 二叉树B
        TreeNode<Integer> nodeB9 = new TreeNode<Integer>(9);
        TreeNode<Integer> nodeB2 = new TreeNode<Integer>(2);
        TreeNode<Integer> rootB8 = new TreeNode<Integer>(8, nodeB9, nodeB2);

        System.out.println("二叉树B是不是二叉树A的子结构：" + isSubStructure(rootA8, rootB8));
    }

    /**
     * 递归
     *
     * @param A 二叉树的节点
     * @param B 二叉树的节点
     * @return 返回二叉树B是否是二叉树A的子结构
     */
    public static boolean isSubStructure(TreeNode<Integer> A, TreeNode<Integer> B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 递归，注意：达到这里A和B的根节点肯定相同，不然肯定不是子结构
     *
     * @param A 二叉树的节点
     * @param B 二叉树的节点
     * @return 返回二叉树B是否是二叉树A的子结构
     */
    public static boolean recur(TreeNode<Integer> A, TreeNode<Integer> B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}