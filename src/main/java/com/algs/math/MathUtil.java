package com.algs.math;

public class MathUtil {

    /**
     * n = 32 -> 2^5
     *     \|/
     * n = 33 -> 5
     */
    public static int lg(int n) {
        for (int i = 2; i < n; i++) {
            if (pow(2, i) <= n && pow(2, i + 1) > n) {
                return i;
            }
        }
        return 0;
    }

    /**
     * m^n
     */
    public static int pow(int m, int n) {
        if (n == 0) {
            return 1;
        }
        int pow = m;
        int k = n;
        if (n < 0) {
            n = -n;
        }
        for (int i = 1; i < n; i++) {
            pow = pow * m;
        }
        if (k < 0) {
            return 1 / pow;
        }
        return pow;
    }

}
