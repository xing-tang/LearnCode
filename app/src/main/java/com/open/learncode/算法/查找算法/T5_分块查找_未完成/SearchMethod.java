package com.open.learncode.算法.查找算法.T5_分块查找_未完成;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMethod {

    public static void main(String[] args) {
        // https://cloud.tencent.com/developer/article/1407004
    }

    /**
     * 分块查找
     *
     * @param arr    包含 0 - 9999 的整形数组
     * @param target
     * @return
     */
    private static int blockSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //将数组 arr分块 [0 - 99], [100 - 199] ... [9900 - 9999]
        int bucketNum = 100;
        List<List<Integer>> bucket = new ArrayList<List<Integer>>(bucketNum);
        for (int i = 0; i < 100; i++){
            bucket.add(new ArrayList<Integer>());
        }
        for (int num : arr) {
            int idx = num / bucketNum;
            List<Integer> subList = bucket.get(idx);
            subList.add(num);
        }
        //对每个块进行排序; 并将每个块的最大值放入 blockMaxNums
        List<Integer> blockMaxNums = new ArrayList<>();
        for (List<Integer> subList : bucket) {
            Collections.sort(subList);
            blockMaxNums.add(subList.get(subList.size() - 1));
        }
        //查找元素所在的区间
        int blockIdx = -1;
        for (int i = 0; i < blockMaxNums.size(); i++){
            if (target <= blockMaxNums.get(i)){
                blockIdx = i;
                break;
            }
        }
        if (blockIdx != -1){
            List<Integer> blockList = bucket.get(blockIdx);
            return blockList.indexOf(target);
        }
        return -1;
    }
}
