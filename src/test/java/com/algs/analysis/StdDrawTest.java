package com.algs.analysis;

import com.algs.util.CollectionUtil;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class StdDrawTest {

    public static void main(String[] args) {
//        StdDraw.point(200, 200);
//        StdDraw.line(10, 10, 100, 100);
//        function();

        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }

    }

    private static void function() {
        int N = 500;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        for (int i = 0; i < N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

}
