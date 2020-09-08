package com.open.learncode.java.print;

public class PrintDiamond {

    public static void main(String[] args) {
//        print1(7);
//        print2(7);
//        print3(7);
//        print4(7);
//        print5(9);
//        print6(7);
        print7(19);
        print8(19);
    }

    public static void print1(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }

    public static void print2(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 2 * i - 1) {
                    System.out.println("*");
                } else if (k == 1) {
                    System.out.print("*");
                } else if (i != size) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
        }
    }

    public static void print3(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < 2 * (size - i) + 1; k++) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }

    public static void print4(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (size - i) + 1; k++) {
                if (k == 2 * (size - i) + 1) {
                    System.out.println("*");
                } else if (k == 1) {
                    System.out.print("*");
                } else if (i != 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
        }
    }

    public static void print5(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println("*");

        }
        for (int i = 2; i <= size; i++) {
            for (int m = 1; m <= i - 1; m++) {
                System.out.print(" ");
            }
            for (int n = 1; n < 2 * (size - i) + 1; n++) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }

    public static void print6(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 2 * i - 1) {
                    System.out.println("*");
                } else if (k == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
        for (int i = 2; i <= size; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (size - i) + 1; k++) {
                if (k == 2 * (size - i) + 1) {
                    System.out.println("*");
                } else if (k == 1) {
                    System.out.print("*");
                } else if (i != 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
        }
    }

    public static void print7(int size) {
        int temp = size / 2 + 1;
        for (int i = 0; i < size; i++) {
            if (i < temp) {
                for (int j = 1; j < temp - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k < 2 * i + 1; k++) {
                    System.out.print("*");
                }
                System.out.println("*");
            } else {
                for (int m = 0; m < i - temp + 1; m++) {
                    System.out.print(" ");
                }
                for (int n = 2 * size - 3; n > 2 * i - 1; n--) {
                    System.out.print('*');
                }
                System.out.println("*");
            }
        }
    }

    public static void print8(int size) {
        int temp = size / 2 + 1;
        for (int i = 0; i < size; i++) {
            if (i < temp) {
                for (int j = 1; j < temp - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i + 1; k++) {
                    if (k == 2 * i + 1) {
                        System.out.println("*");
                    } else if (k == 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int m = 0; m < i - temp + 1; m++) {
                    System.out.print(" ");
                }
                for (int n = 2 * size - 3; n >= 2 * i - 1; n--) {
                    if (n == 2 * i - 1) {
                        System.out.println("*");
                    } else if (n == 2 * size - 3) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
    }

}
