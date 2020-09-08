package com.open.learncode.算法.剑指offer.J_二叉树相关算法;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 例如二叉搜索树如下：
 * * ******1
 * * *** /  \
 * * ***2   3
 * * * /   / \
 * * *4   5  6
 * 则转换成序列化为：1,2,4,null,null,null,3,5,null,null,6,null,null
 * <p>
 * 解题思路：
 * 递归或者利用辅助栈
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)，空间复杂度：O(n)
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod37_1 {

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

    public static void main(String[] args) {
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node4, null);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3, node5, node6);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1, node2, node3);
        String data = serialize(node1);
        System.out.println(data);
        TreeNode<Integer> node = deserialize(data);
        centerPrint(node);
    }

    /**
     * 序列化：前序遍历
     *
     * @param root 根节点
     * @return 返回序列化后的二叉树序列
     */
    public static String serialize(TreeNode<Integer> root) {
        StringBuilder builder = new StringBuilder();

        // 递归终止条件：遇见空结点时，序列化为“$”
        if (root == null) {
            builder.append("null,");
        } else {// 每个结点间使用逗号分隔开
            // 前序遍历：根左右
            builder.append(root.value + ",");
            builder.append(serialize(root.left));
            builder.append(serialize(root.right));
        }
        return builder.toString();
    }

    //在字符串上的移动的指针 ，以便于截取字符串中当前的结点值
    public static int index = 0;

    /**
     * 反序列化：
     *
     * @param str 序列化后的二叉树序列
     * @return 返回反序列化后的二叉树根节点
     */
    private static TreeNode<Integer> deserialize(String str) {
        // 鲁棒性
        if (str == null || str.length() == 0) return null;

        TreeNode<Integer> node = null;
        int start = index;
        while (str.charAt(index) != ',') index++;
        // String.subString(start,end)截取字符串[start,end)
        String strValue = str.substring(start, index);
        // 如果不为空节点
        if (!strValue.equals("null")) {
            node = new TreeNode<Integer>(Integer.parseInt(strValue));
            index++; // 这条语句位置别放错了
            node.left = deserialize(str);
            node.right = deserialize(str);
        } else {
            index++;
        }
        return node;
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
            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }
}


