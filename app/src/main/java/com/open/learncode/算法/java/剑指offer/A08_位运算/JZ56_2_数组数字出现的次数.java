package com.open.learncode.算法.java.剑指offer.A08_位运算;

import com.open.learncode.算法.base.PrintUtils;

/**
 * 题目：
 * 在一个数组nums中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 例如：输入：nums = [9,1,7,9,7,9,7]，输出：1
 * <p>
 * 解题思路：
 *
 * <p>
 * 复杂度分析：
 */
public class JZ56_2_数组数字出现的次数 {

    public static void main(String[] args) throws Exception {
        int[] num = {9, 6, 7, 9, 7, 9, 7};
//        PrintUtils.getInstance().print(method(num));
//        PrintUtils.getInstance().print(singleNumber1(num));
        PrintUtils.getInstance().print(singleNumber2(num));
    }

    public static int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static int singleNumber2(int[] nums) {//本算法同样适用于数组nums中存在负数的情况
        if(nums.length==0) return -1;//输入数组长度不符合要求，返回-1;
        int[] bitSum = new int[32];//java int类型有32位，其中首位为符号位
        int res=0;
        for(int num:nums){
            int bitMask=1;//需要在这里初始化，不能和res一起初始化
            for(int i=31;i>=0;i--){//bitSum[0]为符号位
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if((num&bitMask)!=0) bitSum[i]++;//这里判断条件也可以写为(num&bitMask)==bitMask,而不是==1
                bitMask=bitMask<<1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }
        for(int i=0;i<32;i++){//这种做法使得本算法同样适用于负数的情况
            res=res<<1;
            res^=bitSum[i]%3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;
    }



    public static int method(int[] num) throws Exception {
        if (num == null || num.length <= 0)
            throw new Exception("无效的输入");

        int[] temp = new int[32];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < 32; j++) {
                temp[j] += num[i] & 1;
                num[i] >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= temp[31 - i] % m;
        }
        return res;
    }
}
