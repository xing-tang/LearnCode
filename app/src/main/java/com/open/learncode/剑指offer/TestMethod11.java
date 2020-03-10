package com.open.learncode.剑指offer;

/**
 * 题目：
 * 旋转数组的最小数字：把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * <p>
 * 解题思路：
 * 二分查找法
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)   空间复杂度：O(1)
 * 最差时间复杂度：即为顺序查找时，需遍历数据下标i-j的元素，时间复杂度为O(n)
 */
public class TestMethod11 {

    public static void main(String[] args) {

//        int data[] = {1,1,1,0,1};
//        int data[] = {1,0,1,1,1};
//        int data[]={3,4,5,1,2};
        int data[]={1,2,3,4,5};
//        int data[]={3,4,5,1,2,3};
//        int data[]={1};
//        int data[]={};


        System.out.println("最小元素为：" + method(data, data.length));

    }

    /**
     * 二分查找法
     *
     * @param data   数组
     * @param length 数组长度
     * @return 数组中最小元素
     */
    private static int method(int data[], int length) {

        //验证数据合法性
        if (data == null || length <= 0)
            return -1;

        //两个指针，分别指向数组的第一个元素和最后一个元素
        int i = 0;
        int j = length - 1;

        //最小元素所在下标，并初始化为i，原因在下面
        int minIndex = i;

        //如果第一个指针的元素大于第二个指针的元素
        while (data[i] >= data[j]) {

            //循环终止条件：两个指针指向两个相邻的元素怒，第二个指针指向的刚好就是最小的元素
            if (j - i == 1) {
                minIndex = j;
                break;
            }

            int mid = (i + j) / 2;

            //如果下标为i j mid指向的三个数字相等，则只能顺序查找
            if(data[i]==data[j] && data[mid]==data[i]){
                return minInOrder(data,i,j);
            }

            //如果中间元素位于前面的递增子数组，此时，最小元素应该位于该中间元素的后面
            if (data[mid] >= data[i])
                i = mid;
                //如果中间元素位于后面的递增子数组，此时，最小元素应该位于该中间元素的前面
            else
                j = mid;
        }

        //如果第一个指针的元素小于第二个指针的元素，就代表该数组是排序的，直接返回第一个元素
        //这也是为什么要把minIndex初始化为i的原因
        return data[minIndex];
    }

    /**
     * 顺序查找
     *
     * @param data
     * @param i
     * @param j
     * @return 返回data数组中下标i-j之间的最小元素
     */
    private static int minInOrder(int[] data, int i, int j) {

        int result=data[i];
        for (int index =i+1; index <=j ; index++) {

            if(result>data[index]){
                result=data[index];
            }
        }
        return result;
    }

}

