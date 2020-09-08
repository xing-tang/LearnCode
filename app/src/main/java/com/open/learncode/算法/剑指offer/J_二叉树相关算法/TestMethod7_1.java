package com.open.learncode.算法.剑指offer.J_二叉树相关算法;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：
 * ******1
 * *** /   \
 * ***2     3
 * * / \   / \
 * *4  5  6   7
 * <p>
 * 解题思路：
 * 利用递归、迭代(栈)、Morris方法来打印前中后序遍历
 * 层序遍历：1 2 3 4 5 6 7
 * 前序遍历: 1 2 4 5 3 6 7
 * 中序遍历: 4 2 5 1 6 3 7
 * 后序遍历: 4 5 2 6 7 3 1
 * <p>
 * 复杂度分析：
 * 递归方法：时间复杂度：O(n)，空间复杂度：O(n)
 * 迭代方法：时间复杂度：O(n)，空间复杂度：O(n)
 * Morris方法：时间复杂度：O(n)，空间复杂度：O(1)
 */
public class TestMethod7_1 {

    public static class TreeNode<E> {
        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

        public void setLeftAndRight(TreeNode<E> left, TreeNode<E> right) {
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
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        node1.setLeftAndRight(node2, node3);
        node2.setLeftAndRight(node4, node5);
        node3.setLeftAndRight(node6, node7);

        System.out.print("层序遍历：");
        centerPrint_1(node1);
        System.out.println();
        System.out.print("打印出二叉树每一层的第一个或最后一个节点：");
        centerPrint_2(node1);
        System.out.println();

        System.out.print("递归打印前序遍历: ");
        printPreorder_1(node1);
        System.out.println();
        System.out.print("迭代打印前序遍历: ");
        printPreorder_2(node1);
        System.out.println();
        System.out.print("Morris打印前序遍历: ");
        printPreorder_3(node1);
        System.out.println();

        System.out.print("递归打印中序遍历: ");
        printInorder_1(node1);
        System.out.println();
        System.out.print("迭代打印中序遍历: ");
        printInorder_2(node1);
        System.out.println();
        System.out.print("Morris打印中序遍历: ");
        printInorder_3(node1);
        System.out.println();

        System.out.print("递归打印后序遍历: ");
        printPostorder_1(node1);
        System.out.println();
        System.out.print("迭代打印后序遍历: ");
        printPostorder_2(node1);
        System.out.println();
        System.out.print("Morris打印后序遍历: ");
        printPostorder_3(node1);
        System.out.println();
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    private static void centerPrint_1(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
    }

    /**
     * 打印出二叉树每一层的第一个节点。
     * 打印出二叉树每一层的最后一个节点。
     *
     * @param root 根节点
     */
    private static void centerPrint_2(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                // 打印每一层的第一个节点
                if (i == 0) System.out.print(temp.value + " ");
                // 打印每一层的最后一个节点
                // if (i == length - 1) System.out.println("每一层的最后一个节点为：" + temp.value);
            }
        }
    }

    /**
     * 递归打印前序遍历
     *
     * @param head 根节点
     */
    public static void printPreorder_1(TreeNode head) {
        if (head == null) return;

        System.out.print(head.value + " ");
        printPreorder_1(head.left);
        printPreorder_1(head.right);
    }

    /**
     * 迭代打印前序遍历
     *
     * @param head 根节点
     */
    public static void printPreorder_2(TreeNode head) {
        if (head == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(head);
        TreeNode temp;
        while (!stack.empty()) {
            temp = stack.pop();//不断改变temp的内容，不改变它指向的地址空间
            System.out.print(temp.value + " ");
            //因为栈是"后进先出"的，故先添加右节点，再添加左节点
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
    }

    public static void printPreorder_3(TreeNode head) {
        if (head == null) return;

        TreeNode cur1 = head;// 当前开始遍历的节点
        TreeNode cur2 = null;// 记录当前结点的左子树
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                // 找到当前左子树的最右侧节点，且这个节点应该在指向根结点之前，否则整个节点又回到了根结点。
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                // 这个时候如果最右侧这个节点的右指针没有指向根结点，创建连接然后往下一个左子树的根结点进行连接操作。
                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.print(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                } else {
                    // 当左子树的最右侧节点有指向根结点，此时说明我们已经回到了根结点并重复了之前的操作，
                    // 同时在回到根结点的时候我们应该已经处理完左子树的最右侧节点了，把路断开。
                    cur2.right = null;
                }
            } else {
                System.out.print(cur1.value + " ");
            }
            cur1 = cur1.right;// 一直往右边走，参考图
        }
    }

    /**
     * 递归打印中序遍历
     *
     * @param head 根节点
     */
    public static void printInorder_1(TreeNode head) {
        if (head == null) return;

        printInorder_1(head.left);
        System.out.print(head.value + " ");
        printInorder_1(head.right);
    }

    /**
     * 迭代打印中序遍历
     *
     * @param head 根节点
     */
    public static void printInorder_2(TreeNode head) {

        if (head == null) return;

        TreeNode cur = head;
        TreeNode node;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }
    }

    /**
     * Morris打印中序遍历
     *
     * @param head 根节点
     */
    public static void printInorder_3(TreeNode head) {
        if (head == null) return;

        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            //构建连接线
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            System.out.print(cur1.value + " ");
            cur1 = cur1.right;
        }
    }

    /**
     * 递归打印后序遍历
     *
     * @param head 根节点
     */
    public static void printPostorder_1(TreeNode head) {
        if (head == null) return;

        printPostorder_1(head.left);
        printPostorder_1(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 迭代打印后序遍历
     *
     * @param head 根节点
     */
    public static void printPostorder_2(TreeNode head) {
        if (head == null) return;

        TreeNode cur = head;
        TreeNode peek;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            peek = stack.peek();

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
                System.out.print(stack.pop().value + " ");
                cur = peek;
            }
        }
    }

    /**
     * Morris打印后序遍历
     *
     * @param head 根节点
     */
    public static void printPostorder_3(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur1 = head;//遍历树的指针变量
        TreeNode cur2 = null;//当前子树的最右节点
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    postMorrisPrint(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        postMorrisPrint(head);
    }

    /**
     * 打印函数
     *
     * @param head 根节点
     */
    public static void postMorrisPrint(TreeNode head) {
        TreeNode reverseList = postMorrisReverseList(head);
        TreeNode cur = reverseList;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        postMorrisReverseList(reverseList);
    }

    /**
     * 翻转单链表
     *
     * @param head 根节点
     * @return
     */
    public static TreeNode postMorrisReverseList(TreeNode head) {
        TreeNode cur = head;
        TreeNode pre = null;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}

