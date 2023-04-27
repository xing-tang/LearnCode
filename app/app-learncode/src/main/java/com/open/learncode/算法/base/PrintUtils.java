package com.open.learncode.算法.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintUtils {

    public PrintUtils() {
    }

    public static PrintUtils getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final PrintUtils INSTANCE = new PrintUtils();
    }

    /**
     * 打印Object
     *
     * @param object 待输入的数组
     */
    public void print(Object object, String... str) {
        if (object == null) return;

        if (str.length <= 0) {
            System.out.print("打印：");
        } else {
            System.out.print(str[0] + "：");
        }
        System.out.println(object.toString());
    }

    /**
     * 打印数组
     *
     * @param arr 待输入的数组
     */
    public void printArray(Object[] arr, String... str) {
        if (arr == null || arr.length <= 0) return;

        if (str.length <= 0) {
            System.out.print("打印数组：");
        } else {
            System.out.print(str[0] + "：");
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("{" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                System.out.println(arr[i] + "}");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    /**
     * 打印一维数组
     *
     * @param arr 待输入的一维数组
     */
    public void printArray(char[] arr, String... str) {
        if (arr == null || arr.length <= 0) return;

        if (str.length <= 0) {
            System.out.print("打印数组：");
        } else {
            System.out.print(str[0] + "：");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr.length == 1) {
                System.out.println("{'" + arr[i] + "'}");
            } else if (i == 0) {
                System.out.print("{'" + arr[i] + "', ");
            } else if (i == arr.length - 1) {
                System.out.println("'" + arr[i] + "'}");
            } else {
                System.out.print("'" + arr[i] + "', ");
            }
        }
    }

    /**
     * 打印一维数组
     *
     * @param arr 待输入的一维数组
     */
    public void printArray(int[] arr, String... str) {
        if (arr == null || arr.length <= 0) return;

        if (str.length <= 0) {
            System.out.print("打印数组：");
        } else {
            System.out.print(str[0] + "：");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr.length == 1) {
                System.out.println("{" + arr[i] + "}");
            } else if (i == 0) {
                System.out.print("{" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                System.out.println(arr[i] + "}");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }

    /**
     * 打印二维数组
     *
     * @param arr 待输入的二维数组
     */
    public void printArray(int[][] arr, String... str) {
        if (arr == null || arr.length <= 0 || arr[0].length <= 0) return;

        if (str.length <= 0) {
            System.out.print("打印数组：");
        } else {
            System.out.print(str[0] + "：");
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("{{");
            } else {
                System.out.print("{");
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print(arr[i][j] + ",");
                }
            }
            if (i == arr.length - 1) {
                System.out.println("}}");
            } else {
                System.out.print("},");
            }
        }
    }

    /**
     * 打印ArrayList
     *
     * @param list ArrayList<Object>
     * @param str  String...
     */
    public void printArrayList(ArrayList<Integer> list, String... str) {
        if (list == null || list.size() <= 0) return;

        if (str.length <= 0) {
            System.out.print("打印数组：");
        } else {
            System.out.print(str[0] + "：");
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.size() == 1) {
                    System.out.println("{" + list.get(i) + "}");
                } else {
                    System.out.print("{" + list.get(i) + ",");
                }
            } else if (i == list.size() - 1) {
                System.out.println(list.get(i) + "}");
            } else {
                System.out.print(list.get(i) + ",");
            }
        }
    }

    /**
     * 打印ArrayList
     *
     * @param lists 待输入的数组
     */
    public void printIntArrayArrayList(ArrayList<ArrayList<Integer>> lists, String... str) {
        if (lists == null || lists.size() <= 0) return;

        System.out.print("{");
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                if (j == 0) {
                    if (lists.get(i).size() == 1) {
                        System.out.print("{" + lists.get(i).get(j) + "}");
                    } else {
                        System.out.print("{" + lists.get(i).get(j) + ",");
                    }
                } else if (j == lists.get(i).size() - 1) {
                    System.out.print(lists.get(i).get(j) + "}");
                } else {
                    System.out.print(lists.get(i).get(j) + ",");
                }
            }
            if (i != lists.size() - 1) System.out.print(",");
        }
        System.out.println("}");
    }


    /**
     * 打印某个节点的值
     *
     * @param head 待输入的头结点
     */
    public void printNode(ListNode head, String... str) {
        if (head == null) {
            System.out.print("打印节点值为空!");
            return;
        }

        if (str.length <= 0) {
            System.out.print("打印节点值为：");
        } else {
            System.out.print(str[0] + "：");
        }
        System.out.println(head.val);
    }

    /**
     * 打印链表
     *
     * @param head 待输入的头结点
     */
    public void printListNode(ListNode head, String... str) {
        if (head == null) return;

        if (str.length <= 0) {
            System.out.print("打印链表：");
        } else {
            System.out.print(str[0] + "：");
        }

        while (head != null) {
            if (head.next == null) {
                System.out.println(head.val);
                break;
            }
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    /**
     * 层序打印出二叉树
     *
     * @param root 待输入的根节点
     */
    public static void printCenterTreeNode(TreeNode root, String... str) {
        if (root == null) return;

        if (str.length <= 0) {
            System.out.print("打印二叉树层序遍历：");
        } else {
            System.out.print(str[0] + "：");
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
                System.out.print(temp.val + " ");
            }
        }
        System.out.println();
    }

    /**
     * 前序打印二叉树
     *
     * @param root 待输入的根节点
     */
    public static void printPreorderTreeNode(TreeNode root, String... str) {
        if (root == null) return;

        if (str.length <= 0) {
            System.out.print("打印二叉树前序遍历：");
        } else {
            System.out.print(str[0] + "：");
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode temp;
        while (!stack.empty()) {
            temp = stack.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        System.out.println();
    }

    /**
     * 中序打印二叉树
     *
     * @param root 待输入的根节点
     */
    public static void printInorderTreeNode(TreeNode root, String... str) {
        if (root == null) return;

        if (str.length <= 0) {
            System.out.print("打印二叉树中序遍历：");
        } else {
            System.out.print(str[0] + "：");
        }
        TreeNode cur = root;
        TreeNode node;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }
        System.out.println();
    }

    /**
     * 后序打印二叉树
     *
     * @param root 待输入的根节点
     */
    public static void printPostorderTreeNode(TreeNode root, String... str) {
        if (root == null) return;

        if (str.length <= 0) {
            System.out.print("打印二叉树后序遍历：");
        } else {
            System.out.print(str[0] + "：");
        }
        TreeNode cur = root;
        TreeNode peek;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            peek = stack.peek();
            if (peek.left != null && peek.left != cur && peek.right != cur) {
                stack.push(peek.left);
            } else if (peek.right != null && peek.right != cur) {
                stack.push(peek.right);
            } else {
                System.out.print(stack.pop().val + " ");
                cur = peek;
            }
        }
        System.out.println();
    }
}
