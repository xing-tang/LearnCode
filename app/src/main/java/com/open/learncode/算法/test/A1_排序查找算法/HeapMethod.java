package com.open.learncode.算法.test.A1_排序查找算法;

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
 * 时间复杂度：O(nlogn)，空间复杂度：都为O(1)
 */
public class HeapMethod {
    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 1, 3, 5, 8, 9, 6};
//        int[] arr = {3, 6, 8, 5, 7};
        PrintUtils.getInstance().printIntArray(arr);
        heapSort(arr);
        PrintUtils.getInstance().printIntArray(arr);
    }

//    /**
//     * 堆排序算法
//     *
//     * @param arr 待输入的数组
//     * @return 返回排序后的数组
//     */
//    private static int[] heapSort(int[] arr) {
//        len = arr.length;
//        if (len < 1) return arr;
//        // 1.构建一个最大堆
//        buildMaxHeap(arr);
//        // 2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
//        while (len > 0) {
//            swap(arr, 0, len - 1);
//            len--;
//            adjustHeap(arr, 0);
//        }
//        return arr;
//    }

    /**
     * 堆排序算法
     *
     * @param arr 待输入的数组
     * @return 返回排序后的数组
     */
    private static int[] heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;

        // 1.构建一个最大堆
        heapInsert(arr);
        int size = arr.length;
        // 2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (size > 1) {
            // 固定最大值
            swap(arr, 0, size - 1);
            size--;
            // 构造大根堆
            heapify(arr, 0, size);
        }
        return arr;
    }

    //构造大根堆（通过新插入的数上升）
    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //当前插入的索引
            int currentIndex = i;
            //父结点索引
            int fatherIndex = (currentIndex - 1) / 2;
            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                //交换当前结点与父结点的值
                swap(arr, currentIndex, fatherIndex);
                //将当前索引指向父索引
                currentIndex = fatherIndex;
                //重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    //将剩余的数构造成大根堆（通过顶端的数下降）
    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }

    }


//    // 声明全局变量，用于记录数组arr的长度；
//    private static int len;
//
//    /**
//     * 堆排序算法
//     *
//     * @param arr 待输入的数组
//     * @return 返回排序后的数组
//     */
//    private static int[] heapSort(int[] arr) {
//        len = arr.length;
//        if (len < 1) return arr;
//        // 1.构建一个最大堆
//        buildMaxHeap(arr);
//        // 2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
//        while (len > 0) {
//            swap(arr, 0, len - 1);
//            len--;
//            adjustHeap(arr, 0);
//        }
//        return arr;
//    }
//
//    /**
//     * 建立最大堆
//     *
//     * @param arr 待输入的数组
//     */
//    private static void buildMaxHeap(int[] arr) {
//        // 从最后一个非叶子节点开始向上构造最大堆
//        //f or循环这样写会更好一点：i的左子树和右子树分别2i+1和2(i+1)
//        for (int i = (len / 2 - 1); i >= 0; i--) {
//            adjustHeap(arr, i);
//        }
//    }
//
//    /**
//     * 调整使之成为最大堆
//     *
//     * @param arr 待输入的数组
//     * @param i
//     */
//    private static void adjustHeap(int[] arr, int i) {
//        int maxIndex = i;
//        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
//        if (i * 2 < len && arr[i * 2] > arr[maxIndex])
//            maxIndex = i * 2 + 1;
//        // 如果有右子树，且右子树大于父节点，则将最大指针指向右子树
//        if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[maxIndex])
//            maxIndex = i * 2 + 2;
//        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
//        if (maxIndex != i) {
//            swap(arr, maxIndex, i);
//            adjustHeap(arr, maxIndex);
//        }
//    }

    /**
     * 交互数组中索引角标i和索引角标j对应的元素
     *
     * @param arr 待输入的数组
     * @param i   索引角标i
     * @param j   索引角标j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     *
     * @param arr 待输入的数组
     */
    private static void print(int[] arr) {
        if (arr == null || arr.length <= 0) return;

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
}
