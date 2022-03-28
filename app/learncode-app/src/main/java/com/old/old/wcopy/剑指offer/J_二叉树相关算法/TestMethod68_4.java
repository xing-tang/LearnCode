package com.old.old.wcopy.剑指offer.J_二叉树相关算法;

import java.util.ArrayList;

/**
 * 题目：
 * 多叉树的最近公共祖先：给定一个树, 找到该树中两个指定节点p和q的最近公共祖先。
 * 例如：
 * *     A
 * *   /   \
 * *  B     C
 * *       / \
 * *      D   E
 * *        / | \
 * *       F  G  H
 * <p>
 * 解题思路：
 * 用stack思路去实现
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)，空间复杂度：O(n)
 */
public class TestMethod68_4 {

    public static class TreeNode<E> {
        public E value;
        public ArrayList<TreeNode<E>> children;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public TreeNode(E value, ArrayList<TreeNode<E>> children) {
            this.value = value;
            this.children = children;
        }
    }

    public static void main(String[] args) {
        TreeNode<String> nodeF = new TreeNode<String>("F");
        TreeNode<String> nodeG = new TreeNode<String>("G");
        TreeNode<String> nodeH = new TreeNode<String>("H");
        ArrayList<TreeNode<String>> listE = new ArrayList<TreeNode<String>>();
        listE.add(nodeF);
        listE.add(nodeG);
        listE.add(nodeH);
        TreeNode<String> nodeE = new TreeNode<String>("E", listE);
        TreeNode<String> nodeD = new TreeNode<String>("D");
        ArrayList<TreeNode<String>> listC = new ArrayList<TreeNode<String>>();
        listC.add(nodeD);
        listC.add(nodeE);
        TreeNode<String> nodeC = new TreeNode<String>("C", listC);
        TreeNode<String> nodeB = new TreeNode<String>("B");
        ArrayList<TreeNode<String>> listA = new ArrayList<TreeNode<String>>();
        listA.add(nodeB);
        listA.add(nodeC);
        TreeNode<String> nodeA = new TreeNode<String>("A", listA);

        // 鲁棒性测试
        System.out.println("鲁棒性测试如下：");
        System.out.println(method(null, null, null));
        System.out.println(method(nodeA, null, null));
        System.out.println(method(nodeA, nodeA, null));
        System.out.println(method(nodeA, nodeA, nodeA));
        // 正常测试
        System.out.println("正常测试如下：");
        System.out.println(method(nodeA, nodeB, nodeF).value);
        System.out.println(method(nodeA, nodeG, nodeH).value);
    }

    /**
     * 找到最近公共祖先
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<String> method(TreeNode<String> root, TreeNode<String> p, TreeNode<String> q) {
        // 鲁棒性
        if (root == null || p == null || q == null || root == p || root == q) return null;

        //保存p1的路径
        ArrayList<TreeNode<String>> path1 = new ArrayList<TreeNode<String>>();
        //保存p2的路径
        ArrayList<TreeNode<String>> path2 = new ArrayList<TreeNode<String>>();
        ArrayList<TreeNode<String>> tmpList = new ArrayList<TreeNode<String>>();
        getNodePath(root, p, tmpList, path1);
        getNodePath(root, q, tmpList, path2);
        //如果路径不存在，返回空
        if (path1.size() == 0 || path2.size() == 0) {
            return null;
        }
        return getLastCommonParent(path1, path2);
    }

    /**
     * 获取根节点到目标节点的路径
     *
     * @param pRoot   待输入的根节点
     * @param pNode   待输入的目标节点
     * @param tmpList
     * @param path    保存根节点到目标节点的路径
     */
    public static void getNodePath(TreeNode<String> pRoot, TreeNode<String> pNode, ArrayList<TreeNode<String>> tmpList, ArrayList<TreeNode<String>> path) {
        // 鲁棒性
        if (pRoot == pNode || pRoot == null) return;

        tmpList.add(pRoot);
        ArrayList<TreeNode<String>> childs = pRoot.children;
        if (childs != null && childs.size() > 0) {
            for (TreeNode<String> node : childs) {
                if (node == pNode) {
                    path.addAll(tmpList);
                    break;
                }
                getNodePath(node, pNode, tmpList, path);
            }
        }
        tmpList.remove(tmpList.size() - 1); //清空集合
    }

    /**
     * 找到两个List集合里面相同的节点值
     *
     * @param path1 待输入的集合path1
     * @param path2 待输入的集合path2
     * @return 返回相同的节点值
     */
    private static TreeNode<String> getLastCommonParent(ArrayList<TreeNode<String>> path1, ArrayList<TreeNode<String>> path2) {
        TreeNode<String> tmpNode = null;
        // 找到list集合里靠后的相同的节点值
        for (int i = 0; i < path1.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;// 哇，已经找到答案了，不需要进行更多的循环
            }
            // 循环结束时tmpNode即为最后一个共同结点
            tmpNode = path1.get(i);
        }
        return tmpNode;
    }
}
