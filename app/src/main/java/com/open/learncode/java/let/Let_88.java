package com.open.learncode.java.let;

public class Let_88 {

    public static void main(String[] args) {

        Let_88 let = new Let_88();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = {2, 5, 6};
        int n = 3;
        let.merge(num1, m, num2, n);


    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                //A大就把A的数组放在更后面
                nums1[index--] = nums1[i--];

            } else {
                nums1[index--] = nums2[j--];

            }
        }
        while (i >= 0) {
            //A大就把A的数组放在更后面
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
        return nums1;
    }

}
