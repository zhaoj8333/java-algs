package com.algs.algo.dp;

/**
 * 1, 1, 2, 3, 5, 8, 13
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 15, 20, 40, 46};
//        for (int j : array) {
//            System.out.println("f1(" + j + "): " + f1(j));
//        }
        for (int j : array) {
            System.out.println("f2: " + j + ": " + f2(j));
        }
    }

    /**
     * f(n) = f(n-1) + f(n-2)
     */
    private static int f2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    private static int f1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }
}
