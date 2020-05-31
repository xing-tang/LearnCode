package com.open.learncode.剑指offer;

/**
 * 题目：
 * 调整数组顺序使奇数位于偶数前面：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * <p>
 * 解题思路：
 * 快速排序
 * <p>
 * 复杂度分析：
 * 方法一、二：
 * 时间复杂度：O(n)  空间复杂度：O(1)
 */
public class TestMethod21 {

    public static void main(String[] args) {

        int data[] = {1, 2, 3, 4, 5};

        print(data);
//        method_1(data);
        method_2(data);
        print(data);


    }

    /**
     * 首尾双指针：
     * left一直往右移，直到指向的值为偶数；right一直往左移，直到指向的值为奇数
     * 交换data[left] data[right]，直到left==right
     *
     * @param data 待调整的数组
     */
    private static void method_1(int data[]) {

        //鲁棒性
        if (data == null && data.length <= 0)
            return;


        int left = 0, right = data.length - 1;

        while (left < right) {

            //向后移动left，直到它指向偶数
            while (left < right && (!func(data, left)))
                left++;

            //向前移动right，直到它指向奇数
            while (left < right && (func(data, right)))
                right--;

            //left指向偶数，right指向奇数，且left<right，交换两者位置
            if (left < right)
                swap(data, left, right);
        }
    }

    //扩展性更高，能适应更多的判断标准
    //如：使所有负数位于非负数前面；使能被3整除的数位于不能被3整除的数的前面
    private static boolean func(int data[], int position) {
        //num&1==1 num为奇数；num&1==0 num为偶数
        return ((data[position] & 1) == 0);
    }

    /**
     * 快慢指针：
     * fast在前，low在后，fast向前搜索奇数的位置，low指向下一个奇数应当存放的位置
     * 交换data[low] data[fast]，low向前移动一个位置，直到fast指向数组末尾
     *
     * @param data 待调整的数组
     */
    private static void method_2(int[] data) {

        //鲁棒性
        if (data == null && data.length <= 0)
            return;

        int low = 0, fast = 0;

        while (fast < data.length) {

            //如果data[fast]为奇数
            if (!func(data,fast)) {
                //交换low fast位置的元素，low右移一位
                swap(data, low, fast);
                low++;
            }
            fast++;
        }
    }

    private static void print(int data[]) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    /**
     * 交换数组中下标为a b的值
     *
     * @param data
     * @param a
     * @param b
     */
    private static void swap(int data[], int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}