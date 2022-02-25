package com.open.learncode.算法.old.wcopy.leetcode_快手;

import com.open.learncode.算法.base.PrintUtils;

import java.util.Random;

public class TopN {

    public static void main(String[] args) {
        int maxNumber = 100000000;
        int topK = 101;
        int[] data = new int[maxNumber];
        Random random = new Random();
        for (int i = 0; i < maxNumber; i++) {
            data[i] = i + 1;
        }
        int[] temp = findTopN(data, topK);

        for (int i = 0; i < topK; i++) {
            PrintUtils.getInstance().print(temp[i]);
        }
    }

    // 寻找topN，该方法改变data，将topN排到最前面
    public static int[] findTopN(int[] data, int topk) {
        // 先构建topk个数的小顶堆
        buildHeap(data, topk);
        // topk往后的数进行调整
        for (int i = topk; i < data.length; i++) {
            adjust(data, topk, i);
        }
        return data;
    }

    // 构建堆
    private static void buildHeap(int[] data, int topk) {
        for (int i = 1; i < topk; i++) {
            int t = i;
            // 调整堆
            while (t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    // 调整data[i]
    private static void adjust(int[] data, int topK, int i) {
        if (data[i] <= data[0]) {
            return;
        }
        // 置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        // 调整堆顶
        int t = 0;
        while ((left(t) < topK && data[t] > data[left(t)])
                || (right(t) < topK && data[t] > data[right(t)])) {
            if (right(t) < topK && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    // 父节点
    private static int parent(int n) {
        return (n - 1) / 2;
    }

    // 左孩子
    private static int left(int n) {
        return 2 * n + 1;
    }

    // 右孩子
    private static int right(int n) {
        return 2 * n + 2;
    }
}