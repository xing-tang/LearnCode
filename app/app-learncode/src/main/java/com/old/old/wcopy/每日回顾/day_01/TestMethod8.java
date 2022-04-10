package com.old.old.wcopy.每日回顾.day_01;

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
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class TestMethod8 {

    public static void main(String[] args) {
        TreeNode<String> nodeA = new TreeNode<String>("a");
        TreeNode<String> nodeB = new TreeNode<String>("b");
        TreeNode<String> nodeC = new TreeNode<String>("c");
        TreeNode<String> nodeD = new TreeNode<String>("d");
        TreeNode<String> nodeE = new TreeNode<String>("e");
        TreeNode<String> nodeF = new TreeNode<String>("f");
        TreeNode<String> nodeG = new TreeNode<String>("g");
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

    private static TreeNode<String> method(TreeNode<String> node) {
        if (node == null) return null;

        TreeNode<String> curr = node.right;
        if (curr != null) {
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        curr = node;
        TreeNode parent = curr.next;
        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = curr.next;
        }
        if (parent == null) return null;
        return parent;
    }

}

