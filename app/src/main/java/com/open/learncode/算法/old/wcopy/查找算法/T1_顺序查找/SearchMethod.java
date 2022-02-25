package com.open.learncode.算法.old.wcopy.查找算法.T1_顺序查找;

/**
 * 题目：
 * 顺序查找
 * <p>
 * 解题思路:
 * 从头到尾依次遍历整个待查序列，效率低
 * <p>
 * 复杂度分析:
 * 时间复杂度：O(n)，空间复杂度：都为O(1)
 */
public class SearchMethod {

    public static void main(String[] args) {
        int[] nums = {8, 3, 5, 2, 1};
        int target = 5;
        System.out.println("查找结果：" + method(nums, target));
    }

    /**
     * 顺序查找指定元素
     *
     * @param nums    待输入的一位数组
     * @param target 待查找的元素
     * @return 返回对应的索引坐标位置，如果不存在则返回-1
     */
    private static int method(int[] nums, int target) {
        if (nums == null || nums.length <= 0) return -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}
