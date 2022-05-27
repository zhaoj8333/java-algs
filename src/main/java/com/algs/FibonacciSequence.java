package com.algs;

import com.algs.util.TimeTool;

/**
 * Get the n-th number of Fibonacci Sequence
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 6, 10, 30, 40, 43};

        int input = inputs[inputs.length - 1];

        TimeTool.check("Fibonacci", () -> fib(input));

        TimeTool.check("Fibonacci Optimized", () -> fibOptimizeByDoubleVar(input));

    }

    /**
     * i  j sum
     * -  -  -  -  -  -  -  -   -  -
     * 0  1  1  2  3  5  8  13 21 44 .... result
     */
    private static int fibOptimizeByDoubleVar(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * @param n index started from 0
     * @return Integer of the n-th number
     */
    private static int fibOptimizeByArray(int n) {
        if (n <= 1) {
            return n;
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }
        return res[n];
    }

    /**
     * 0 1 2 3 4 5 6 .... n
     *
     * 0 1 1 2 3 5 8 .... result
     *
     * By using recursive
     *
     * @param n index started from 0
     * @return Integer of the n-th number
     *
     * @Link {fibonacci_recursive_time_complexity.png}
     */
    public static int fib(int n) {
        return fibRecursively(n);
    }

    private static int fibRecursively(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursively(n - 1) + fibRecursively(n - 2);
    }

}
