package com.algs.algo.bit;

public class NumberOf1 {

    public static int count(int n) {
        int count = 0;
        while (n != 0) {
            n &= n & (n - 1);
            count++;
        }
        return count;
    }

}
