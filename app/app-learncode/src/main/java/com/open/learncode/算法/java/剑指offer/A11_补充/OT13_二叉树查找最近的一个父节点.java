package com.open.learncode.算法.java.剑指offer.A11_补充;

import com.open.learncode.算法.base.TreeNode;

import java.util.Stack;


/**
 * 题目：
 * 普通二叉树的最近公共祖先：给定一个二叉树, 找到该树中两个指定节点p和q的最近公共祖先。
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
 * 因为它是一个二叉树，故用递归思想，也可以用stack+后续遍历思路去实现
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(n)【其中n为二叉树节点数；最差情况下(退化为链表），需要递归遍历树的所有节点】
 * *      空间复杂度：O(n)【最差情况下，递归深度达到n ，系统使用0(n)大小的额外空间】
 * 方法二：时间复杂度：O(n)，空间复杂度：O(n)
 * <p>
 * 解题思路：
 * 后序遍历
 * 考虑通过递归对二叉树进行后序遍历，当遇到节点p或q时返回。从底至顶回溯，当节点p q在节点root的异侧时，
 * 节点root即为最近公共祖先，则向上返回root
 */
public class OT13_二叉树查找最近的一个父节点 {

    public static void main(String[] args) {
        TreeNode<Integer> node7 = new TreeNode(7);
        TreeNode<Integer> node4 = new TreeNode(4);
        TreeNode<Integer> node2 = new TreeNode(2, node7, node4);
        TreeNode<Integer> node6 = new TreeNode(6);
        TreeNode<Integer> node5 = new TreeNode(5, node6, node2);
        TreeNode<Integer> node0 = new TreeNode(0);
        TreeNode<Integer> node8 = new TreeNode(8);
        TreeNode<Integer> node1 = new TreeNode(1, node0, node8);
        TreeNode<Integer> node3 = new TreeNode(3, node5, node1);

        // 鲁棒性测试
        System.out.println("方法一：");
        System.out.println("鲁棒性测试如下：");
        System.out.println(rob_1(null, null, null));
        System.out.println(rob_1(node3, null, null));
        System.out.println(rob_1(node3, node3, null));
        System.out.println(rob_1(node3, node3, node3));
        // 正常测试
        System.out.println("正常测试如下：");
        System.out.println(rob_1(node3, node7, node4).val);
        System.out.println(rob_1(node3, node6, node8).val);

        // 鲁棒性测试
        System.out.println("方法二：");
        System.out.println("鲁棒性测试如下：");
        System.out.println(rob_2(null, null, null));
        System.out.println(rob_2(node3, null, null));
        System.out.println(rob_2(node3, node3, null));
        System.out.println(rob_2(node3, node3, node3));
        // 正常测试
        System.out.println("正常测试如下：");
        System.out.println(rob_2(node3, node7, node4).val);
        System.out.println(rob_2(node3, node6, node8).val);
    }

    /**
     * 递归方法
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> rob_1(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (root == null || p == null || q == null || root == p || root == q) return null;

        return solution1(root, p, q);
    }

    /**
     * 递归方法
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> solution1(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // 递归出口
        if (root == null || root == p || root == q) return root;

        //去该节点的左子树上找
        TreeNode<Integer> left = solution1(root.left, p, q);
        //去该节点的右子树上找
        TreeNode<Integer> right = solution1(root.right, p, q);
        if (left == null) {
            //左子树上没有，说明在右子树上
            return right;
        } else if (right == null) {
            //右子树上没有，说明在左子树上
            return left;
        }
        //左右均有，说明该节点即为最近公共祖先
        return root;
    }

    /**
     * 非递归方法【stack+后序遍历】
     *
     * @param root 待输入的根节点
     * @param p    待输入的节点p
     * @param q    待输入的节点q
     * @return 返回最近公共祖先
     */
    public static TreeNode<Integer> rob_2(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if (root == null || p == null || q == null || root == p || root == q) return null;

        Stack<TreeNode<Integer>> stack1 = new Stack();
        Stack<TreeNode<Integer>> stack2 = new Stack();
        solution2(root, p, stack1);
        solution2(root, q, stack2);
        while (!stack1.empty() && !stack2.empty() && stack1.peek() != stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }
        if (stack1.empty() || stack2.empty()) {
            return null;
        }
        return stack1.peek();
    }

    /**
     * 获取根节点到对应节点的路径
     *
     * @param root  待输入的根节点
     * @param end   该路径结束的节点
     * @param stack 用来保存路径的栈
     */
    public static void solution2(TreeNode<Integer> root, TreeNode<Integer> end, Stack<TreeNode<Integer>> stack) {
        TreeNode<Integer> cur = root;
        TreeNode<Integer> peek;
        stack.push(root);
        while (!stack.isEmpty()) {
            peek = stack.peek();
            //循环终止条件
            if (peek == end) return;
            //添加左节点：左节点不为null 且 没有添加过； 右节点没有添加过（针对节点2 3 1）
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            }
            //添加右节点：右节点不为空，且没有添加过
            else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            }
            //否则，输出
            else {
                stack.pop();
                cur = peek;
            }
        }
    }
}