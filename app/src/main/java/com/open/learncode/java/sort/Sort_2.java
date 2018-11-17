package com.open.learncode.java.sort;

/**
 * 冒泡排序
 * 定义：对比相临的元素值，如果满足条件就交换元素值，把较小的元素移动到数组前面，
 * 把较大的元素移动到数组后面，这样较小的元素就会像气泡一样从底部上升到顶部
 * 示例:
 * 给定 int[] nums = {63, 4, 24, 1, 3, 15}
 * 通过冒泡排序的方式，返回nums = {1, 3, 4, 15, 24, 63}
 */
public class Sort_2 {

    public static void main(String[] args) {

        int[] nums = {63, 4, 24, 1, 3, 15};

        Sort_2 sort_2 = new Sort_2();
        sort_2.showArray(nums, "原始数组");
        sort_2.sort(nums);
        sort_2.showArray(nums, "从小到大排序");
    }

    /**
     * 冒泡排序
     *
     * @param array 待排序的数组
     */
    public void sort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            //System.out.println("第" + i + "轮i=" + i);
            for (int j = 0; j < len - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //showArray(array, "");
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
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
