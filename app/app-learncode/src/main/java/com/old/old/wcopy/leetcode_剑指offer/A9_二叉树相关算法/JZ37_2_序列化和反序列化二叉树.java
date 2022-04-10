package com.old.old.wcopy.leetcode_剑指offer.A9_二叉树相关算法;

import com.open.learncode.算法.base.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 题目：
 * 序列化二叉树：请实现两个函数，分别用来序列化和反序列化二叉树
 * 例如：
 * * ******1
 * * *** /  \
 * * ***2   3
 * * * /   / \
 * * *4   5  6
 * 序列化：1,2,4,$,$,$,3,5,$,$,6,$,$
 * <p>
 * 解题思路：
 * 一般情况下，需要采用前/后序遍历和中序遍历才能确定一个二叉树，但是其实可以只采用前序遍历（从根结点开始），
 * 将空结点(null)输出为一个特殊符号（如“$”），就可以确定一个二叉树了。
 * 将二叉树序列化为字符串，就是前序遍历的过程，遇见空结点时，序列化为“$”，每个结点间使用逗号分隔开。
 * 将字符串反序列化为二叉树，也使用前序遍历，遇见一个新数字(或者$)就建立一个新结点，不过需要注意的是，
 * 数字可能不只是个位数字，因此创建了一个全局Int变量index（在字符串上的移动的指针），以便于截取字符串中当前的结点值。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class JZ37_2_序列化和反序列化二叉树 {

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, null);
        node3.setLeftAndRight(node5, node6);

        String str = Serialize(node1);
        System.out.println(str);
        TreeNode<Integer> root = Deserialize(str);
        centerPrint(root);
    }

    /**
     * 序列化：层序遍历
     *
     * @param root 根节点
     * @return 返回序列化后的二叉树序列
     */
    private static String Serialize(final TreeNode<Integer> root) {
        if (root == null) return null;

        StringBuilder builder = new StringBuilder("[");
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>() {{
            add(root);
        }};
        // 层序遍历：
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if (node != null) {
                builder.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else
                builder.append("null,");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    /**
     * 反序列化：
     *
     * @param str 序列化后的二叉树序列
     * @return 返回反序列化后的二叉树根节点
     */
    private static TreeNode<Integer> Deserialize(String str) {
        // 鲁棒性
        if (str == null || str.length() <= 0) return null;

        // 将str字符串[1,str.length() - 1)装换为String类型的数组，并去除分割符","
        String[] vals = str.substring(1, str.length() - 1).split(",");
        final TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(vals[i]);
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(vals[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    /**
     * 层序遍历，这里主要用来打印输出验证算法效果的
     *
     * @param root 根节点
     */
    private static void centerPrint(TreeNode<Integer> root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.remove();
            System.out.print(temp.val + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }
}