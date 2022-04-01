package com.open.learncode.java.sort;

/**
 * 猫扑素数
 */
public class Sort_3 {

    public static void main(String[] args) {

        Sort_3 sort = new Sort_3();

        System.out.println(2.6*2.6);
        if (sort.isPrime(2)) {
            System.out.println(5);
        }

        for (int i = 0; i < 10000; i++) {
            if (sort.isMopNumber(i)) {
                if (sort.isPrime(i)) {
                    System.out.println(i);
                }
            }
        }
    }

    /**
     * 是否猫扑素数
     *
     * @param number 传入的整数
     * @return
     */
    private boolean isMopNumber(int number) {
        if (number < 10) {
            return number == 2;
        } else {
            return (number % 10 == 3) && isMopNumber(number / 10);
        }
    }

    /**
     * 是否为素数(质数)
     *
     * @param number
     * @return
     */
    private boolean isPrime(int number) {
        if (number < 2) return false;
        long midNumber = (long) Math.sqrt(number);
        for (long i = 2; i <= midNumber; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

}
