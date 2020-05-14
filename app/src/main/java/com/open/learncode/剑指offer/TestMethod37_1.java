package com.open.learncode.剑指offer;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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

    public static void main(String[] args) {
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node4, null);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3, node5, node6);
        TreeNode<Integer> node1 = new TreeNode<Integer>(1, node2, node3);
        String data = serialize(node1);
        System.out.println(data);
        TreeNode node = deserialize(data);
        centerPrint(node);
    }

    /**
     * 序列化：前序遍历
     *
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {

        StringBuilder builder = new StringBuilder();

        //递归终止条件：遇见空结点时，序列化为“$”
        if (root == null) {
            builder.append("null,");
        } else {//每个结点间使用逗号分隔开
            //前序遍历：根左右
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
     * @param str
     * @return
     */
    private static TreeNode<Integer> deserialize(String str) {

        TreeNode<Integer> node = null;

        //鲁棒性
        if (str == null || str.length() == 0)
            return node;

        int start = index;
        while (str.charAt(index) != ',')
            index++;

        //String.subString(start,end)截取字符串[start,end)
        String strValue = str.substring(start, index);
        //如果不为空节点
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
     * 层序遍历
     *
     * @param root
     */
    private static void centerPrint(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
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


