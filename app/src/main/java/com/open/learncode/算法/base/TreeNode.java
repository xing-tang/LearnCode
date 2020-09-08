package com.open.learncode.算法.base;

/**
 * 自定义二叉树
 *
 * @param <E> 接受一个泛型
 */
public class TreeNode<E> {

    // 当前节点的值
    public E value;
    // 指向左孩子，默认为指向null
    public TreeNode<E> left;
    // 指向右孩子，默认为指向null
    public TreeNode<E> right;

    /**
     * 有一个参数的构造函数
     *
     * @param value 接受一个泛型值
     */
    public TreeNode(E value) {
        this.value = value;
    }

    /**
     * 有三个参数的构造函数
     *
     * @param value 接受一个泛型值
     * @param left  接受指向左孩子的泛型值
     * @param right 接受指向右孩子的泛型值
     */
    public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * 设置左孩子和右孩子
     *
     * @param left  接受指向左孩子的泛型值
     * @param right 接受指向右孩子的泛型值
     */
    public void setLeftAndRight(TreeNode<E> left, TreeNode<E> right) {
        this.left = left;
        this.right = right;
    }
}

