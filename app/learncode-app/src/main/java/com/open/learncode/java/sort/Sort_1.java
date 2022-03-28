package com.open.learncode.java.sort;

/**
 * 选择排序
 * 定义：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕
 * 示例:
 * 给定 int[] nums = {63, 4, 24, 1, 3, 15}
 * 通过选择排序的方式从小到大排列，返回nums = {1, 3, 4, 15, 24, 63}
 * 通过选择排序的方法从大到小排列，返回nums = {63, 24, 15, 4, 3, 1}
 */
public class Sort_1 {

    public static void main(String[] args) {
        int[] nums = {63, 4, 24, 1, 3, 15};

        Sort_1 sort_1 = new Sort_1();
        sort_1.showArray(nums, "原始数组");
        sort_1.sortSmall(nums);
        sort_1.showArray(nums, "从小到大排序");
        sort_1.sortBig(nums);
        sort_1.showArray(nums, "从大到小排序");

    }

    /**
     * 选择排序（从小到大）
     *
     * @param array 待排序的数组
     */
    public void sortSmall(int[] array) {

        int len = array.length;
        for (int i = 0, k = 0; i < len; i++, k = i) {
            for (int j = i + 1; j < len; j++) {
                if (array[k] > array[j]) k = j;
            }
            //System.out.println("第" + i + "轮i=" + i + ";k=" + k);
            if (i != k) {
                int tmp = array[i];
                array[i] = array[k];
                array[k] = tmp;
            }
            //showArray(array,"");
        }

    }

    /**
     * 选择排序=（从大到小）
     *
     * @param array 待排序的数组
     */
    public void sortBig(int[] array) {
        int len = array.length;
        for (int i = 0, k = 0; i < len; i++, k = i) {
            for (int j = i + 1; j < len; j++) {
                if (array[k] < array[j]) {
                    k = j;
                }
            }
            //System.out.println("第" + i + "轮i=" + i + ";k=" + k);
            if (i != k) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
            //showArray(array,"");
        }
    }

    /**
     * 打印数组中所有的元素
     *
     * @param array 要打印的数组
     * @param des   添加的描述,可为null
     */
    public void showArray(int[] array, String des) {
        System.out.print(des + "nums = {");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("}");
        System.out.println();
    }

}
