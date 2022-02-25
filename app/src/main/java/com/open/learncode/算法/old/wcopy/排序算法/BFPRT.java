package com.open.learncode.算法.old.wcopy.排序算法;

import com.open.learncode.算法.base.PrintUtils;

public class BFPRT {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] temp2 = getLeastNumbers(arr, k);
        PrintUtils.getInstance().printArray(temp2);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }
        BFPRT(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int BFPRT(int[] arr, int l, int r, int k) {
        int p = find_mid(arr, l, r);
        int i = partion(arr, l, r, p);

        int m = i - l + 1;
        if (m == k) {
            return arr[i];
        }
        if (m > k) {
            return BFPRT(arr, l, i - 1, k);
        }
        return BFPRT(arr, i + 1, r, k - m);
    }


    //插入排序
    public static void insert_sort(int[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            if (arr[i - 1] > arr[i]) {
                int t = arr[i];
                int j = i;
                while (j > l && arr[j - 1] > t) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = t;
            }
        }
    }

    //寻找中位数的中位数
    public static int find_mid(int[] arr, int l, int r) {
        if (l == r) {
            return l;
        }
        int i = 0, n = 0;
        for (i = l; i < r - 5; i += 5) {
            insert_sort(arr, i, i + 4);
            n = i - l;
            swap(arr, l + n / 5, i + 2);
        }

        int num = r - i + 1;
        if (num > 0) {
            insert_sort(arr, i, i + num - 1);
            n = i - l;
            swap(arr, l + n / 5, i + num / 2);
        }
        n = n / 5;
        if (n == l) {
            return l;
        }
        return find_mid(arr, l, l + n);
    }

    //进行划分过程
    public static int partion(int[] arr, int l, int r, int p) {
        swap(arr, p, l);
        int i = l;
        int j = r;
        int pivot = arr[l];
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }


    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
