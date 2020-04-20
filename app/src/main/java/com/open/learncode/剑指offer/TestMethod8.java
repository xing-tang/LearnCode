package com.open.learncode.剑指offer;

/**
 * 题目：
 * 二叉树的下一个节点：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 *      a
 *   b     c
 * d  e  f   g
 *   h i
 * <p>
 * 解题思路：
 * 分情况找出下一个节点
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class TestMethod8 {


    /**
     * 二叉树节点
     */
    public static class TreeNode<E> {
        public E value;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针
        public TreeNode parent;//指向该节点的父亲节点

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRightAndParent(TreeNode left, TreeNode right, TreeNode parent) {
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }


    public static void main(String[] args) {

        String inorder[] = {"d", "b", "h", "e", "i", "a", "f", "c", "g"};
        //创建二叉树
        TreeNode<String> nodeA = new TreeNode<String>("a");
        TreeNode<String> nodeB = new TreeNode<String>("b");
        TreeNode<String> nodeC = new TreeNode<String>("c");
        TreeNode<String> nodeD = new TreeNode<String>("d");
        TreeNode<String> nodeE = new TreeNode<String>("e");
        TreeNode<String> nodeF = new TreeNode<String>("f");
        TreeNode<String> nodeG = new TreeNode<String>("g");
        TreeNode<String> nodeH = new TreeNode<String>("h");
        TreeNode<String> nodeI = new TreeNode<String>("i");
        nodeA.setLeftAndRightAndParent(nodeB,nodeC,null);
        nodeB.setLeftAndRightAndParent(nodeD,nodeE,nodeA);
        nodeC.setLeftAndRightAndParent(nodeF,nodeG,nodeA);
        nodeE.setLeftAndRightAndParent(nodeH,nodeI,nodeB);
        nodeD.setLeftAndRightAndParent(null,null,nodeB);
        nodeF.setLeftAndRightAndParent(null,null,nodeC);
        nodeG.setLeftAndRightAndParent(null,null,nodeC);
        nodeH.setLeftAndRightAndParent(null,null,nodeE);
        nodeI.setLeftAndRightAndParent(null,null,nodeE);


        method(nodeA);
        method(nodeB);
        method(nodeC);
        method(nodeD);
        method(nodeE);
        method(nodeF);
        method(nodeG);
        method(nodeH);
        method(nodeI);

    }

    /**
     * 找到p节点的下一个节点，分下列几种情况
     * 1、有右子树
     * 2、无右子树 2.1 是其父亲节点的右孩子
     *
     * @param p 给定的一个节点
     * @return
     */
    private static TreeNode method(TreeNode p) {


        if (p == null)
            return null;

        TreeNode cur = p.right;

        // 右子树不为空，它的下一个节点是它的右子树中的最左子节点
        if (cur != null) {
            while (cur.left != null) {
                cur = cur.left;
            }
            System.out.println(p.value + "的下一个节点是：" + cur.value);
            return cur;
        }


        // 右子树为空
        TreeNode temp = p;
        TreeNode parent = p.parent;
        //节点是父亲节点的左孩子，下一个节点就是它的父亲节点
        //节点是父亲节点的右孩子，找到其父亲节点的左孩子
        while (parent != null && parent.left != p) {
            p = parent;
            parent = p.parent;

        }

        if (parent == null) {
            System.out.println(temp.value + "没有下一个节点");
            return null;
        }
        System.out.println(temp.value + "的下一个节点是：" + parent.value);
        return parent;


    }
}

