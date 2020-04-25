package com.open.learncode.剑指offer;


/**
 * 题目：
 * 树的子结构：输入两棵二叉树A B，判断B是不是A的子结构。
 * 二叉树节点的定义如下：
 * struct BinaryTreeNode{
 * double val;
 * BinaryTreeNode left;
 * BinaryTreeNode right;
 * }
 * 二叉树A：          二叉树B：
 *      8              8
 *   8     7        9     2
 * 9   2
 *   4   7
 * 二叉树B是二叉树A的子结构
 * <p>
 * 解题思路：
 * 第一步：在树A中查找与根节点的值一样的节点（递归）
 * 第二步：判断树A中以R为根节点的子树是不是和树B具有相同的结构（递归）
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod26 {


    /**
     * 内部类：二叉树节点
     */
    public static class TreeNode<E> {

        public E val;//节点值
        public TreeNode left;//指向左节点的指针
        public TreeNode right;//指向右节点的指针

        public TreeNode(E val) {
            this.val = val;
        }

        public void setLeftAndRight(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        //二叉树A：
        TreeNode<Double> node1 = new TreeNode<Double>(8.0);
        TreeNode<Double> node2 = new TreeNode<Double>(8.0);
        TreeNode<Double> node3 = new TreeNode<Double>(7.0);
        TreeNode<Double> node4 = new TreeNode<Double>(9.0);
        TreeNode<Double> node5 = new TreeNode<Double>(2.0);
        TreeNode<Double> node6 = new TreeNode<Double>(4.0);
        TreeNode<Double> node7 = new TreeNode<Double>(7.0);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node5.setLeftAndRight(node6, node7);

        //二叉树B：
        TreeNode<Double> node1_1 = new TreeNode<Double>(8.0);
        TreeNode<Double> node1_2 = new TreeNode<Double>(9.0);
        TreeNode<Double> node1_3 = new TreeNode<Double>(2.0);
        node1_1.setLeftAndRight(node1_2,node1_3);

//        TreeNode node=null;

        System.out.println("二叉树B是不是二叉树A的子结构：" + HasSubtree(node1, node1_1));

    }


    /**
     * 第一步：遍历，查看二叉树A中是否存在与二叉树B的根节点的值一样的节点
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    private static boolean HasSubtree(TreeNode<Double> pRoot1,TreeNode<Double> pRoot2) {

        boolean result = false;

        //避免试图访问空指针而造成程序崩溃；同时也是设置了递归调用的退出条件
        if (pRoot1 != null && pRoot2 != null) {

            if (Equal(pRoot1.val, pRoot2.val))
                result = DoesTree1HaveTree2(pRoot1, pRoot2);

            if (!result)
                result = HasSubtree(pRoot1.left, pRoot2);
            if (!result)
                result = HasSubtree(pRoot1.right, pRoot2);
        }

        return result;
    }


    /**
     * 第二步：判断A中以R为根节点的字数是否与树B具有相同的结构
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    private static boolean DoesTree1HaveTree2(TreeNode<Double> pRoot1, TreeNode<Double> pRoot2) {

        //避免试图访问空指针而造成程序崩溃；同时也是设置了递归调用的退出条件
        if (pRoot2 == null)
            return true;
        if (pRoot1 == null)
            return false;

        //再次判断找到的节点值是否与树B的根节点的值一样
        if (!Equal(pRoot1.val, pRoot2.val))
            return false;

        //如果相等，递归判断它们各自的左右节点的值是否相同
        return DoesTree1HaveTree2(pRoot1.left, pRoot2.left)
                && DoesTree1HaveTree2(pRoot1.right, pRoot2.right);
    }

    /**
     * 二叉树节点中值的类型为double 在判断两个节点的值是否相等时 不能直接用"=="来判断
     * 因为在计算机内表示小数时（包括float double）都有误差
     * 判断两个小数是否相等，只能判断它们之差的绝对值是不是在一个很小的范围内
     * 如果两个数相差很小，就可以认为它们相等
     *
     * @param num1
     * @param num2
     * @return
     */
    private static boolean Equal(double num1, double num2) {

        //如果两数误差在这之间，则认为两数相等
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        else
            return false;
    }

}