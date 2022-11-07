package com.algs.algs4.fundamentals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class BasicProgrammingModel {

    @Test
    void _1_1_1() {
        int i = (0 + 15) / 2;
        System.out.println(i);

        double v = (0 + 15.0) / 2;
        System.out.println(v);

        double v1 = 2.0 - 6 * 100000000.1;
        System.out.println(v1);

        boolean b = (true && false) || (true && true);
        System.out.println(b);
    }

    @Test
    void _1_1_2() {
        double v = (1 + 2.236) / 2;
        System.out.println(v);

        int i = 1 + 2 + 3 + 4;
        System.out.println(i);

        System.out.println(4.1 >= 4);

        System.out.println(1 + 2 + "3"); // 33
    }

    @Test
    void _1_1_3() {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, c = 0;

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    @Test
    void _1_1_6() {
//        int f = 0;
//        int g = 1;
//        for (int i = 0; i <= 15; i++) {
//            System.out.println(f);
//            f = f + g;
//            g = f - g;
//        }

        int first = 0;
        int second = 1;
        for (int i = 0; i < 15; i++) {
            System.out.println(first);
            int sum = first + second;
            first = second;
            second = sum;
        }
    }

    @Test
    void _1_1_7() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        System.out.printf("%.5f", t);

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        System.out.println();
        System.out.println(sum);

        sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    @Test
    void _1_1_8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));

    }

    @Test
    void _1_1_12() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        System.out.println(Arrays.toString(a));
    }

    @Test
    void _1_1_16() {
        String s = exR1(6);
        System.out.println(s);

        String s1 = exR2(6);
        /**
         * {@link StackOverflowError}
         */
        System.out.println(s1);

    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) {
            return "";
        }
        return s;
    }
}