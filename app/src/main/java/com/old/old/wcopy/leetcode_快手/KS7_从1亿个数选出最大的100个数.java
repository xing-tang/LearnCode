package com.old.old.wcopy.leetcode_快手;

import com.open.learncode.算法.base.PrintUtils;

import java.util.Random;

public class KS7_从1亿个数选出最大的100个数 {

    public static void main(String[] args) {
        int maxNumber = 20;
        int topK = 5;
        int[] arr = new int[maxNumber];
        Random random = new Random();
        for (int i = 0; i < maxNumber; i++) {
            arr[i] = Math.abs(random.nextInt(maxNumber));
        }
        PrintUtils.getInstance().printArray(arr);


        print(arr, maxNumber);
        for (int i = 0; i < topK; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //剩下的n-m个数与堆顶元素依次比较，并调整堆结构
    public static void print(int[] arr, int m) {
        //把前m个数建成最小堆
        createSmallHeap(arr, m);
        //把剩下的arr.length-m个数字依次与最小堆的堆顶元素比较
        //如果比堆顶元素大，那么就替换为堆顶，然后对堆顶进行调整。
        //当所有的元素遍历一遍后，堆中元素就是前m个最大的。
        for (int i = m; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                arr[0] = arr[i];
                adjustHeap(arr, m, 0);
            }
        }
    }

    //新建堆
    public static void createSmallHeap(int[] arr, int m) {
        for (int i = m / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, m, i);
        }
    }

    //调整为最小堆
    public static void adjustHeap(int[] arr, int m, int i) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < m; k = 2 * k + 1) {
            if (k + 1 < m && arr[k + 1] < arr[k]) k++;
            if (temp > arr[k]) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }

//    public static void main(String[] args) {
//        int numberCount = 100000000;
//        int maxNumber = numberCount;
//        int inputArray[] = new int[numberCount];
//        Random random = new Random();
//        for (int i = 0; i < numberCount; i++) {
//            inputArray[i] = Math.abs(random.nextInt(maxNumber));
//        }
//    }
//
//    public static void top100(int[] input){
//        if (input==null||input.length<=0) return;
//
//
//    }
//
//
//    public static void heapSort(int[] arr) {
//        //1.构建大顶堆
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            //从第一个非叶子结点从下至上，从右至左调整结构
//            adjustHeap(arr, i, arr.length);
//        }
//        //2.调整堆结构+交换堆顶元素与末尾元素
//        for (int j = arr.length - 1; j > 0; j--) {
//            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
//            adjustHeap(arr, 0, j);//重新对堆进行调整
//        }
//
//    }
//
//    /**
//     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
//     *
//     * @param arr
//     * @param i
//     * @param length
//     */
//    public static void adjustHeap(int[] arr, int i, int length) {
//        int temp = arr[i];//先取出当前元素i
//        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
//            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
//                k++;
//            }
//            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//                arr[i] = arr[k];
//                i = k;
//            } else {
//                break;
//            }
//        }
//        arr[i] = temp;//将temp值放到最终的位置
//    }
//
//    /**
//     * 交换元素
//     *
//     * @param arr
//     * @param a
//     * @param b
//     */
//    public static void swap(int[] arr, int a, int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }

}
