package com.open.learncode.算法.java.排序算法;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 堆排序
 * 示例：测试b、d、e，分别对应三种情况
 * ******大根堆
 * *******9
 * ***** / \
 * *****6   8
 * *** /\  / \
 * ***5 3 4  7
 * * / \
 * *2  1
 * 其对应的映射数组：{9,6,8,5,3,4,7,2,1}
 * <p>
 * 解题思路:
 * 堆是一颗完全二叉树，可分为大根堆和小根堆；
 * 每个结点的值都大于其左孩子和右孩子结点的值，称之为大根堆；
 * 每个结点的值都小于其左孩子和右孩子结点的值，称之为小根堆；
 * 父结点索引：(i-1)/2，左孩子索引：2*i+1，右孩子索引：2*i+2
 * 大根堆：arr(i)>arr(2*i+1) && arr(i)>arr(2*i+2)
 * 小根堆：arr(i)<arr(2*i+1) && arr(i)<arr(2*i+2)
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(nlogn)。
 * 空间复杂度：O(1)。
 */
public class ST05_堆排序 {
    public static void main(String[] args) {
        // 测试用例
        int[] nums = {4, 7, 2, 1, 3, 5, 8, 9, 6};
        // int[] nums = {3, 6, 8, 5, 7};
        // heapSort(nums);
        solution(nums);
        PrintUtils.getInstance().printArray(nums);
    }

    private static void solution(int[] nums) {
        // 1. 从最后一个非叶节点开始构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeap(nums, i, nums.length);
        }
        // 2. 从最小的叶子节点开始与根节点进行交换并重新构建大顶堆
        for (int j = nums.length - 1; j >= 0; j--) {
            swap(nums, 0, j);
            maxHeap(nums, 0, j);
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param nums   数组
     * @param i      下标
     * @param length 边界
     */
    public static void maxHeap(int[] nums, int i, int length) {
        // 先取出当前元素i
        int temp = nums[i];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 如果左子结点小于右子结点，k指向右子结点
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        // 将temp值放到最终的位置
        nums[i] = temp;
    }

    /**
     * 交换元素
     *
     * @param arr 数组
     * @param i   下标
     * @param j   下标
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
