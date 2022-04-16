package com.open.learncode.算法.java.剑指offer.A07_排序;

import com.open.learncode.算法.base.PrintUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：
 * 输入 n 个整数，找出其中最小的 k 个数。（就是 TopK 问题）
 * 例如：输入{8, 5, 6, 7, 9, 3, 1, 4}这8个数字，则最小的4个数字是{1, 3, 4, 5}。
 * <p>
 * 解题思路：
 * 快排变形。
 * <p>
 * 复杂度分析：
 * 方法一复杂度分析：
 * 时间复杂度：平均O(n)，最好O(n)，最坏O(n^2)。
 * 空间复杂度：O(logn)。
 * 方法二复杂度分析：
 * 时间复杂度：O(nlogk)。
 * 空间复杂度：O(k)。
 */
public class JZ40_找出数组中最小的k个数 {

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {8, 5, 6, 7, 9, 3, 1, 4};
        int k = 4;
        PrintUtils.getInstance().printArray(solution1(nums, k));
    }

    private static int[] solution1(int[] nums, int k) {
        if (k <= 0 || nums == null) return new int[0];
        if (nums.length < k) return nums;
        solution1(nums, 0, nums.length - 1, k);
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }

    private static void solution1(int[] nums, int left, int right, int k) {
        if (nums == null || nums.length <= 1 || left > right) return;

        int start = left, end = right, base = nums[left];
        while (start < end) {
            while (start < end && nums[end] >= base) end--;
            while (start < end && nums[start] <= base) start++;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        nums[left] = nums[start];
        nums[start] = base;
        if (start == k) {
            return;
        } else if (start > k) {
            solution1(nums, left, end - 1, k);
        } else {
            solution1(nums, end + 1, right, k);
        }
    }

    /**
     * 堆方法
     *
     * @param arr 传入的数组
     * @param k   最小的k个数
     * @return 返回前最小的k个数对应的数组
     */
    public static int[] solution2(int[] arr, int k) {
        if (k == 0) return new int[0];

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
}
