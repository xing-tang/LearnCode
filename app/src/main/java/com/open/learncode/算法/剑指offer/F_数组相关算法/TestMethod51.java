package com.open.learncode.算法.剑指offer.F_数组相关算法;

/**
 * 题目：
 * 数组中的逆序对：在数组中的两个数字，如果前面一个数字大于后面一个数字，则这两个数字组成一组逆序对。
 * 输入一个数组，求出这个数组中逆序对的总数。
 * 例如，在数组{7,5,6,4}中，一共存在5个逆序对，分别是(7，5)、(7，6)、(7，4)、(5，4)、(6，4)
 * <p>
 * 解题思路：
 * 分治思想：归并排序
 * <p>
 * 复杂度分析：
 * 时间复杂度：同归并排序O(nlogn)。
 * 空间复杂度：同归并排序O(n)，因为归并排序需要用到一个临时数组。
 */

public class TestMethod51 {

    public static void main(String[] args) {

        int arr[] = {7, 5, 6, 4};
//        int arr[]={8,12,12,22,100,9,26,55,64,91};
        System.out.println("数组中的逆序对总数为：" + reversePairs(arr));
    }

    /**
     * 归并排序
     * 时间复杂度：同归并排序O(nlogn)。
     * 空间复杂度：同归并排序O(n)，因为归并排序需要用到一个临时数组。
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {

        int len = nums.length;

        //长度至少为2，才能组成一对
        if (nums == null || len < 2)
            return 0;

        //如果不允许修改原始数组，需要添加下面的代码
//        int[] copy = new int[len];
//        for (int l = 0; l < len; l++) {
//            copy[l] = nums[l];
//        }

        //temp：用于归并两个有序数组
        int[] temp = new int[len];

        return reversePairs(nums, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private static int reversePairs(int[] nums, int left, int right, int[] temp) {

        //鲁棒性
        if (nums == null || nums.length <= 0)
            return 0;

        //递归终止条件：当有序数组只剩下一个元素时
        if (left == right)
            return 0;

        int mid = left + (right - left) / 2;
        //leftPairs：[left,mid]的逆序对个数；
        // rightPairs：[mid+1,right]的逆序对个数
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        //数组已经有序
        if (nums[mid] <= nums[mid + 1])
            return leftPairs + rightPairs;

        //crossPairs：跨越两个子区间的逆序对个数
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        //temp：辅助数组，拷贝nums中[left,right]范围内的元素
        for (int i = left; i <= right; i++)
            temp[i] = nums[i];

        //l r：分别指向两个子区间的第一个元素
        int l = left;
        int r = mid + 1;

        int count = 0;
        for (int j = left; j <= right; j++) {

            //[left=l,mid] [mid+1=r,right]
            //l == mid + 1：意昧着，[left,mid]左边的数组已经遍历完毕
            if (l == mid + 1) {
                nums[j] = temp[r];
                r++;
            }
            //r == right + 1：意味着，[mid+1,right]右边的数组已经遍历完毕
            else if (r == right + 1) {
                nums[j] = temp[l];
                l++;
            }
            //temp[l]<=temp[r]：temp[l] 贡献的逆序对个数为0
            else if (temp[l] <= temp[r]) {
                nums[j] = temp[l];
                l++;
            }
            //temp[l]>temo[r]：代表[left,mid] [mid+1,right]两个有序数组中，r指向的元素 < l指向的元素，
            // 故，temp[r] 贡献的逆序对个数为 左边有序数组的长度，即(mid-l+1)
            else {
                nums[j] = temp[r];
                r++;
                count += (mid - l + 1);
            }
        }
        return count;
    }
}
