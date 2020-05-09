package com.open.learncode.剑指offer;


import java.util.ArrayDeque;
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
 * ①序列化：就是前序遍历的过程，遇见空结点时，序列化为“$”，每个结点间使用逗号分隔开。
 * ②反序列化：也使用前序遍历，遇见一个新数字(或者$)就建立一个新结点，不过需要注意的是，
 * 数字可能不只是个位数字，因此创建了一个全局int变量index（在字符串上的移动的指针），以便于截取字符串中当前的结点值。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod37_1 {

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

        TreeNode root=Deserialize(str);
        centerPrint(root);
    }

    /**
     * 序列化：前序遍历
     *
     * @param node
     * @return
     */
    private static String Serialize(TreeNode node) {

        StringBuilder builder = new StringBuilder();

        //递归终止条件：遇见空结点时，序列化为“$”
        if (node == null) {
            builder.append("$,");
        }
        //每个结点间使用逗号分隔开
        else {
            //前序遍历：根左右
            builder.append(node.value + ",");
            builder.append(Serialize(node.left));
            builder.append(Serialize(node.right));
        }

        return builder.toString();
    }

    //在字符串上的移动的指针 ，以便于截取字符串中当前的结点值
    static int index = 0;
    /**
     * 反序列化：
     *
     * @param str
     * @return
     */
    private static TreeNode Deserialize(String str) {

        TreeNode node = null;

        //鲁棒性
        if (str == null || str.length() == 0)
            return node;

        int start = index;
        while (str.charAt(index) != ',')
            index++;

        //String.subString(start,end)截取字符串[start,end)
        String strValue=str.substring(start, index);
        //如果不为空节点
        if (!strValue.equals("$")) {
            node = new TreeNode(Integer.parseInt(strValue));
            index++; // 这条语句位置别放错了
            node.left = Deserialize(str);
            node.right = Deserialize(str);
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

}