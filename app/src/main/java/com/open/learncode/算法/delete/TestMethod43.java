package com.open.learncode.算法.delete;

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
 * 方法一：
 * 时间复杂度：O(nlogn)【一共有n个数，每个数的位数为log10(n)，循环次数为位数】
 * 空间复杂度：O(1)【变量使用常数大小的额外空间】
 *
 * 方法二：
 * 时间复杂度：O(logn)【
 * 空间复杂度：O(1)
 *
 * 方法三：
 * 时间复杂度：O(logn)【循环次数为数字n的位数，即log10(n)】
 * 空间复杂度：O(1)【因为递归，空间用的稍多一些】
 */

public class TestMethod43 {


    public static void main(String[] args) {

        System.out.println("method_1=> 1出现的次数为：" + method_1(12));
        System.out.println("method_2=> 1出现的次数为：" + method_2(12));
        System.out.println("method_3=> 1出现的次数为：" + method_3(12));
    }

    /**
     * 对每个数字做除法和求余运算
     * 时间复杂度O(nlogn)  空间复杂度：O(1)
     *
     * @param n
     * @return
     */
    private static int method_1(int n) {
        int number = 0;

        if (n <= 0)
            return number;

        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j != 0) {

                if (j % 10 == 1)
                    number++;

                //如果n大于10
                j = j / 10;
            }
        }
        return number;

    }


    /**
     * 从低位到高位：
     *
     * @param n
     * @return
     */
    private static int method_2(int n) {

        if (n <= 0)
            return 0;

        //dight为位因子，count为1的出现次数
        int digit = 1, count = 0;

        //初始：high为高位；cur为当前位；low为低位
        int high = n / 10, cur = n % 10, low = 0;

        //当当前位不为0，或最高位不为0时，进入循环
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


    /**
     * 递归：从高位到低位
     * 时间复杂度：O(logn)【数n的位数】 空间复杂度：O(1)【变量使用常数大小的额外空间】
     *
     * @param n
     * @return
     */
    private static int method_3(int n) {

        if (n <= 0)
            return 0;

        //把int类型的整数转化为String类型的字符串
        String s = String.valueOf(n);

        //high：最高位的数字
        int high = s.charAt(0) - '0';

        int pow = (int) Math.pow(10, s.length() - 1);

        //last：除开最高位，其他位的数字
        int last = n - high * pow;

        if (high == 1) {
            return method_3(pow - 1) + last + 1 + method_3(last);
        } else {
            return pow + high * method_3(pow - 1) + method_3(last);
        }

    }


}