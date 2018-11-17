package com.open.learncode.java.let;

import java.util.*;

/**
 * 217.存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Lte_217 {

    public static void main(String[] args) {

        Lte_217 lte = new Lte_217();
        int[] nums1 = {4, 2, 3, 1};
        int[] nums2 = {9, 2, 3, 9};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("[1,2,3,1]是否有重复元素：" + lte.containsDuplicate1(nums1));
        System.out.println("[1,2,3,1]是否有重复元素：" + lte.containsDuplicate2(nums1));
        System.out.println("[1,2,3,1]是否有重复元素：" + lte.containsDuplicate4(nums2));
        System.out.println("[1,2,3,4]是否有重复元素：" + lte.containsDuplicate3(nums2));
        System.out.println("[1,1,1,3,3,4,3,2,4,2]是否有重复元素："+lte.containsDuplicate1(nums3));

    }

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用set集合
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    /**
     * 利用排序
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    /**
     * 利用Map不能存放相同的键的特性,
     * 注意：如果当前map没有存在当前key值put后会返回null，
     * 如果存在则返回其map集合中key值对应的balue值
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate4(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            if (map.put(i,i)!=null){
                return true;
            }
        }
        return false;
    }

}
