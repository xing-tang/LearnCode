package com.open.learncode.剑指offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为0，
 * 可以看成任意数字。A不能视为14。
 * <p>
 * 解题思路：
 * 集合Set+遍历，排序+遍历
 * <p>
 * 复杂度分析：
 * 方法一：
 * 时间复杂度：O(N)=O(5)=O(1)，其中N为nums长度，本题中N=5；遍历数组使用O(N)时间。
 * 空间复杂度：O(N)=O(5)=O(1)，用于判重的辅助Set使用O(N)额外空间。
 * 方法二：
 * 时间复杂度：O(NlogN)=O(5log5)=O(1)，其中N为nums长度，本题中N=5；数组排序使用O(NlogN)时间。
 * 空间复杂度：O(1)，变量joker使用O(1)大小的额外空间。
 */
public class TestMethod61 {

    public static void main(String[] args) {
        int[] nums = {8, 0, 12, 11, 0};
        System.out.println("是否是顺子：" + method_1(nums));
        System.out.println("是否是顺子：" + method_2(nums));
    }

    /**
     * 集合Set+遍历
     *
     * @param nums 待输入的数组
     * @return 返回是否是顺子，true为是顺子，false为不是顺子
     */
    public static boolean method_1(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    /**
     * 排序+遍历
     *
     * @param nums 待输入的数组
     * @return 返回是否是顺子，true为是顺子，false为不是顺子
     */
    public static boolean method_2(int[] nums) {
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
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }

}
