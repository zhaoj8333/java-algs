package com.algs.analysis;

import com.algs.util.DrawUtil;

import java.util.Arrays;
import java.util.Random;

public class StdDrawTest {

    public static void main(String[] args) {
//        DrawUtil.point(200, 200);
//        DrawUtil.line(10, 10, 100, 100);
//        function();

        Random r = new Random();
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = r.nextInt();
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            DrawUtil.filledRectangle(x, y, rw, rh);
        }

    }

    private static void function() {
        int N = 500;
        DrawUtil.setXscale(0, N);
        DrawUtil.setYscale(0, N);
        for (int i = 0; i < N; i++) {
            DrawUtil.point(i, i);
            DrawUtil.point(i, i * i);
            DrawUtil.point(i, i * Math.log(i));
        }
    }

}
