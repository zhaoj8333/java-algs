package com.algs.algo.bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf1Test {

    @Test
    void count1() {
//        int n = 34520;
//        System.out.println("n  :" + Integer.toBinaryString(n));
//        // 1000 0110 1101 1000
//        System.out.println("n-1:" + Integer.toBinaryString(n - 1));
//        // 1000 0110 1101 0111
//        System.out.println("&  :" + Integer.toBinaryString(n & (n - 1)));
//
//        System.out.println("n-2:" + Integer.toBinaryString(n - 2));
//        // 1000 0110 1101 0110

        for (int i = 0; i < 30; i++) {
            int n = new Random().nextInt();
            Assertions.assertEquals(NumberOf1.count(n), Integer.bitCount(n));
        }

    }
}