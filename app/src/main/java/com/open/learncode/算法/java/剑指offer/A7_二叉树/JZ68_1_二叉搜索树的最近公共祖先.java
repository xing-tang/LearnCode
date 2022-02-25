package com.open.learncode.算法.java.剑指offer.A7_二叉树;

/**
 * 题目：
 * 二叉搜索树的最近公共祖先：给定一个二叉搜索树, 找到该树中两个指定节点p和q的最近公共祖先。
 * 【注意：祖先节点不包含自身】
 * 【找到的最近祖先节点特点：p q在root的两侧】
 * 例如：
 * *     6
 * *   /   \
 * *  2     8
 * * / \   / \
 * *0  4  7   9
 * *  / \
 * * 3   5
 * <p>
 * 解题思路：
 * 利用二分搜索树的特性，然后分别用迭代和递归思路可以实现
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)【其中为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为nlogn(满二叉树），最大为n(退化为链表）】
 * *      空间复杂度：O(n)【用到系统栈】
 * 方法二：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class JZ68_1_二叉搜索树的最近公共祖先 {

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

        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4, node3, node5);
        TreeNode<Integer> node0 = new TreeNode<Integer>(0);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2, node0, node4);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8, node7, node9);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6, node2, node8);

        // 鲁棒性测试
        System.out.println("鲁棒性测试如下：");
        System.out.println(method_1(null, null, null));
        System.out.println(method_1(node6, null, null));
        System.out.println(method_1(node6, node6, null));
        System.out.println(method_1(node6, node6, node6));

        System.out.println(method_2(null, null, null));
        System.out.println(method_2(node6, null, null));
        System.out.println(method_2(node6, node6, null));
        System.out.println(method_2(node6, node6, node6));
        // 正常测试
        System.out.println("正常测试如下：");
        System.out.println(method_1(node6, node3, node5).value);
        System.out.println(method_1(node6, node0, node9).value);
        System.out.println(method_2(node6, node3, node5).value);
        System.out.println(method_2(node6, node0, node9).value);
    }

    /**
     * 递归方法
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> method_1(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // 鲁棒性
        if (root == null || p == null || q == null || root == p || root == q) return null;

        if (root.value < p.value && root.value < q.value)
            return method_1(root.right, p, q);
        if (root.value > p.value && root.value > q.value)
            return method_1(root.left, p, q);
        return root;
    }

    /**
     * 迭代方法
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> method_2(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // 鲁棒性
        if (root == null || p == null || q == null || root == p || root == q) return null;

        while (root != null) {
            if (root.value < p.value && root.value < q.value) // p,q 都在 root 的右子树中
                root = root.right; // 遍历至右子节点
            else if (root.value > p.value && root.value > q.value) // p,q 都在 root 的左子树中
                root = root.left; // 遍历至左子节点
            else
                break;
        }
        return root;
    }
}
