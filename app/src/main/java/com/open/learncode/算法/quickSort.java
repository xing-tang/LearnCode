package com.open.learncode.算法;

/**
 * 题目：
 * 快速排序
 * <p>
 * 解题思路：
 * 在数组中选一个数字，把数组中的数组分成两部分，比选择的数字小的数字移到数组的左边
 * 比选择的数字大的数字移到数组的右边
 * <p>
 * 复杂度分析：
 */
public class quickSort {

    public static void main(String[] args) {

        int data[] = {49, 38, 65, 97, 23};
        int length = data.length;
        quickSort(data, length, 0, length - 1);
        printf(data);
    }

    /**
     * 快速排序
     *
     * @param data   要排序的数组
     * @param length 数组的长度
     * @param low    要排序的起点
     * @param high   要排序的终点
     */
    private static void quickSort(int data[], int length, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int temp = partition(data, length, low, high);


            // 进行迭代对temp之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(data, length, low, temp - 1);

            quickSort(data, length, temp + 1, high);
        }
    }

    /**
     * 根据获取的基准数据，对数组进行分组
     *
     * @param data   要分组的数组
     * @param length 数组的长度
     * @param low    要分组的起点
     * @param high   要分组的终点
     */
    private static int partition(int data[], int length, int low, int high) {

        //验证合法性
        if (data == null || length <= 0 || low < 0 || high >= length || low > high) {
            return -1;
        }

        // 基准数据
        int temp = data[low];

        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && data[high] >= temp) {
                high--;
            }
            // 如果队尾元素小于temp了,需要将其赋值给low
            data[low] = data[high];

            // 当队首元素小于等于temp时,向前挪动low指针
            while (low < high && data[low] <= temp) {
                low++;
            }
            // 当队首元素大于temp时,需要将其赋值给high
            data[high] = data[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是temp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是temp,所以需要将temp赋值给data[low]
        data[low] = temp;
        System.out.println(low);
        return low; // 返回temp的正确位置

    }


    /**
     * 交换一维数组的位置
     *
     * @param data 待交换的数组
     * @param a    待交换的一维数组索引a
     * @param b    待交换的一维数组索引b
     */
    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    private static void printf(int data[]) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

}

