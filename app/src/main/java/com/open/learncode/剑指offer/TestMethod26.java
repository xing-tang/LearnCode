package com.open.learncode.剑指offer;


/**
 * 题目：
 * 树的子结构：输入两棵二叉树A B，判断B是不是A的子结构。
 * 二叉树节点的定义如下：
 * struct BinaryTreeNode{
 * double value;
 * BinaryTreeNode pLeft;
 * BinaryTreeNode pRight;
 * }
 * 二叉树A：          二叉树B：
 * 8              8
 * 8     7        9     2
 * 9   2
 * 4   7
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
    public static class BinaryTreeNode {

        int val;//节点值
        BinaryTreeNode pLeft;//左指针，指向当前节点的左子树
        BinaryTreeNode pRight;//右指针，指向当前节点的右子树

        BinaryTreeNode(int val) {
            this.val = val;
            pLeft = null;
            pRight = null;
        }


    }

    public static void main(String[] args) {

        //二叉树A：
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode node1_1 = new BinaryTreeNode(8);
        BinaryTreeNode node1_2 = new BinaryTreeNode(7);
        BinaryTreeNode node1_3 = new BinaryTreeNode(9);
        BinaryTreeNode node1_4 = new BinaryTreeNode(2);
        BinaryTreeNode node1_5 = new BinaryTreeNode(4);
        BinaryTreeNode node1_6 = new BinaryTreeNode(7);

        root1.pLeft = node1_1;
        root1.pRight = node1_2;
        node1_1.pLeft = node1_3;
        node1_1.pRight = node1_4;
        node1_4.pLeft = node1_5;
        node1_4.pRight = node1_6;

        //二叉树B：
//        BinaryTreeNode root2 = new BinaryTreeNode(8);
//        BinaryTreeNode node2_1 = new BinaryTreeNode(9);
//        BinaryTreeNode node2_2 = new BinaryTreeNode(2);
//
//        root2.pLeft = node2_1;
//        root2.pRight = node2_2;
        BinaryTreeNode root2=null;

        System.out.println("二叉树B是不是二叉树A的子结构：" + HasSubtree(root1, root2));

    }


    /**
     * 第一步：遍历，查看二叉树A中是否存在与二叉树B的根节点的值一样的节点
     *
     * @param pRoot1
     * @param pRoot2
     * @return
     */
    private static boolean HasSubtree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {

        boolean result = false;

        //避免试图访问空指针而造成程序崩溃；同时也是设置了递归调用的退出条件
        if (pRoot1 != null && pRoot2 != null) {

            if (Equal(pRoot1.val, pRoot2.val))
                result = DoesTree1HaveTree2(pRoot1, pRoot2);

            if (!result)
                result = HasSubtree(pRoot1.pLeft, pRoot2);
            if (!result)
                result = HasSubtree(pRoot1.pRight, pRoot2);
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
    private static boolean DoesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {

        //避免试图访问空指针而造成程序崩溃；同时也是设置了递归调用的退出条件
        if (pRoot2 == null)
            return true;
        if (pRoot1 == null)
            return false;

        //再次判断找到的节点值是否与树B的根节点的值一样
        if (!Equal(pRoot1.val, pRoot2.val))
            return false;

        //如果相等，递归判断它们各自的左右节点的值是否相同
        return DoesTree1HaveTree2(pRoot1.pLeft, pRoot2.pLeft)
                && DoesTree1HaveTree2(pRoot1.pRight, pRoot2.pRight);
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