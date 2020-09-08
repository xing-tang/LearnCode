package com.open.learncode.算法.查找算法.T5_分块查找_未完成;

import java.util.ArrayList;


public class BlockSearch {

    /**
     * @param args
     * @Descript:测试
     * @author LJonah 2018年3月12日
     */
    public static void main(String[] args) {
        int[] index = {10, 20, 30};
        BlockSearch blocksearch = new BlockSearch(index);
        blocksearch.insert(1);
        blocksearch.insert(11);
        blocksearch.insert(21);

        blocksearch.insert(2);
        blocksearch.insert(12);
        blocksearch.insert(22);

        blocksearch.insert(5);
        blocksearch.insert(15);
        blocksearch.insert(25);

        blocksearch.printAll();

        System.out.println("查找值15   结果" + blocksearch.search(15));
        System.out.println("查找值29   结果" + blocksearch.search(29));
    }

    private int[] index;//建立索引
    private ArrayList[] list;


    /**
     * @param index
     * @Descript:初始化索引
     * @author LJonah 2018年3月12日
     */
    public BlockSearch(int[] index) {
        if (null != index && index.length != 0) {
            this.index = index;
            this.list = new ArrayList[index.length];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList();//初始化容器
            }
        } else {
            throw new Error("index cannot be null or empty");
        }
    }


    /**
     * @param value
     * @Descript:插入索引
     * @author LJonah 2018年3月12日
     */
    public void insert(int value) {
        int i = binarySearch(value);
        list[i].add(value);
    }


    /**
     * @param value
     * @return
     * @Descript:二分法查找
     * @author LJonah 2018年3月12日
     */
    private int binarySearch(int value) {
        int start = 0, end = index.length;
        int mid = 0;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (index[mid] > value) {
                end = mid - 1;
            } else {
                //如果相等，也插入后面
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * @param data
     * @return
     * @Descript:查找元素
     * @author LJonah 2018年3月12日
     */
    public boolean search(int data) {
        int i = binarySearch(data);
        for (int j = 0; j < list[i].size(); j++) {
            if (data == (int) list[i].get(j)) {
                System.out.println(String.format("查找元素为第: %d块  第%d个 元素", i + 1, j + 1));
                return true;
            }
        }
        return false;
    }

    /**
     * @Descript:打印每块的元素
     * @author LJonah 2018年3月12日
     */
    public void printAll() {
        for (int i = 0; i < list.length; i++) {
            ArrayList l = list[i];
            System.out.println("ArrayList[" + i + "]:");

            for (int j = 0; j < l.size(); j++) {
                System.out.println(l.get(j) + "    ");
            }
        }
    }


}
