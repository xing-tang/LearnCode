package com.open.learncode.算法.java.剑指offer.A09_模拟;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：
 * 扑克牌中的顺子：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为0，可以看成任意数字。A不能视为14。
 * <p>
 * 解题思路：
 * 集合Set+遍历，排序+遍历
 * 特殊顺子：10 11 12 13 1(A)
 * <p>
 * 复杂度分析：
 * 方法一：
 * 时间复杂度：O(N)=O(5)=O(1)，其中N为nums长度，本题中N=5；遍历数组使用O(N)时间。
 * 空间复杂度：O(N)=O(5)=O(1)，用于判重的辅助Set使用O(N)额外空间。
 * 方法二：
 * 时间复杂度：O(NlogN)=O(5log5)=O(1)，其中N为nums长度，本题中N=5；数组排序使用O(NlogN)时间。
 * 空间复杂度：O(1)，变量joker使用O(1)大小的额外空间。
 */
public class JZ61_扑克牌的顺子 {

    public static void main(String[] args) {
        int[] nums = {9, 11, 12, 13, 1};
        int[] nums2 = {10, 11, 12, 13, 1};
        int[] nums3 = {10, 11, 12, 9, 13};
        System.out.println("是否是顺子：" + method_1(nums));
        System.out.println("是否是顺子：" + method_1(nums2));
        System.out.println("是否是顺子：" + method_1(nums3));
    }

    /**
     * @param nums 待输入的数组
     * @return 返回是否是顺子，true为是顺子，false为不是顺子
     */
    public static boolean method_1(int[] nums) {
        // 这里选择数组来帮助判断，是因为数组的查找效率最高
        int[] arr = new int[14];
        int min = 14, max = 0;
        boolean isSpecial = false;
        for (int num : nums) {
            // 遇到大小王，直接返回
            if (num == -1) return false;
            // 对 1(A) 特殊处理
            if (num == 1) {
                isSpecial = true;
            } else {
                min = Math.min(min, num);
            }
            max = Math.max(max, num);
            // 有重复的
            if (arr[num] != 0) {
                return false;
            }
            arr[num] = num;
        }
        return (!isSpecial && max - min == 4) || (isSpecial && max - min == 3);
    }

    /**
     * 排序+遍历
     *
     * @param nums 待输入的数组
     * @return 返回是否是顺子，true为是顺子，false为不是顺子
     */
    public static boolean method_2(int[] nums) {

        //大小王的数量
        int joker = 0;

        // 数组排序
        Arrays.sort(nums);

        for (int i = 0; i < 4; i++) {
            // 统计大小王数量
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {// 若有重复，提前返回 false
                return false;
            }
        }

        //joker为大小王（即0）的数量，nums[0]...nums[joker-1]的值都为0，nums[joker]为最小牌
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }

}
