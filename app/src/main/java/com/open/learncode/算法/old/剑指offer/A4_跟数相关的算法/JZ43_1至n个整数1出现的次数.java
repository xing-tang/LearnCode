package com.open.learncode.算法.old.剑指offer.A4_跟数相关的算法;

/**
 * 题目：
 * 1~n整数中1出现的次数：输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1~12这些整数中包含1的数字有1、10、11和12，1一共出现5次
 * <p>
 * 解题思路：
 * 例子如n=1234，high=1, pow=1000, last=234。可以将数字范围分成两部分1~999和1000~1234
 * ①1~999这个范围1的个数是method(pow-1)
 * ②1000~1234这个范围1的个数需要分为两部分：
 * 1'千分位是1的个数：千分位为1的个数刚好就是234+1【last+1】，注意，这儿只看千分位，不看其他位
 * 2'其他位是1的个数：即是234中出现1的个数，为method(last)
 * ∴ 全部加起来是method(pow-1) + last + 1 + method(last);
 * <p>
 * 例子如3234，high=3, pow=1000, last=234。可以将数字范围分成两部分1~999，1000~1999，2000~2999和3000~3234
 * ①1~999这个范围1的个数是f(pow-1)
 * ②1000~1999这个范围1的个数需要分为两部分：
 * 1'千分位是1的个数：千分位为1的个数刚好就是pow，注意，这儿只看千分位，不看其他位
 * 2'其他位是1的个数：即是999中出现1的个数，为method(pow-1)
 * ③2000~2999这个范围1的个数是method(pow-1)
 * ④3000~3234这个范围1的个数是method(last)
 * ∴ 全部加起来是pow + high*method(pow-1) + method(last);
 * <p>
 * 复杂度分析：
 * 时间复杂度：O(logn)，空间复杂度：O(1)
 */

public class JZ43_1至n个整数1出现的次数 {

    public static void main(String[] args) {
        System.out.println("method_2=> 1出现的次数为：" + method(5));
    }


    /**
     * 从低位到高位：
     *
     * @param n
     * @return 返回1出现的次数
     */
    private static int method(int n) {
        if (n <= 0) return 0;

        // dight为位因子，count为1的出现次数
        int digit = 1, count = 0;

        // 初始：high为高位；cur为当前位；low为低位
        int high = n / 10, cur = n % 10, low = 0;

        // 当当前位不为0，或最高位不为0时，进入循环
        while (high != 0 || cur != 0) {

            if (cur == 0)
                count += high * digit;

            else if (cur == 1)
                count += high * digit + low + 1;
            else // cur > 1
                count += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }
}