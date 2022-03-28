package com.old.old.delete;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目：
 * 数据流中的中位数：如何得到一个数据流中的中位数？如果从数据流中读出奇数个
 * 数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序后中间两个数的平均值
 * <p>
 * 解题思路：
 * 建立一个 小顶堆 A 和 大顶堆 B ，各保存列表的一半元素，且规定：
 * A保存较大的一半，长度为N/2（N为偶数）或 (N+1)/2（N为奇数）
 * B保存较小的一半，长度为长度为N/2（N为偶数）或 (N+1)/2（N为奇数）
 * 随后，中位数可仅根据 A,B 的堆顶元素计算得到
 * <p>
 * 复杂度分析：
 * 时间复杂度：
 * 查找中位数 O(1) ： 获取堆顶元素使用 O(1) 时间；
 * 添加数字 O(logN) ： 堆的插入和弹出操作使用 O(logN) 时间。
 * 空间复杂度 O(N) ：其中 N 为数据流中的元素数量，小顶堆 A 和大顶堆 B 最多同时保存 N 个元素。
 */

public class TestMethod41 {

    // 小顶堆，保存较大的一半(排序：入队->出队 大->小）
    static Queue<Integer> A = new PriorityQueue<>();
    // 大顶堆，保存较小的一半(排序：出队->入队 大->小）
    static Queue<Integer> B = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void main(String[] args) {

        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
//        int[] nums = {5, 2, 4, 3, 1, 6};
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
        }

        System.out.println("中位数为：" + findMedian());


        int Asize = A.size();
        int Bsize = B.size();

        for (int i = 0; i < Asize; i++) {
            System.out.print(A.poll() + " ");
        }
        System.out.println();
        for (int i = 0; i < Bsize; i++) {
            System.out.print(B.poll() + " ");
        }

    }

    private static void addNum(int num) {
        if (A.size() != B.size()) {
            //由于 nums 可能属于 “较小的一半” （即属于B），因此不能将nums直接插入至A 。
            // 而应先将num插入至B ，再将B堆顶元素插入至A 。
            A.add(num);
            B.add(A.poll());
        } else {
            //由于 nums 可能属于 “较大的一半” （即属于A），因此不能将nums直接插入至B 。
            // 而应先将num插入至A ，再将B堆顶元素插入至B 。
            B.add(num);
            A.add(B.poll());
        }
    }

    private static double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

}