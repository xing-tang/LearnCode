package com.open.learncode.剑指offer.每日回顾.day_02;


/**
 * 题目：
 * 数值的整数次方：实现函数double Power(double base,int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题
 * <p>
 * 解题思路：
 * 直接乘法，递归
 * <p>
 * 复杂度分析：
 * 方法一：时间复杂度：O(exponent)   空间复杂度：O(n)
 * 方法二：时间复杂度：O(exponent)   空间复杂度：O(1)
 * 方法三：时间复杂度：O(log(exponent))   空间复杂度：O(1)
 */
public class TestMethod16 {

    public static void main(String[] args) {


        System.out.println(method_1(2,6));

        System.out.println(method_2(2,6));

        System.out.println(method_3(2,32));

    }


    /**
     * 缺点：未考虑指数exponent小于1（零和负数的情况）
     *
     * @param base 底数
     * @param exponent  指数
     * @return
     */
    private static double method_1(double base,int exponent) {

        double result=1.0;
        for (int i = 1; i <=exponent ; i++) {
            result*=base;
        }
        return result;
    }


    /**
     * 当exponent为负数时，先对指数求绝对值，算出次方的结果之后再取倒数
     * 缺点：有可能忘记去检查invalidInput以判断是否出错
     *
     * @param base
     * @param exponent
     * @return
     */
    private static double method_2(double base,int exponent) {

        //无效输入的标记
        boolean invalidInput=false;

        //0的负数次方
        if(base==0.0 && exponent<0){
            invalidInput=true;
            return 0.0;
        }

        //指数为负数
        if(exponent<0) {
            int absExponent=-exponent;
            double result=1.0/method_1(base,absExponent);
            return result;
        }else{
            double result=method_1(base,exponent);
            return result;
        }

    }

    /**
     * 递归：
     * 求base的32次方只需要做5次乘法：先求平方，在平方的基础上求4次方，在4次方的基础上求8次方
     * 在8次方的基础上求16次方，最后在16次方的基础上求32次方
     *
     * 细节：
     * 用右移运算符(>>)代替了求余运算符(%)来判断一个数是奇数还是偶数
     * 位运算的效率比乘除法及求余运算的效率要高很多
     *
     * @param base
     * @param exponent
     * @return
     */
    private static double method_3(double base,int exponent) {
        if(exponent==0)
            return 1;

        if(exponent==1)
            return base;

        double result=method_3(base,exponent>>1);
        result*=result;

        //最后的exponent是奇数时，停止递归
        if((exponent&1)==1)
            result*=base;

        return result;
    }
}