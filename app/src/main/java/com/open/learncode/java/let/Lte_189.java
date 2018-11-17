package com.open.learncode.java.let;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class Lte_189 {

    public static void main(String[] args){
        Lte_189 let = new Lte_189();
        int[] nums_1 = {1,2,3,4,5,6,7};
        let.showArray(let.rotate1(nums_1,3),null);
        int[] nums_2 = {-1,-100,3,99};
        let.showArray(let.rotate1(nums_2,2),null);
    }

    public int[] rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length-1];
            for (int j =  nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
        return nums;
    }

    public int[] rotate2(int[] nums, int k) {
        String sys = null;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length-1];
            for (int j =  nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
        return nums;
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
