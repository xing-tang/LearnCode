package com.open.learncode.剑指offer.面试题03_数组中的重复数字;

import java.util.Arrays;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或者3。
 */
public class FindDuplicate {

    private static void method_01(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            index = index + 1;
            for (int j = i + 1; j < array.length; j++) {
                index = index + 1;
                if (array[i] == array[j]) {
                    System.out.println("数组下标为" + i + "值是：" + array[i] + " == " + "数组下标为" + j + "值是：" + array[j]);
                }
            }
        }
        System.out.println("method_01()=>=" + index);
    }

    private static boolean method_02(int numbers[], int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);
        int index = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            index = index + 1;
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        System.out.println("method_02()=>=" + index);
        return false;
    }

    public static boolean method_03(int numbers[], int[] duplication) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return false;
            }
        }
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            index = index + 1;
            while (numbers[i] != i) {
                index = index + 1;
                // 现在numbers[i] != i ，设numbers[i] = j,所以如果下面的if成立,就是numbers[i] == numbers[j],说明找到 重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    System.out.println("method_03()=>index=" + index);
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    // 交换numbers[i]和numbers[numbers[i]]
    private static void swap(int[] numbers, int p, int q) {
        int temp = numbers[p];
        numbers[p] = numbers[q];
        numbers[q] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = {0, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
//        method_01(testArray);
//        method_02(testArray, duplication);
        method_03(testArray, duplication);
        for (int i = 0; i < duplication.length; i++) {
            System.out.println(duplication[i]);
        }

    }

}
