package com.open.learncode.算法.java.剑指offer.A7_二叉树;

/**
 * 题目：
 * 带父亲指针的二叉树的最近公共祖先：
 * 给定一个二叉树,且每个节点有一个指向父节点的parent值，找到该树中两个指定节点p和q的最近公共祖先。
 * 【注意：此题，祖先节点包含自身节点】
 * 例如：
 * *     3
 * *   /   \
 * *  5     1
 * * / \   / \
 * *6  2  0   8
 * *  / \
 * * 7  4
 * <p>
 * 解题思路：
 * 双指针法，其实这样定义后就变更为求两个链表的第一个公共节点去了，如【TestMethod52】所示
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(m+n)【m n分别是两个链表的长度】，空间复杂度：O(1)
 */
public class JZ68_3_带父亲指针的二叉树的最近公共祖先 {

    public static class TreeNode<E> {
        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;
        public TreeNode<E> parent;

        public TreeNode(E value) {
            this.value = value;
        }

        public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void setParent(TreeNode<E> parent) {
            this.parent = parent;
        }
    }

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
        // 设置父节点
        node7.setParent(node2);
        node4.setParent(node2);
        node2.setParent(node5);
        node6.setParent(node5);
        node5.setParent(node3);
        node0.setParent(node1);
        node8.setParent(node1);
        node1.setParent(node3);

        // 鲁棒性测试
        System.out.println("鲁棒性测试如下：");
        System.out.println(method(null, null));
        System.out.println(method(node3, null));
        System.out.println(method(node3, node3));
        // 正常测试
        System.out.println("正常测试如下：");
        System.out.println(method(node7, node4).value);
        System.out.println(method(node6, node8).value);
        System.out.println(method(node7, node3).value);
//        System.out.println(method(node2, node3).value);
    }

    /**
     * 双指针法
     *
     * @param nodeA 链表A
     * @param nodeB 链表B
     * @return 返回第一个公共节点
     */
    public static TreeNode<Integer> method(TreeNode<Integer> nodeA, TreeNode<Integer> nodeB) {
        //鲁棒性
        if (nodeA == null || nodeB == null || nodeA == nodeB) return null;

        TreeNode<Integer> tempA = nodeA;
        TreeNode<Integer> tempB = nodeB;
        //？
        int count = 0;
        //不断回溯父亲节点：当tempA==tempB时，跳出循环，此时它们回溯到了最近的公共祖先节点
        while (tempA != tempB) {
            tempA = tempA.parent;
            tempB = tempB.parent;

            //当tempA回溯到null时，代表nodeA在nodeB的上层
            if (tempA == null) {
                tempA = nodeA;
                count++;
            }
            //当tempB回溯到null时，代表nodeB在nodeA的上层
            if (tempB == null) {
                tempB = nodeB;
                count++;
            }
            if (count > 2) return null;
        }
        return tempA;
    }
}
