package com.open.learncode.算法.java.剑指offer.A2_树;

import com.open.learncode.算法.base.PrintUtils;
import com.open.learncode.算法.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：
 * 分行从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 注意：
 * 节点总数 <= 1000。
 * <p>
 * 示例：
 * ======================
 * 示例1：
 * 二叉树如下：
 * *     8
 * *   /  \
 * *  6    10
 * * / \   / \
 * *5  7  9  11
 * 则返回：{{8},{6,10},{5,7,9,11}}
 * <p>
 * 解题思路：
 * 利用队列的特性进行操作，再加上两个临时变量。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n)。
 * 空间复杂度：O(n)【队列用到的最大空间是存储最下面一层的节点的时候】。
 */
public class JZ32_2_分行从上到下打印二叉树 {

    public static void main(String[] args) {
        // 测试用例
        int[] preOrder = {8, 6, 5, 7, 10, 9, 11};
        int[] inOrder = {5, 6, 7, 8, 9, 10, 11};
        TreeNode<Integer> treeNode = TreeNode.createTreeNode(preOrder, inOrder);
        PrintUtils.getInstance().printIntArrayArrayList(solution(treeNode), "分行打印二叉树");
    }

    private static ArrayList<ArrayList<Integer>> solution(TreeNode<Integer> root) {
        if (root == null) return new ArrayList();

        ArrayList<ArrayList<Integer>> list = new ArrayList();
        Queue<TreeNode<Integer>> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> tempList = new ArrayList();
            for (int i = 0; i < length; i++) {
                TreeNode<Integer> temp = queue.poll();
                if (temp != null) {
                    tempList.add(temp.val);
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
