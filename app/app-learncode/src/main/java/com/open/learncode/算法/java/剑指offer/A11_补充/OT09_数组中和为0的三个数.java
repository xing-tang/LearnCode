package com.open.learncode.算法.java.剑指offer.A11_补充;

import com.open.learncode.算法.base.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：
 * 数组中和为0的三个数：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，
 * 使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(n^2)。
 * 空间复杂度：O(logn)。
 */
public class OT09_数组中和为0的三个数 {

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution(nums);
        PrintUtils.getInstance().print(lists.toString());
    }

    private static List<List<Integer>> solution(int[] nums) {
        // 时间复杂度：O(n^2)
        // 空间复杂度：O(logn)
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int ll = i + 1, rr = n - 1;
            int target = -nums[i];
            while (ll < rr) {
                int sum_ = nums[ll] + nums[rr];
                if (sum_ == target) {
                    lists.add(Arrays.asList(nums[i], nums[ll], nums[rr]));
                    while (ll < rr && nums[ll] == nums[++ll]) ;
                    while (ll < rr && nums[rr] == nums[--rr]) ;
                } else if (sum_ > target)
                    rr--;
                else
                    ll++;
            }
        }
        return lists;
    }
}

