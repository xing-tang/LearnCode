package com.old.old.剑指offer.A9_二叉树相关算法;

import com.open.learncode.算法.base.TreeNode;

/**
 * 题目：
 * 二叉树的下一个节点：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * 示例：测试b、d、e，分别对应三种情况
 * *****a
 * *** / \
 * ***b   c
 * * /\  / \
 * *d e f  g
 * <p>
 * 解题思路：
 * 分情况找出下一个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ08_二叉树的下一个节点 {

    public static void main(String[] args) {
        TreeNode<String> nodeA = new TreeNode("a");
        TreeNode<String> nodeB = new TreeNode("b");
        TreeNode<String> nodeC = new TreeNode("c");
        TreeNode<String> nodeD = new TreeNode("d");
        TreeNode<String> nodeE = new TreeNode("e");
        TreeNode<String> nodeF = new TreeNode("f");
        TreeNode<String> nodeG = new TreeNode("g");
        nodeA.setLeftAndRightAndNext(nodeB, nodeC, null);
        nodeB.setLeftAndRightAndNext(nodeD, nodeE, nodeA);
        nodeC.setLeftAndRightAndNext(nodeF, nodeG, nodeA);
        nodeE.setLeftAndRightAndNext(null, null, nodeB);
        nodeD.setLeftAndRightAndNext(null, null, nodeB);
        nodeF.setLeftAndRightAndNext(null, null, nodeC);
        nodeG.setLeftAndRightAndNext(null, null, nodeC);

        // 分别获取节点b、d、e、g的下一个节点
        System.out.println(nodeB.val + "在中序遍历中下一个节点是：" + method(nodeB).val);
        System.out.println(nodeD.val + "在中序遍历中下一个节点是：" + method(nodeD).val);
        System.out.println(nodeE.val + "在中序遍历中下一个节点是：" + method(nodeE).val);
        System.out.println(nodeG.val + "在中序遍历中下一个节点是：" + method(nodeG));
    }

    /**
     * 找到p节点的下一个节点，分下列几种情况
     * 1、有右子树
     * 2、无右子树 2.1 是其父亲节点的右孩子
     *
     * @param node 给定的一个节点
     * @return 返回给定节点的下一个节点
     */
    private static TreeNode<String> method(TreeNode<String> node) {
        // 鲁棒性
        if (node == null) return null;

        // 有右子树：它的下一个节点是其右子树中的最左子节点
        TreeNode<String> curr = node.right;
        if (curr != null) {
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        // 无右子树
        // 又分为两种情况：
        // 1.该节点是其父亲节点的左孩子，则下一个节点是其父亲节点
        // 2.该节点是其父亲节点的右孩子，则不断的回溯找到父亲节点
        curr = node;
        TreeNode<String> parent = node.next;
        // 情况2：
        // ①p是parent的右孩子，且是右子树上的右孩子，这时parent==null
        // ②p是parent的右孩子，且是左子树上的右孩子，这时parent==root
        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = curr.next;
        }
        // 情况1：p是parent的左孩子
        return parent;
    }
}

