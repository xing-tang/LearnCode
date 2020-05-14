package com.open.learncode.剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目：
 * 输入n个整数，找出其中最小的k个数。
 * 例如：输入{4,5,1,6,2,7,3,8}这8个数字，则最小的4个数字是{1,2,3,4}。
 * <p>
 * 解题思路：
 * 堆、快排变形、BFPRT
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(nlogk)，空间复杂度：O(k)
 * 方法二：时间复杂度：平均时间复杂度O(n)【最好O(n)，最差O(n^2)】，空间复杂度：O(1)
 */
public class TestMethod40 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        //int[] temp1 = method_1(arr, k);
        int[] temp2 = method_2(arr, k);
        System.out.println();
    }

    /**
     * 堆方法
     *
     * @param arr 传入的数组
     * @param k   最小的k个数
     * @return 返回前最小的k个数对应的数组
     */
    public static int[] method_1(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }

    /**
     * 快排变形
     *
     * @param arr 传入的数组
     * @param k   最小的k个数
     * @return 返回前最小的k个数对应的数组
     */
    public static int[] method_2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }
        // 原地不断划分数组
        method_2(arr, 0, arr.length - 1, k);
        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void method_2(int[] arr, int left, int right, int k) {
        if (left > right) return;
        // 左边哨兵的索引
        int i = left;
        // 右边哨兵的索引
        int j = right;
        // temp就是基准位,以最左边为基准位
        int base = arr[left];
        while (i < j) {
            // 先看右边，依次往左递减
            while (base <= arr[j] && i < j) {
                j--;
            }
            while (base >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                // 左右哨兵 交换数据（互相持有对方的数据）
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = base;
        if (k == j) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < j) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            //递归调用左半数组
            method_2(arr, left, j - 1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            //递归调用右半数组
            method_2(arr, j + 1, right, k);
        }
    }


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

}
